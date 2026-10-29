package org.openmrs.module.nigeriaemr.omodmodels;

public class DataSnycResponse {
	
	private int code;
	
	private String message;
	
	private boolean transactionId;
	
	public DataSnycResponse(int code, String message, boolean transactionId) {
		this.code = code;
		this.message = message;
		this.transactionId = transactionId;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public boolean isTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(boolean transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
