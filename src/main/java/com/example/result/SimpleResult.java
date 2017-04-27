package com.example.result;

import java.io.Serializable;

public class SimpleResult implements Serializable {
	private static final long serialVersionUID = -2215886774864987360L;
	/**
	 * 成功标示:true/false
	 */
	private boolean success;
	/**
	 * 错误码
	 */
	private Integer errorCode;
	/**
	 * 错误描述
	 */
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
