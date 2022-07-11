package com.liu.store.service;

import com.liu.store.entity.Address;

public interface IAddressService {
    /**
     * 插入一条用户收货地址
     * @param uid 用户uid
     * @param username 修改/创建人
     * @param address 收货地址数据
     */
    void insert(int uid,String username,Address address);

}
