package com.crud.tasks.trello.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AdminConfig {
	
	@Value("${admin.mail}")
	private String adminMail;
	
	@Value("${admin.name}")
	private String adminName;
	
	@Value("${info.company.name}")
	private String companyName;
	
	@Value("${info.company.email}")
	private String companyEmail;
	
	@Value("${info.company.phone}")
	private String companyPhone;
	
	public String getAdminMail() {
		return adminMail;
	}
	
	public String getAdminName() {
		return adminName;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public String getCompanyEmail() {
		return companyEmail;
	}
	
	public String getCompanyPhone() {
		return companyPhone;
	}
}
