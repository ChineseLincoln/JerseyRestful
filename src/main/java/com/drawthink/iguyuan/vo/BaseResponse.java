package com.drawthink.iguyuan.vo;

public class BaseResponse<T> {
	
	public BaseResponse(T data) {
		this.data = data;
	}

	private int code = 200;
	
	private T data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
