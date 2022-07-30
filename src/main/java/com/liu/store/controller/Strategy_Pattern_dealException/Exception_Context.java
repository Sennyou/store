package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.util.JsonResult;

public class Exception_Context {
    public static void set(String className, JsonResult<Void> result){
        ExceptionStrategy strategy = StragegyFactory.getInstance().get(className);
        if(strategy==null){
            throw new IllegalArgumentException("异常未注册,未知异常:"+className);
        }
        strategy.setResult(result);
    }
}
