package com.ratna.boot.kafka.model;

public class ApplicationEvent {

	private String event;
	private Application application;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	@Override
	public String toString() {
		return "ApplicationEvent [event=" + event + ", application=" + application + "]";
	}
	
	
}
