package com.erning.exchange.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erning.exchange.dao.BaseDao;
import com.erning.exchange.entity.Exchange;
import com.erning.exchange.util.HttpUtil;
import com.erning.exchange.util.MsgHandlerRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :二宁
 * @date :Created in 2019/11/12 9:29
 */
@Service
public class BaseService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static int failureCount = 0;

    @Autowired
    private BaseDao baseDao;

    public void update() {
        if (failureCount >= 10){
            failureCount = 0;
            return;
        }
        // https://www.exchangerate-api.com/docs/supported-currencies
        String result = HttpUtil.sendGet("https://prime.exchangerate-api.com/v5/d4a51cdfd3edb47b406668bb/latest/USD");
        if (result != null){
            JSONObject jsonObject = JSON.parseObject(result);
            long updateTime = jsonObject.getLongValue("time_last_update");
            JSONObject array = jsonObject.getJSONObject("conversion_rates");
            for (String key : array.keySet()) {
                try{
                    float value = array.getFloatValue(key);
//                    System.out.println(key+":"+value);
                    Exchange exchange = baseDao.getWithCode(key);
                    if (exchange == null){
                        exchange = new Exchange(key,value,updateTime);
                        baseDao.insert(exchange);
                    }else{
                        exchange.setExchange(value);
                        exchange.setUpdateTime(updateTime);
                        baseDao.update(exchange);
                    }
                }catch (Exception e){
                    logger.error(e.getMessage());
                }
            }
            failureCount = 0;
        }else{
            failureCount++;
            update();
        }
    }

    public List<Map<String,Object>> exchange(double value, String source, String[] targets) {
        Exchange usdExchange = baseDao.getWithCode(source.toUpperCase());
        if (usdExchange == null){
            throw new MsgHandlerRuntimeException("源币种不存在");
        }
        // 等于多少美元
        double usd = value / usdExchange.getExchange();

        List<Map<String,Object>> list = new ArrayList<>(targets.length);
        for (String target:targets){
            Map<String,Object> map = new HashMap<>(8);
            map.put("source",source);
            map.put("target",target);
            map.put("sourceValue",value);
            Exchange exchange = baseDao.getWithCode(target.toUpperCase());
            if (exchange != null){
                double targetMoney = usd * exchange.getExchange();
                map.put("success",1);
                map.put("targetValue",targetMoney);
                map.put("updateTime",exchange.getUpdateTime());
                map.put("currencyName",exchange.getCurrencyName());
                map.put("country",exchange.getCountry());
                map.put("updateTimeStr",sdf.format(exchange.getUpdateTime()*1000));
                double ex = 1.0 / usdExchange.getExchange() * exchange.getExchange();
                map.put("exchange",ex);
            }else{
                map.put("success",0);
                map.put("targetValue","NaN");
                map.put("updateTime","");
                map.put("updateTimeStr","");
                map.put("currencyName","");
                map.put("country","");
                map.put("exchange","NaN");
            }
            list.add(map);
        }
        return list;
    }
}