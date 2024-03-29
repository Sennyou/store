package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class Strategy_fileIsNullException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(9004);
        result.setMessage("文件为空");
    }

    @Override
    public String getType() {
        return ExceptionEnum.fileIsNullException.getClassName();
    }
}
