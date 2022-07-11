package com.liu.store.mapper;

import com.liu.store.Mapper.UserMapper;
import com.liu.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

// @SpringBootTest 表示当前类是一个测试类,不会同项目一起打包
@SpringBootTest
// 老版本需要在这里添加 @Runwith(SpringRunner.class),新版本不用
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert(){
        User user=new User();
        user.setUsername("刘东博");
        user.setGender(1);
        user.setPassword("123456");
        System.out.println(userMapper.insert(user));

    }
    @Test
    public void find(){
        User user = userMapper.findUserByUsername("qwe");
        System.out.println(user);
    }

    @Test
    public void changePassword(){
        User user = userMapper.findUserByUsername("刘东博");
        System.out.println(user.toString());
        int uid=user.getUid();
        int a = userMapper.changePasswordByUid(3,"西红柿",new Date(),"987654321");
        System.out.println("int:"+a);
        user = userMapper.findUserByUsername("刘东博");
        System.out.println(user.toString());
    }

    @Test
    public void findUserByUid(){
        User user = userMapper.findUserByUid(9);
        System.out.println(user.toString());
    }

    @Test
    public void updateUserInfo(){
        System.out.println(userMapper.findUserByUid(4).toString());
        User user=new User();
        user.setUid(4);
        user.setPhone("11111");
        user.setEmial("22222");
        //user.setModified_user("星期三");

        System.out.println(userMapper.updateUserInfo(user));
        System.out.println(userMapper.findUserByUid(4));
    }

    @Test
    public void updateUserAvatar(){
        String avatar="C:\\Users\\HP\\Desktop\\照片文档\\涩图\\98776644_p0";
        System.out.println(userMapper.updateUserAvatar(4,avatar,"星期六",new Date()));
        System.out.println(userMapper.findUserByUid(4));
    }
}
