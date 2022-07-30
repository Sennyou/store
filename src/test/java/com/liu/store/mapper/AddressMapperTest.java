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
import java.util.List;
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

    @Test
    public void findByUid(){
        int uid =9;
        List<Address> list=addressMapper.findByUid(uid);
        for (Address a:list) {
            System.out.println(a);
        }
    }

    @Test
    public void updateNotDefault(){
        int a = addressMapper.updateNotDefault(9,"2022年7月26日20:03:41",new Date());
        System.out.println(a);
    }
    @Test
    public void updateDefault(){
        int a = addressMapper.updateDefault(15,"2022年7月26日20:03:41",new Date());
        System.out.println(a);
    }

    @Test
    public void findByAid(){
        System.out.println(addressMapper.findByAid(15));
    }

    @Test
    public void deleteByAid(){
        int aid = 16;
        int n=addressMapper.deleteByAid(aid);
        System.out.println("n = " + n);
    }
}
