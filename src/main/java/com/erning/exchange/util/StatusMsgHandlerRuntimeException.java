package com.erning.exchange.util;

public class StatusMsgHandlerRuntimeException extends RuntimeException {

    private String status ;

    public StatusMsgHandlerRuntimeException(String msg, String status){
        super(msg);
        this.status =status ;
    }

    public String getStatus(){
        return status ;
    }
}
