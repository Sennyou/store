package com.liu.store.service;

import com.liu.store.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTest {
    @Autowired
    IDistrictService districtService;

    @Test
    public void getByParent(){
        String parent= "110100";
        List<District> list=districtService.getByParent(parent);
        for (District d:list) {
            System.out.println(d.toString());
        }
    }

    @Test
    public void getNameByCode(){
        String code = "110105";
        System.out.println(districtService.getNameByCode(code));
    }
}
