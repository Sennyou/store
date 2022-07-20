package com.liu.store.controller;

import com.liu.store.entity.Address;
import com.liu.store.service.impl.AddressServiceImpl;
import com.liu.store.util.JsonResult;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("address")
public class AddressController extends BaseController{
    @Autowired
    private AddressServiceImpl addressService;

    @RequestMapping("new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session){
        System.out.println(address);
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.insert(uid,username,address);
        return new JsonResult<>(OK);
    }
}
