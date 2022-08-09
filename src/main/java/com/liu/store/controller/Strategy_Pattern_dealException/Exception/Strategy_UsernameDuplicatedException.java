package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class Strategy_UsernameDuplicatedException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(4000);
        result.setMessage("用户名被占用");
    }

    @Override
    public String getType() {
        return ExceptionEnum.UsernameDuplicatedException.getClassName();
    }
}
