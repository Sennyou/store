package com.liu.store.Mapper;

import com.liu.store.entity.District;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistrictMapper {

    /**
     * 根据父代码查询子区域
     * @param parent 父代码
     * @return 子区域的List
     */
    List<District> findByParent(String parent);

    /**
     * 根据code查询对应的省市区名称
     * @param code 要查询的行政代码
     * @return code对应的地区名称
     */
    String findNameByCode(String code);
}
