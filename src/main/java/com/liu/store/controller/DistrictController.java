package com.liu.store.controller;

import com.liu.store.entity.District;
import com.liu.store.service.IDistrictService;
import com.liu.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{
    @Autowired
    private IDistrictService districtService;
//    districts下的所有请求都被拦截到这个方法中,这会拦截所有的/district/*路径,*允许为空
//    若是请求路径为/districts,这种也要被拦截到这里,就在RequestMapping中加""空字符串
    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent){
        List<District> list = districtService.getByParent(parent);
        return new JsonResult<>(OK,list);
    }
}
