package com.liu.store.controller.Strategy_Pattern_dealException.Exception;

import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionEnum;
import com.liu.store.controller.Strategy_Pattern_dealException.ExceptionStrategy;
import com.liu.store.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class Strategy_fileStateException implements ExceptionStrategy {
    @Override
    public void setResult(JsonResult<Void> result) {
        result.setState(9002);
        result.setMessage("文件状态异常");
    }

    @Override
    public String getType() {
        return ExceptionEnum.fileStateException.getClassName();
    }
}
