package com.restfullPractica.restfullPractica.Exception;

public class RequestException extends RuntimeException{
	private String code;
	
	public RequestException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public RequestException() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RequestException [code=" + code + "]";
	}
	
	
	
	
}
