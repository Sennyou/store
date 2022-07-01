package com.liu.store.controller;

import com.liu.store.entity.User;
import com.liu.store.service.ex.InsertException;
import com.liu.store.service.ex.UsernameDuplicatedException;
import com.liu.store.service.impl.UserServiceImpl;
import com.liu.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JsonResult<User>(OK,user);
    }
    @RequestMapping("changePassword")
    public JsonResult<String> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        //当没有时会返回null,如果把这个null赋给了一个数值类型(int ，byte ，double，boolean等)会抛出NullPointerException
        if(uid==null){
            return new JsonResult<String>(300,"请登录");
        }
        String username = session.getAttribute("username").toString();
        userService.changePassword(uid,oldPassword,newPassword,username);
        return new JsonResult<String>(OK);
    }

    @RequestMapping("updateUserInfo")
    public JsonResult<String> updateUserInfo(User user,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        //当没有时会返回null,如果把这个null赋给了一个数值类型(int ，byte ，double，boolean等)会抛出NullPointerException
        if(uid==null){
            return new JsonResult<String>(300,"请登录");
        }
        String username = session.getAttribute("username").toString();
        user.setModified_user(username);
        user.setUid(uid);
        userService.updateUserInfo(user);
        return new JsonResult<String>(OK);
    }

    @RequestMapping("findUserByUid")
    public JsonResult<User> findUserByUid(HttpSession session){
        int uid=(Integer) session.getAttribute("uid");
        return new JsonResult<>(OK,userService.findUserByUid(uid));
    }

}
