package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.util.JsonResult;

public interface ExceptionStrategy {
    void setResult(JsonResult<Void> result);
    String getType();
}
