package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;

public class Strategy_AddressCountLimitException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(4001);
        result.setMessage("用户收货地址数目达到上限");
    }

    @Override
    public String getType() {
        return ExceptionEnum.AddressCountLimitException.getClassName();
    }
}
