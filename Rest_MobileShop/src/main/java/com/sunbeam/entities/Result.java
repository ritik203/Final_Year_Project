
package com.sunbeam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

enum Status {
	success, error
}

@JsonInclude(Include.NON_NULL)
public class Result {
	private Status status; // "success" or "error"
	private String message; // error or response info
	private Object data; // data upon success
	@JsonIgnore
	private String remarks;
	
	public Result(Status status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public Object getData() {
		return data;
	}



	public void setData(Object data) {
		this.data = data;
	}



	public static Result success(Object data) {
		return new Result(Status.success, null, data);
	}
	public static Result error(String message) {
		return new Result(Status.error, message, null);
	}
}
