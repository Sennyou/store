package com.liu.store.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.liu.store.entity.District;
import com.liu.store.Mapper.DistrictMapper;

import java.util.List;

@SpringBootTest
public class DistrictMapperTest {
    @Autowired
    DistrictMapper districtMappper;

    @Test
    public void findByParent(){
        List<District> districtList=districtMappper.findByParent("110000");
        for(int i=0;i<districtList.size();i++){
            System.out.println(districtList.get(i).toString());
        }
    }

    @Test
    public void findNameByCode(){
        String code = "110105";
        System.out.println(districtMappper.findNameByCode(code));
    }
}
