package com.liu.store.controller;

import com.liu.store.controller.ex.*;
import com.liu.store.service.ex.*;
import com.liu.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

public class BaseController {
    public static final int OK = 200;

//    项目中产生的属于ServiceException的异常,都会被拦截到这里进行处理,其结果直接返回给前端
//    又添加了fileUploadException的异常处理
    @ExceptionHandler({ServiceException.class, fileUploadException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名被占用");
        }
        else if(e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册时产生未知异常");
        }
        else if(e instanceof UsernameNotExistException){
            result.setState(7000);
            result.setMessage(e.getMessage());
        }
        else if(e instanceof PasswordErrorException){
            result.setState(6000);
            result.setMessage(e.getMessage());
        }
        else if(e instanceof FindException){
            result.setState(9000);
            result.setMessage(e.getMessage());
        }
        else if(e instanceof UidNotExistException){
            result.setState(7001);
            result.setMessage(e.getMessage());
        }
        else if(e instanceof UpdateException){
            result.setState(9001);
            result.setMessage(e.getMessage());
        }
        else if(e instanceof fileOverSizeException){
            result.setState(9000);
            result.setMessage("文件过大");
        }
        else if(e instanceof fileIOException){
            result.setState(9001);
            result.setMessage("文件读写异常");
        }
        else if(e instanceof fileStateException){
            result.setState(9002);
            result.setMessage("文件状态异常");
        }
        else if(e instanceof fileTypeErrorException){
            result.setState(9003);
            result.setMessage("文件类型错误");
        }
        else if(e instanceof AddressCountLimitException){
            result.setState(4001);
            result.setMessage("用户地址数数目到达上限");
        }
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
