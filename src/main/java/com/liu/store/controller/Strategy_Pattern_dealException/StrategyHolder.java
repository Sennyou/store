package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.util.JsonResult;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
@Component
public class StrategyHolder {
    @Resource
    private Map<String,ExceptionStrategy> map ;

    public void setMap(Map<String, ExceptionStrategy> map) {
        this.map = map;
    }

    public void setResult(JsonResult<Void> result, String classname){
        getBean(classname).setResult(result);
    }

    public String getType(String desc) {
        return getBean(desc).getType();
    }

    private ExceptionStrategy getBean(String type) {
        // 根据配置中的别名获取该策略的实现类
        String target = findByClassName(type);
        ExceptionStrategy entStrategy = map.get(target);
        if (entStrategy == null) {
            // 找不到对应的策略的实现类，抛出异常
            throw new IllegalArgumentException("please input right value");
        }
        return entStrategy;
    }
    private String findByClassName(String className){
        for (ExceptionEnum e:ExceptionEnum.values()) {
            if(e.getClassName().equals(className))
                return e.getType();
        }
        return null;
    }
}
