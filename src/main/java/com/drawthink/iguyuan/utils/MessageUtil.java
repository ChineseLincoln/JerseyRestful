package com.drawthink.iguyuan.utils;

import java.text.MessageFormat;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import com.drawthink.iguyuan.vo.BaseException;

public class MessageUtil {

    private static MessageUtil instance = new MessageUtil();  
  
    // 用于读取资源属性文件（properties）  
    private ResourceBundle resourceBoudle = null;  
  
    public static MessageUtil getInstance() {  
        return instance;  
    }  
  
    /** 
     * 根据异常key获取对应的异常信息 
     *  
     * @param exceptionId 
     * @return 
     */  
    public String getMessage(String exceptionId) {  
        String message = resourceBoudle.getString(getErrorID(exceptionId));  
        return message;  
    }  
  
    /** 
     * 根据异常获取对应的中文异常 
     *  
     * @param e 
     * @return 
     */  
    public String getMessage(BaseException e) {  
        String message = resourceBoudle.getString(getErrorID(e.getMessage()));  
        Object[] arguments = e.getValues();  
        if (arguments != null) {  
            message = MessageFormat.format(message, arguments);  
        }  
        return message;  
    }  
  
    private MessageUtil() {  
        init();  
    }  
  
    /** 
     * 读取、加载存放key/value形式，并被Unicode编码的properties配置信息 
     */  
    private void init() {  
        try {  
            resourceBoudle = new PropertyResourceBundle(  
                    getClass().getResourceAsStream("/messages_zh_CN.properties"));  
        } catch (Exception ex) {  
//             LOGGER.error("Error loading messages properties", ex);  
        }  
    }  
  
    /** 
     * 根据抛出的异常编号截取与配置文件对应的异常编号 编号E11110——>变成11110 
     *  
     * @param exceptionID 
     *            :example 编号E11110 
     * @return:变成11110 
     */  
    private String getErrorID(String exceptionID) {  
        exceptionID = exceptionID.substring(1);  
        return exceptionID;  
    }  
}
