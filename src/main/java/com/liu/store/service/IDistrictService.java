package com.liu.store.service;

import com.liu.store.entity.District;

import java.util.List;

public interface IDistrictService {
    /**
     * 根据父代码查找子区域列表
     * @param parent 父代码
     * @return 子区域的list
     */
    List<District> getByParent(String parent);

    /**
     * 根据code查找对应的省市区名称
     * @param code 要查找的省市区code
     * @return String 对应的省市区名称
     */
    String getNameByCode(String code);
}
