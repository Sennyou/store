package com.liu.store.service.impl;

import com.liu.store.Mapper.DistrictMapper;
import com.liu.store.entity.District;
import com.liu.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        List<District> list = districtMapper.findByParent(parent);
//       为了节省网络开销,将不必要的字段设为null
        for (District d:list) {
            d.setParent(null);
            d.setId(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
