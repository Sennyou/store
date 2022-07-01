package com.liu.store.service;

import com.liu.store.Mapper.UserMapper;
import com.liu.store.entity.User;
import com.liu.store.service.ex.ServiceException;
import com.liu.store.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void regTest(){
        try {
            User user =new User();
            user.setUsername("刘东博");
            user.setPassword("123456");
            userService.reg(user);
        } catch (ServiceException exception) {
            System.out.println(exception.getClass().getName());
            System.out.println(exception.getMessage());
        }
    }
     @Test
    public void login(){
        try{
            String username="刘东博";
            String password="123456";
            System.out.println(userService.login(username,password));
        }catch (ServiceException e){
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }
     }

     @Test
    public void updateUserInfo(){
        String phone="1234567";
        String email="9876543";
        User user=new User();
        user.setUid(4);
        user.setEmial(email);
        user.setPhone(phone);
        user.setGender(1);
         try {
             userService.updateUserInfo(user);
         } catch (Exception e) {
             System.out.println(e.getClass().getName());
             System.out.println(e.getMessage());
         }
     }
}
