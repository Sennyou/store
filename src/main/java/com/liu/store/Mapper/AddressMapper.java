package com.liu.store.Mapper;

import com.liu.store.entity.Address;
import org.springframework.stereotype.Repository;

//收货地址模块持久层接口
@Repository
public interface AddressMapper {
    /**
     * 插入一条用户的收货地址
     * @param address 封装的收货地址信息
     * @return 受影响行数
     */
    Integer insert(Address address);

    /**
     * 根据用户uid返回用户收货地址数目
     * @param uid 用户uid
     * @return 用户收货地址数目
     */
    Integer countUserAddressByUid(int uid);


}
