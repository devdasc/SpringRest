package org.javacoder.spring.rest.exception;

public class StudentErrorResponse {
	private int status;
	private String message;
	private long timeStump;
	
	public StudentErrorResponse() {
		
	}
	public StudentErrorResponse(int status, String message, long timeStump) {
		
		this.status = status;
		this.message = message;
		this.timeStump = timeStump;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStump() {
		return timeStump;
	}
	public void setTimeStump(long timeStump) {
		this.timeStump = timeStump;
	}
	
	

}
