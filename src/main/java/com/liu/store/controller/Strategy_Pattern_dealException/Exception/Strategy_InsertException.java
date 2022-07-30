package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;

public class Strategy_InsertException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(5000);
        result.setMessage("注册时产生未知异常");
    }

    @Override
    public String getType() {
        return ExceptionEnum.InsertException.getClassName();
    }
}
