package com.ihamza.exception;

import com.ihamza.domain.Status;

@SuppressWarnings("serial")
public class AppException extends RuntimeException {

	private Status status;

	public AppException(Status status) {
		super();
		this.status = status;
	}

	public AppException(Exception e) {
		super(e);
	}
	
	public AppException(Status status,Exception e) {
		super(e);
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}