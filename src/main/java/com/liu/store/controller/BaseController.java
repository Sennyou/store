package com.liu.store.controller;

import com.liu.store.controller.Strategy_Pattern_dealException.StrategyHolder;
import com.liu.store.controller.ex.*;
import com.liu.store.service.ex.*;
import com.liu.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;
    @Resource
    StrategyHolder strategyHolder;

//    项目中产生的属于ServiceException的异常,都会被拦截到这里进行处理,其结果直接返回给前端
//    又添加了fileUploadException的异常处理
    @ExceptionHandler({ServiceException.class, fileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        System.out.println("the class of exception is: "+e.getClass().toString());
        strategyHolder.setResult(result,e.getClass().toString());
        return result;

    }

    /**
     *获取当前用户uid
     * @param httpSession session对象
     * @return Integer 当前登录用户uid
     */
    protected final Integer getUidFromSession(HttpSession httpSession){
        return Integer.valueOf(httpSession.getAttribute("uid").toString());
    }

    /**
     * 获取当前用户用户名
     * @param httpSession session对象
     * @return String 当前登录用户用户名
     */
    protected final String getUsernameFromSession(HttpSession httpSession){
        return httpSession.getAttribute("username").toString();
    }

}
