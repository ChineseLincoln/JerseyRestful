package com.drawthink.iguyuan.vo;

public class BaseException extends RuntimeException {  
  
    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  
    private Object[] values;  
  
    private int code = 500;  
  
    public BaseException() {  
  
    }  
  
    public BaseException(String msg) {  
        super(msg);  
    }  
  
    public BaseException(String msg, String... params) {  
        super(msg);  
        if (null != params) {  
            values = new Object[params.length];  
            for (int i = 0; i < params.length; i++) {  
                values[i] = params[i];  
            }  
        }  
    }  
  
    public BaseException(String msg, int code, String... params) {  
        this(msg, params);  
        this.code = code;  
    }  
  
    public BaseException(String msg, int code) {  
        super(msg);  
        this.code = code;  
    }  
  
    public BaseException(String message, Throwable cause, String... params) {  
        super(message, cause);  
        if (null != params) {  
            values = new Object[params.length];  
            for (int i = 0; i < params.length; i++) {  
                values[i] = params[i];  
            }  
        }  
    }  
  
    public BaseException(int code, String message, Throwable cause,  
            String... params) {  
        this(message, cause, params);  
        this.code = code;  
    }  
  
    public Object[] getValues() {  
        return values;  
    }  
  
    public void setValues(Object[] values) {  
        this.values = values;  
    }  
  
    public int getCode() {  
        return code;  
    }  
  
    public void setCode(int code) {  
        this.code = code;  
    }  
}