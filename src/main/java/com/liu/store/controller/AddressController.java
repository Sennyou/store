package com.liu.store.controller;

import com.liu.store.entity.Address;
import com.liu.store.service.impl.AddressServiceImpl;
import com.liu.store.util.JsonResult;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("address")
public class AddressController extends BaseController{
    @Autowired
    @Resource
    private AddressServiceImpl addressService;

    @RequestMapping("new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        System.out.println(address);
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.insert(uid,username,address);
        return new JsonResult<>(OK);
    }

//    对应的请求地址是/address/,和/address
    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getAddresses(HttpSession session){
        Integer uid = getUidFromSession(session);
        if(uid==null){
            return new JsonResult<>(300,null);
        }
        return new JsonResult<>(OK,addressService.getByUid(uid));

    }
    @RequestMapping("setDefault")
    public JsonResult<String> setDefault(int aid,HttpSession session){
        System.out.println(aid);
        Integer uid = getUidFromSession(session);
        if (uid==null){
            return new JsonResult<>(300,null);
        }
        System.out.println(uid);
        String username = getUsernameFromSession(session);
        addressService.setDefaultByAid(uid,aid,username);
        return new JsonResult<>(OK);
    }

    @RequestMapping("{aid}/delete")
    public JsonResult<Void> deleteAddress(@PathVariable("aid") int aid, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.deleteByAid(aid,uid,username);
        return new JsonResult<>(OK);
    }
}
