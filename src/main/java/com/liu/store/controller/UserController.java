package com.liu.store.controller;

import com.liu.store.controller.ex.*;
import com.liu.store.entity.User;
import com.liu.store.service.ex.InsertException;
import com.liu.store.service.ex.UsernameDuplicatedException;
import com.liu.store.service.impl.UserServiceImpl;
import com.liu.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("user")
public class UserController extends BaseController{
    @Autowired
    private UserServiceImpl userService;
//    spring 默认文件大小单位是字节,因此这个是10MB
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;

//    接收文件的类型
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmg");
        AVATAR_TYPE.add("image/gif");


    }

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user=userService.login(username,password);
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JsonResult<>(OK,user);
    }
    @RequestMapping("changePassword")
    public JsonResult<String> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        //当没有时会返回null,如果把这个null赋给了一个数值类型(int ，byte ，double，boolean等)会抛出NullPointerException
        if(uid==null){
            return new JsonResult<>(300,"请登录");
        }
        String username = session.getAttribute("username").toString();
        userService.changePassword(uid,oldPassword,newPassword,username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("updateUserInfo")
    public JsonResult<String> updateUserInfo(User user,HttpSession session){
        Integer uid=(Integer) session.getAttribute("uid");
        //当没有时会返回null,如果把这个null赋给了一个数值类型(int ，byte ，double，boolean等)会抛出NullPointerException
        if(uid==null){
            return new JsonResult<>(300,"请登录");
        }
        String username = session.getAttribute("username").toString();
        user.setModified_user(username);
        user.setUid(uid);
        userService.updateUserInfo(user);
        return new JsonResult<>(OK);
    }

    @RequestMapping("findUserByUid")
    public JsonResult<User> findUserByUid(HttpSession session){
        int uid=(Integer) session.getAttribute("uid");
        return new JsonResult<>(OK,userService.findUserByUid(uid));
    }

    /**
     * MultpartFile接口是SpringMVC中提供的一个接口,他可以接收任何类型的文件
     * @RequestParam 表示请求中的参数,表示这参数接收哪个前端传来的参数
     * @param session 用户session
     * @param file 用户上传的头像文件
     * @return 返回用户头像在项目中的地址
     */
    @RequestMapping("updateUserAvater")
    public JsonResult<String> updateUserAvatar(HttpSession session,
                                               @RequestParam("file")MultipartFile file){
        if(file.isEmpty()){
            throw new fileIsNullException("文件为空");
        }
        if(file.getSize()>AVATAR_MAX_SIZE){
            throw new fileOverSizeException("文件过大");
        }
        String contentType = file.getContentType();
        System.out.println(contentType);
        if(!AVATAR_TYPE.contains(contentType)){
            throw new fileTypeErrorException("文件类型错误");
        }
        //获取到file在电脑里的实际路径
        String parent = session.getServletContext().getRealPath("upload");
        //指向这个路径,并看看是否存在
        File dir = new File(parent);
        if(!dir.exists()){
            dir.mkdirs();
        }
        //得到上传文件的文件名,这个函数的返回值是 abc.png 这样的名称加后缀
        String originalFilename = file.getOriginalFilename();
        System.out.println("OriginalFilename=" + originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase(Locale.ROOT) + suffix;
        System.out.println("new filename = "+filename);
//        destination, 目的地,目的操作数
//
        File dest = new File(dir,filename);
        try {
            file.transferTo(dest);  //将file文件中的数据,写入到dest文件中,前提是两个文件后缀相同
        } catch (IllegalStateException e){
            throw new fileStateException("文件状态异常");
        }catch (IOException e) {
            throw new fileUploadException("文件读写异常");
        }

        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        String avatar = "/upload/"+filename;
        System.out.println("avatar = "+avatar);
        System.out.println(uid);
        System.out.println(username);
        userService.updateUserAvatar(uid,avatar,username);
        return new JsonResult<>(OK,avatar);
    }

}
