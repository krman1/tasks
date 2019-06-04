package com.crud.tasks.domain;

public class Mail {

	private String mailTo;
	private String toCc;
	private String subject;
	private String message;
	
	public Mail(String mailTo, String toCc, String subject, String message) {
		this.mailTo = mailTo;
		this.toCc = toCc;
		this.subject = subject;
		this.message = message;
	}
	
	public String getMailTo() {
		return mailTo;
	}
	
	public String getToCc() {
		return toCc;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getMessage() {
		return message;
	}
}
