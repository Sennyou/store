package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.controller.Strategy_Pattern_dealException.Exception.*;

import javax.xml.ws.Holder;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StragegyFactory {
    private Map<String,ExceptionStrategy> map ;
    private StragegyFactory() {
        List<ExceptionStrategy> list = new ArrayList<>();
        list.add(new FindException());
        list.add(new Strategy_AddressCountLimitException());
        list.add(new Strategy_AddressNotExistException());
        list.add(new Strategy_fileIOException());
        list.add(new Strategy_fileIsNullException());
        list.add(new Strategy_fileOverSizeException());
        list.add(new Strategy_fileStateException());
        list.add(new Strategy_fileUploadException());
        list.add(new Strategy_fileTypeErrorException());
        list.add(new Strategy_InsertException());
        list.add(new Strategy_PasswordErrorException());
        list.add(new Strategy_UidNotExistException());
        list.add(new Strategy_UpdateException());
        list.add(new Strategy_UsernameDuplicatedException());
        list.add(new Strategy_UsernameNotExistException());
        list.add(new FindException());
        map = new ConcurrentHashMap<>();
        for(ExceptionStrategy es:list){
            map.put(es.getType(),es);
        }
    }
    public static class Holder{
        public static StragegyFactory instance;

        static {
            instance = new StragegyFactory();
        }
    }
    public static StragegyFactory getInstance(){
        return Holder.instance;
    }
    public ExceptionStrategy get(String classname){
        return map.get(classname);
    }

}
