package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;

public class Strategy_UsernameNotExistException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(7000);
        result.setMessage("用户名不存在");
    }

    @Override
    public String getType() {
        return ExceptionEnum.UsernameNotExistException.getClassName();
    }
}
