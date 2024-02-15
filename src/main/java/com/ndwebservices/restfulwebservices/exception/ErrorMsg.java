package com.ndwebservices.restfulwebservices.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorMsg {
	
	private LocalDateTime timestamp;
	private String messsage;
	private String details;
	
	public ErrorMsg(LocalDateTime timestamp, String messsage, String details) {
		super();
		this.timestamp = timestamp;
		this.messsage = messsage;
		this.details = details;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMesssage() {
		return messsage;
	}
	public String getDetails() {
		return details;
	}

	
}
