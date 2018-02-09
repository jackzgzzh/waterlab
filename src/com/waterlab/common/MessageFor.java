package com.waterlab.common;

import java.io.Serializable;

public class MessageFor implements Serializable{
	
	private boolean success = false;
	private String content ="";
	
	public MessageFor(){
		
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
