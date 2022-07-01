package com.liu.store.service;

import com.liu.store.entity.User;
//用户模块业务层接口
public interface IUserService {
    /**
     * 注册用户
     * @param user 用户数据对象
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username 输入的用户名
     * @param password  输入的密码
     */
    User login(String username,String password);

    /**
     * 根据uid修改用户密码
     * @param uid 用户uid
     * @param oldPassword 用户原密码
     * @param newPassword 新密码
     * @param modifiedUsername 修改人的用户名
     */
    void changePassword(int uid, String oldPassword, String newPassword,String modifiedUsername);

    /**
     * 根据用户uid更新用户手机号和邮箱
     * @param User 封装用户修改数据
     */
    void updateUserInfo(User user);

    /**
     * 通过uid查找用户数据
     * @param uid
     * @return
     */
    User findUserByUid(int uid);
}
