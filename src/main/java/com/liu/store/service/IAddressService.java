package com.liu.store.service;

import com.liu.store.entity.Address;

import java.util.Date;
import java.util.List;

public interface IAddressService {
    /**
     * 插入一条用户收货地址
     * @param uid 用户uid
     * @param username 修改/创建人
     * @param address 收货地址数据
     */
    void insert(int uid,String username,Address address);

    /**
     * 根据用户uid查询用户的收货地址
     * @param uid 用户uid
     * @return 收货地址的list
     */
    List<Address> getByUid(int uid);

    /**
     * 更改用户默认收获地址,根据aid
     * @param uid 用户uid
     * @param aid 默认地址的aid
     * @param modifiedUser 修改人
     */
    void setDefaultByAid(int uid , int aid, String modifiedUser);

    /**
     * 根据aid删除收货地址
     * @param aid aid
     * @param uid uid
     * @Param username username
     */
    void deleteByAid(int aid,int uid,String username);

}
