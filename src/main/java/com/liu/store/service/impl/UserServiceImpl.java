package com.liu.store.service.impl;

import com.liu.store.Mapper.UserMapper;
import com.liu.store.entity.User;
import com.liu.store.service.IUserService;
import com.liu.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) throws UsernameDuplicatedException,InsertException{
//        先用finduserbyusername查看用户名是否被占用
        String username = user.getUsername();
        User result=userMapper.findUserByUsername(username);
        if(result!=null){
            throw new UsernameDuplicatedException("用户名被占用");
        }

//        密码加密处理:MD5
//        串 + 密码 + 串 -> md5算法 , 这个过程重复三次
//        串 = 盐值,盐值是随机字符串
        String odPassword = user.getPassword();
//        获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase(Locale.ROOT);
//        将密码和盐值作为一个整体处理
        String newPassword = getMd5Password(odPassword,salt);
        user.setPassword(newPassword);
        user.setSalt(salt);

//        补充用户信息,补充字段:is_delete=0,createdUser,createdTime,modified_user,modified_time
        user.setIs_delete(0);
        user.setCreated_user(username);
        user.setCreated_user(username);
        Date date=new Date();
        user.setCreated_time(date);
        user.setModified_time(date);


//        用户信息插入数据库
        int row=userMapper.insert(user);
//        若返回值不为一,出错
        if(row!=1){
            throw new InsertException("在用户注册过程中产生了未知异常,用户名:"+username);
        }
        System.out.println("注册成功!");

    }

    public User login(String username,String password) throws UsernameNotExistException,PasswordErrorException, FindException {
        User user;
        try {
            user = userMapper.findUserByUsername(username);
        }catch (Exception e){
            throw new FindException("数据库查询出错:"+e.getMessage());
        }
        if(user==null){
            throw new UsernameNotExistException("用户名不存在");
        }
        String salt = user.getSalt();
        String jiamihou_password = getMd5Password(password,salt);
        if(!jiamihou_password.equals(user.getPassword())){
            throw new PasswordErrorException("密码错误");
        }
        if(user.getIs_delete()==1){
            throw new UsernameNotExistException("用户数据不存在");
        }
        User newUser=new User();
        newUser.setUsername(username);
        newUser.setUid(user.getUid());
        newUser.setAvatar(user.getAvatar());
        return newUser;

    }

    /**
     * 根据uid修改用户密码
     * @param uid 用户uid
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    @Override
    public void changePassword(int uid, String oldPassword, String newPassword,String modifiedUsername) {
        User user;
        try {
            user = userMapper.findUserByUid(uid);
        }catch (Exception e){
            throw new FindException("数据库查询出错");
        }
        if(user == null||user.getIs_delete()==1){
            throw new UidNotExistException("Uid不存在");
        }
        if(!getMd5Password(oldPassword,user.getSalt()).equals(user.getPassword())){
            throw new PasswordErrorException("密码错误");
        }
        newPassword = getMd5Password(newPassword, user.getSalt());
        if(userMapper.changePasswordByUid(uid,modifiedUsername,new Date(),newPassword)!=1){
            throw new UpdateException("更新数据出错");
        }
    }

    @Override
    public void updateUserInfo(User user) {
        User findedUser;
        try{
            findedUser = userMapper.findUserByUid(user.getUid());
        }catch (Exception e){
            throw new FindException("数据库查询出错");
        }
        if(findedUser==null||findedUser.getIs_delete()==1){
            throw new UidNotExistException("用户不存在");
        }
        user.setModified_time(new Date());
        if(userMapper.updateUserInfo(user)!=1){
            throw new UpdateException("更新数据出错");
        }
    }

    @Override
    public User findUserByUid(int uid) {
        User user;
        try{
            user = userMapper.findUserByUid(uid);
        }catch (Exception e){
            throw new FindException("数据库查询出错");
        }
        if(user==null||user.getIs_delete()==1){
            throw new UidNotExistException("用户不存在");
        }
        User returnUser=new User();
        returnUser.setPhone(user.getPhone());
        returnUser.setEmial(user.getEmial());
        returnUser.setGender(user.getGender());
        return returnUser;
    }

    /**
     * 输入用户密码和盐值,得到MD5加密结果
     * @param password 用户设置密码
     * @param salt 随机生成的盐值
     * @return 加密后的密码,String
     */
    public String getMd5Password(String password,String salt){
        for(int i=0;i<3;i++)
            password = DigestUtils.md5DigestAsHex( (salt+password+salt).getBytes(StandardCharsets.UTF_8) ).toString().toUpperCase(Locale.ROOT);
        return password;
    }
}
