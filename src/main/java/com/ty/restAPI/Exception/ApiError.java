package com.ty.restAPI.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError {
	private String message; // Exception error message
	private LocalDateTime localDateTime; // date and time of exception
	private String endpoint; // Controller class which endpoint(url)
	private HttpStatus httpStatus; // Error status code

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
