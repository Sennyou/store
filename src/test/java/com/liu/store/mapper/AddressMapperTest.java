package com.liu.store.mapper;

import com.liu.store.Mapper.AddressMapper;
import com.liu.store.entity.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

@SpringBootTest
public class AddressMapperTest {
    @Autowired
    AddressMapper addressMapper;

    @Test
    public void insert(){
        Address address=new Address();
        address.setUid(9);
        address.setName("qwe");
        address.setPhone("123445");
        address.setProvinceCode("123456");
        address.setProvinceName("山东");
        address.setCityCode("654321");
        address.setCityName("芜湖");
        address.setCreated_time(new Date());
        address.setCreated_user("管理员");
        addressMapper.insert(address);
    }

    @Test
    public void countUserAddressByUid(){
        int a=addressMapper.countUserAddressByUid(9);
        System.out.println(a);
    }
}
