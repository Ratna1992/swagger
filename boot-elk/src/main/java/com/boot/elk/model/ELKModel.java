package com.boot.elk.model;

public class ELKModel {
	
	private String id;
	private String timestamp;
	private String exception;
	private String module;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "ELKModel [id=" + id + ", timestamp=" + timestamp + ", exception=" + exception + ", module=" + module
				+ "]";
	}
	public ELKModel(String id, String timestamp, String exception, String module) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.exception = exception;
		this.module = module;
	}
	public ELKModel() {
		// TODO Auto-generated constructor stub
	}
	
	

}
