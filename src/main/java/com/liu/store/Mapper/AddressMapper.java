package com.liu.store.Mapper;

import com.liu.store.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据用户uid查询用户的收货地址
     * @param uid 用户uid
     * @return 收货地址的list
     */
    List<Address> findByUid(int uid);

    /**
     * 根据uid,将用户当前默认地址设为非默认
     * @param uid 用户uid
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return  受影响行数
     */
    Integer updateNotDefault(@Param("uid") int uid, @Param("modified_user") String modifiedUser,
                             @Param("modified_time") Date modifiedTime);

    /**
     * 根据aid,将收货地址设为默认收货地址
     * @param aid aid
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 受影响行数
     */
    Integer updateDefault(@Param("aid")int aid, @Param("modified_user")String modifiedUser,
                          @Param("modified_time")Date modifiedTime);

    /**
     * 根据aid查询收货地址
     * @param aid aid
     * @return 收货地址address对象
     */
    Address findByAid(int aid);

    /**
     * 根据aid删除收货地址
     * @param aid aid
     * @return 受影响行数
     */
    Integer deleteByAid(Integer aid);
}
