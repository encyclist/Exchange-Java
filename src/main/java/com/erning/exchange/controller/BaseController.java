package com.erning.exchange.controller;

import com.erning.exchange.service.BaseService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author :二宁
 * @date :Created in 2019/11/12 9:30
 */
@Controller
@RequestMapping(value = "/base")
public class BaseController extends ControllerJson {
    @Resource
    private BaseService baseService;

    @RequestMapping("/update")
    @ResponseBody
    Map<String, Object> update(String key) {
        if (key==null || !key.equals("erning2020")){
            return error("一月2000次，珍惜啊");
        }
        baseService.update();
        return success("");
    }

    @RequestMapping("/exchange")
    @ResponseBody
    Map<String, Object> exchange(String money,String sourceCode,String targetCodes) {
        if (TextUtils.isEmpty(money))
            return error("金额不能为空");
        if (TextUtils.isEmpty(sourceCode))
            return error("币种不能为空");
        if (TextUtils.isEmpty(targetCodes))
            return error("币种列表不能为空");

        double value;
        try {
            value = Double.parseDouble(money);
        }catch (Exception e){
            return error("金额错误");
        }

        String[] codes = targetCodes.split(",");
        return success(baseService.exchange(value,sourceCode,codes));
    }
}