package com.liu.store.service;

import com.liu.store.entity.Address;
import com.liu.store.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
}
