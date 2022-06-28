package com.prova.leonardojunior.exception;

import java.util.Date;

public class Error {

	private String message;
	private Integer status;
	private Date date;
	
	public Error(String message, Integer status, Date date) {
		this.message = message;
		this.status = status;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public Date getDate() {
		return date;
	}
	
}
