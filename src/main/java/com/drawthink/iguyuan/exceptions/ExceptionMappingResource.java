package com.drawthink.iguyuan.exceptions;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotAllowedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.drawthink.iguyuan.utils.MessageUtil;
import com.drawthink.iguyuan.vo.ExceptionResponse;  

/** 
 * 必须添加该注解使得在程序的任何地方发生运行时异常时，自动的进行异常统一处理 
 * 同时该类要能够被Jersey扫描到 
 */  
@Provider  
public class ExceptionMappingResource implements ExceptionMapper<Exception> {  

	Logger logger = Logger.getLogger(ExceptionMappingResource.class);
	
	@Override  
	public Response toResponse(Exception exception) {  
		ResponseBuilder responseBuilder = null;  
		// 用户自定义的运行时异常处理  
		if (exception instanceof BaseException) {
			//获取用户抛出的异常信息  
			String code = exception.getMessage();  
			//根据异常key获取对应的中文异常信息  
			MessageUtil messageUtil = MessageUtil.getInstance();
			String message = messageUtil.getMessage((BaseException) exception);  
			Throwable cause = exception.getCause();  
			if (cause != null) {  
				String realReason = cause.getMessage();  
				message += " 可能的原因是：" + realReason + "";  
			}  

			//自定义异常返回实体bean类  
			ExceptionResponse error = new ExceptionResponse();  
			error.setCode(code.substring(1));  
			error.setMessage(message);  

			responseBuilder = Response.ok(error).status(  
					((BaseException) exception).getCode());  
		} else if(exception instanceof NotFoundException){
			ExceptionResponse error = new ExceptionResponse();  
			error.setCode("404");  
			error.setMessage("资源未找到");  
			responseBuilder = Response.ok(error).status(  
					Response.Status.NOT_FOUND);  
			
		} else if(exception instanceof NotAllowedException){
			ExceptionResponse error = new ExceptionResponse();  
			error.setCode("405");  
			error.setMessage("Method Not Allowed");  
			responseBuilder = Response.ok(error).status(  
					Response.Status.METHOD_NOT_ALLOWED);  
			
		}
		else if(exception instanceof InternalServerErrorException
				|| exception instanceof NullPointerException){
			ExceptionResponse error = new ExceptionResponse();  
			error.setCode("500");  
			String message = "服务器错误 可能的原因是：" + exception;
			error.setMessage(message);
			responseBuilder = Response.ok(error).status(  
					Response.Status.INTERNAL_SERVER_ERROR);  
			logger.error("500", exception);
		}else {
			ExceptionResponse error = new ExceptionResponse();  
			error.setCode("9999");  
			String message = "未知错误 可能的原因是：" + exception;
			error.setMessage(message);
			responseBuilder = Response.ok(error).status(  
					Response.Status.BAD_REQUEST);  
			logger.error("unknow", exception);
		}
		exception.printStackTrace(System.err);
		return responseBuilder.build();  
	}  
}  
