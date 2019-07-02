package com.crud.tasks.scheduler;

import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.MailCreatorService;
import com.crud.tasks.service.SimpleEmailService;
import com.crud.tasks.trello.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {
	
	@Autowired
	private MailCreatorService mailCreatorService;
	
	@Autowired
	private SimpleEmailService simpleEmailService;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private AdminConfig adminConfig;

	private static final String SUBJECT = "Tasks: One a day email";
	String singularOrPlural;

//	@Scheduled( cron = "0 0 10 * * *")
//	@Scheduled(fixedDelay = 10000)
//	public void sendInformationEmail() {
//
//		long size = taskRepository.count();
//		if (size == 1){
//			singularOrPlural = "task";
//		} else {
//			singularOrPlural = "tasks";
//		}
//
//		simpleEmailService.send(new Mail(
//				adminConfig.getAdminMail(),
//				null,
//				SUBJECT,
//				"Currently in database you got: " + size + singularOrPlural)
//		);
//	}
//	@Scheduled(cron = "0 0 12 * * *")
	public void sendInformationEmail() {
		long size = taskRepository.count();
		
		String correctWord;
		if (size == 1) {
			correctWord = " task";
		} else {
			correctWord = " tasks";
		}
		String message = "Currently database you got: " + size + correctWord;
		mailCreatorService.buildScheduleEmail(message);
	}
}
