package com.rns.fse.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This is the pojo class which handles the Api response and it's status.
 * 
 * @author George J Sebastian 7/13/2017
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

	private String status;
	private Object data;
	private Error error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Error getError() {
		return error;
	}

	public void setError(Integer code, String message) {
		if (code == null && message == null) {
			this.error = null;
		} else {
			this.error = new Error(code, message);
		}
	}

	@Override
	public String toString() {
		return "APIResponse{" + "status='" + status + '\'' + ", data='" + data
				+ '\'' + ", error=" + error + '}';
	}

	/*
	 * static inner class for handling error
	 */
	static class Error {
		private final Integer code;
		private final String message;

		public Error(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		public Integer getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		@Override
		public String toString() {
			return "Error{" + "code='" + code + '\'' + ", message='" + message
					+ '\'' + "}";
		}
	}
}
