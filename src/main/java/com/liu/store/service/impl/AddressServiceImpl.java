package com.liu.store.service.impl;

import com.liu.store.Mapper.AddressMapper;
import com.liu.store.entity.Address;
import com.liu.store.service.IAddressService;
import com.liu.store.service.ex.AddressCountLimitException;
import com.liu.store.service.ex.AddressNotExistException;
import com.liu.store.service.ex.InsertException;
import com.liu.store.service.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    @Override
    public List<Address> getByUid(int uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address a:list
             ) {
            a.setCreated_time(null);
            a.setCreated_user(null);
            a.setModified_time(null);
            a.setModified_user(null);
        }
        return list;

    }

    @Override
    public void setDefaultByAid(int uid, int aid, String modifiedUser) {
        Address address = addressMapper.findByAid(aid);
        if(address==null || address.getUid()!=uid){
            throw new AddressNotExistException("该地址不存在");
        }
        int a = addressMapper.updateNotDefault(uid,modifiedUser,new Date());
        System.out.println("a = " + a);
        int b=addressMapper.updateDefault(aid,modifiedUser,new Date());
        System.out.println("b = " + b);
        if(b==0){
            throw new AddressNotExistException("该地址不存在");
        }
    }

    @Override
    public void deleteByAid(int aid, int uid, String username) {
        Address address = addressMapper.findByAid(aid);
        if(address == null || !address.getUid().equals(uid)){
            throw new AddressNotExistException("收货地址不存在");
        }
        int n= addressMapper.deleteByAid(aid);
        if(n!=1){
            throw new UpdateException("更新数据库发生未知异常");
        }
        List<Address> list = getByUid(uid);

        if (address.getIsDefault()==1) {
            if(!list.isEmpty()){
                address = list.get(0);
                setDefaultByAid(uid,address.getAid(),username);

            }
        }
    }
}
