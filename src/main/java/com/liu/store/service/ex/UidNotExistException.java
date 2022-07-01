package com.liu.store.service.ex;

public class UidNotExistException extends ServiceException{
    public UidNotExistException() {
        super();
    }

    public UidNotExistException(String message) {
        super(message);
    }

    public UidNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UidNotExistException(Throwable cause) {
        super(cause);
    }

    protected UidNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
