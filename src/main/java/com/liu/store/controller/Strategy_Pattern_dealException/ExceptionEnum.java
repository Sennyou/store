package com.liu.store.controller.Strategy_Pattern_dealException;

import com.liu.store.service.ex.AddressNotExistException;

public enum ExceptionEnum {

    AddressCountLimitException("class com.liu.store.service.ex.AddressCountLimitException","AddressCountLimitException"),
    AddressNotExistException("class com.liu.store.service.ex.AddressNotExistException","AddressNotExistException"),
    FindException("class com.liu.store.service.ex.FindException","FindException"),
    InsertException("class com.liu.store.service.ex.InsertException","InsertException"),
    PasswordErrorException("class com.liu.store.service.ex.PasswordErrorException","PasswordErrorException"),
    UidNotExistException("class com.liu.store.service.ex.UidNotExistException","UidNotExistException"),
    UpdateException("class com.liu.store.service.ex.UpdateException","UpdateException"),
    UsernameDuplicatedException("class com.liu.store.service.ex.UsernameDuplicatedException","UsernameDuplicatedException"),
    UsernameNotExistException("class com.liu.store.service.ex.UsernameNotExistException","UsernameNotExistException"),
    fileIOException("class com.liu.store.controller.ex.fileIOException","fileIOException"),
    fileIsNullException("class com.liu.store.controller.ex.fileIsNullException","fileIsNullException"),
    fileOverSizeException("class com.liu.store.controller.ex.fileOverSizeException","fileOverSizeException"),
    fileStateException("class com.liu.store.controller.ex.fileStateException","fileStateException"),
    fileTypeErrorException("class com.liu.store.controller.ex.fileTypeErrorException","fileTypeErrorException"),
    fileUploadException("class com.liu.store.controller.ex.fileUploadException","fileUploadException"),
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
