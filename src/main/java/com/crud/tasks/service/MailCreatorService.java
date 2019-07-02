package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;


@Service
public class MailCreatorService {
	
	@Autowired
	private AdminConfig adminConfig;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	@Qualifier("templateEngine")
	private TemplateEngine templateEngine;
	
	public String buildTrelloCardEmail(String message) {
		
		List<String> functionality = new ArrayList<>();
		functionality.add("You can manage your tasks");
		functionality.add("Provides connection with Trello Account");
		functionality.add("Application allows sending tasks to Trello");
		
		Context context = new Context();
		context.setVariable("message", message);
		context.setVariable("tasks_url", "http://localhost:8888/tasks_frontend/");
		context.setVariable("button", "Visit website");
		context.setVariable("admin_name", adminConfig.getAdminName());
		context.setVariable("goodbye_message", "Thank you " + adminConfig.getAdminName() + ", bye ;-)");
		context.setVariable("company_name", adminConfig.getCompanyName());
		context.setVariable("company_email", "email: " + adminConfig.getCompanyEmail());
		context.setVariable("company_phone", "phone: " + adminConfig.getCompanyPhone());
		context.setVariable("show_button", false);
		context.setVariable("is_friend", false);
		context.setVariable("application_functionality", functionality);
		context.setVariable("admin_config", adminConfig);
		return templateEngine.process("mail/created-trello-card-mail", context);
	}
	public String buildScheduleEmail(String message) {
		List<String> tasks = new ArrayList<>();
		taskRepository.findAll().stream()
				.forEach(task -> tasks.add(task.getTitle()));
		
		
		Context context = new Context();
		context.setVariable("message", message);
		context.setVariable("admin_config", adminConfig);
		context.setVariable("goodbye_message", "Have a nice day. :)");
		context.setVariable("company_name", adminConfig.getCompanyName());
		context.setVariable("company_email", "email: " + adminConfig.getCompanyEmail());
		context.setVariable("company_phone", "phone: " + adminConfig.getCompanyPhone());
		context.setVariable("show_button", false);
		context.setVariable("is_friend", false);
		context.setVariable("tasks_list", tasks);
		return templateEngine.process("mail/Trello-scheduled-mail", context);
	}
}
