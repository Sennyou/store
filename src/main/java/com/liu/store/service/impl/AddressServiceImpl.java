package com.liu.store.service.impl;

import com.liu.store.Mapper.AddressMapper;
import com.liu.store.entity.Address;
import com.liu.store.service.IAddressService;
import com.liu.store.service.ex.AddressCountLimitException;
import com.liu.store.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private DistrictServiceImpl districtService;

//    从配置文件中读取最大地址数目
    @Value("${user.address.max-count}")
    private int MAX_ADDRESS_COUNT = 20;
    @Override
    public void insert(int uid, String username, Address address) {
        int n= addressMapper.countUserAddressByUid(uid);
        if(n>=MAX_ADDRESS_COUNT){
            throw new AddressCountLimitException("用户收货地址数目到达上限");
        }
        address.setIsDefault(0);
        if(n==0){
            address.setIsDefault(1);
        }
        address.setUid(uid);
        address.setCreated_user(username);
        address.setCreated_time(new Date());
        address.setModified_user(username);
        address.setModified_time(new Date());
//        为code查询name,并写入address
        //address.setProvinceName(districtService.getNameByCode(address.getProvinceCode()));
        address.setCityName(districtService.getNameByCode(address.getCityCode()));
        address.setAreaName(districtService.getNameByCode(address.getAreaCode()));

        if(addressMapper.insert(address)!=1){
            throw new InsertException("新建收货地址发生异常");
        }
    }
}
