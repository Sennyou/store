package com.liu.store.service;

import com.liu.store.entity.Address;
import com.liu.store.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class AddressServiceTest {
    @Autowired
    AddressServiceImpl addressService;

    @Test
    public void insert(){
        int uid=4;
        String username="qwe";
        Address address=new Address();
        address.setName("abc");
        address.setPhone("9999999");
        address.setProvinceCode("777777");
        address.setProvinceName("北京");
        address.setCityCode("666666");
        address.setCityName("北京");
        address.setAreaCode("111111");
        address.setAreaName("朝阳");
        address.setTag("101010");
        address.setTel("1231231123");
        address.setZip("100000");
        addressService.insert(uid,username,address);

    }

    @Test
    public void geyByUid(){
        List<Address> list=addressService.getByUid(9);
        System.out.println(list);
    }

    @Test
    public void setDefaultByAid(){
        addressService.setDefaultByAid(9,14,"2022年7月26日21:44:00");
    }

    @Test
    public void deleteByAid(){
        int aid = 17;
        addressService.deleteByAid(aid,9,"刘东博");
    }
}
