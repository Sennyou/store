package com.liu.store.Mapper;

import com.liu.store.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

/** 用户模块的持久层接口 */
@Repository
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return int 受影响的行数
     * */
    Integer insert(User user);

    /**
     * 通过用户名查询用户
     * @param 要查询的用户名
     * @return 如果找到返回查询到的用户,否则返回NULL
     * */
    User findUserByUsername(String username);

    /**
     * 根据uid修改用户密码
     * @param uid 用户uid
     * @param modifiedUser 修改人
     * @param modifiedTime  修改时间
     * @param newPassword   新密码
     * @return  被影响的行数
     */
    Integer changePasswordByUid(@Param("uid") int uid,@Param("modifiedUser") String modifiedUser,
                                @Param("modifiedTime") Date modifiedTime, @Param("newPassword") String newPassword);

    /**
     * 根据uid查询用户
     * @param uid 要查询的uid
     * @return  如果找到返回用户数据,否则返回null
     */
    User findUserByUid(int uid);

    /**
     * 根据uid修改用户电话号和邮箱
     * @param User 封装用户要修改的数据
     * @return 受影响的行数
     */
    Integer updateUserInfo(User user);

    /**
     * 更新用户头像,根据用户uid
     * @param uid  用户uid
     * @param avatar 用户头像文件的路径
     * @param modifiedUser 修改人的用户名
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updateUserAvatar(int uid,String avatar,String modifiedUser,Date modifiedTime);
}
