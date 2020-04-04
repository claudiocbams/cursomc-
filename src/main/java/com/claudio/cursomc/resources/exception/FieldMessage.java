package com.claudio.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String FiledName;
	private String message;
	
	public FieldMessage() {
		
	}

	public FieldMessage(String filedName, String message) {
		super();
		FiledName = filedName;
		this.message = message;
	}

	public String getFiledName() {
		return FiledName;
	}

	public void setFiledName(String filedName) {
		FiledName = filedName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
