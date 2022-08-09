package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.service.ex.AddressNotExistException;

public enum ExceptionEnum {

    AddressCountLimitException("class com.liu.store.service.ex.AddressCountLimitException","strategy_AddressCountLimitException"),
    AddressNotExistException("class com.liu.store.service.ex.AddressNotExistException","strategy_AddressNotExistException"),
    FindException("class com.liu.store.service.ex.FindException","findException"),
    InsertException("class com.liu.store.service.ex.InsertException","strategy_AddressNotExistException"),
    PasswordErrorException("class com.liu.store.service.ex.PasswordErrorException","strategy_PasswordErrorException"),
    UidNotExistException("class com.liu.store.service.ex.UidNotExistException","strategy_UidNotExistException"),
    UpdateException("class com.liu.store.service.ex.UpdateException","strategy_UpdateException"),
    UsernameDuplicatedException("class com.liu.store.service.ex.UsernameDuplicatedException","strategy_UsernameDuplicatedException"),
    UsernameNotExistException("class com.liu.store.service.ex.UsernameNotExistException","strategy_UsernameNotExistException"),
    fileIOException("class com.liu.store.controller.ex.fileIOException","strategy_fileIOException"),
    fileIsNullException("class com.liu.store.controller.ex.fileIsNullException","strategy_fileIsNullException"),
    fileOverSizeException("class com.liu.store.controller.ex.fileOverSizeException","strategy_fileOverSizeException"),
    fileStateException("class com.liu.store.controller.ex.fileStateException","strategy_fileStateException"),
    fileTypeErrorException("class com.liu.store.controller.ex.fileTypeErrorException","strategy_fileTypeErrorException"),
    fileUploadException("class com.liu.store.controller.ex.fileUploadException","strategy_fileUploadException"),
    ;
    String className;
    String type;

    ExceptionEnum(String className,String type){
        this.className=className;
        this.type=type;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
