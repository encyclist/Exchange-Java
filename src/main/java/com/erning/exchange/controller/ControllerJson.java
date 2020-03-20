package com.erning.exchange.controller;

import com.erning.exchange.util.MsgHandlerRuntimeException;
import com.erning.exchange.util.StatusMsgHandlerRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ControllerJson
 * 统一异常处理，统一json 格式
 * 2019/6
 * wjd
 */
@ControllerAdvice
public abstract class ControllerJson {

    private Logger logger = LoggerFactory.getLogger(ControllerJson.class) ;

    Map<String, Object> success(Object info){
        return result("0", "操作成功",info) ;
    }

    Map<String, Object> error(Object info){
        return result("1","操作失败",info) ;
    }

    Map<String, Object> error(Object info, int state){
        return result(state+"","操作失败",info) ;
    }

    Map<String, Object> error(Object info, int state , String msg){
        return result(state+"",msg,info) ;
    }

    private Map<String, Object> result(String state , String message, Object info){
        Map<String, Object> result = new HashMap<>() ;
        result.put("code",state) ;
        result.put("message",message) ;
        result.put("data",info);
        return result;
    }

    /**
     * 输出异常，并返回统一的 json 数据
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> allExceptionHandler(Throwable t){
        // 将提示信息传给前段
        if(t instanceof MsgHandlerRuntimeException){
            return result("1",t.getMessage(),"") ;
        }

        if(t instanceof StatusMsgHandlerRuntimeException){
            return result(((StatusMsgHandlerRuntimeException) t).getStatus(),t.getMessage(),"") ;
        }
        // 其他异常，错误都统一作为 服务器内部异常处理
        logger.error("controller handler error :",t);
        return result("500","服务异常，请联系客服处理!","服务异常，请联系客服处理!") ;
    }

}
