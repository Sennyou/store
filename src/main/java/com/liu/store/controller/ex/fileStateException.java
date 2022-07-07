package com.liu.store.controller.ex;
//文件状态异常
public class fileStateException extends fileUploadException{
    public fileStateException() {
        super();
    }

    public fileStateException(String message) {
        super(message);
    }

    public fileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public fileStateException(Throwable cause) {
        super(cause);
    }

    protected fileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
