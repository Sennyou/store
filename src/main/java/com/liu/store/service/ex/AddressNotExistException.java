package com.liu.store.service.ex;

public class AddressNotExistException extends ServiceException{
    public AddressNotExistException() {
        super();
    }

    public AddressNotExistException(String message) {
        super(message);
    }

    public AddressNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotExistException(Throwable cause) {
        super(cause);
    }

    protected AddressNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
