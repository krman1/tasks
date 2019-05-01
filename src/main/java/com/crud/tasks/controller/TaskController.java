package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/v1/task")
public class TaskController {
	
	@RequestMapping(method = RequestMethod.GET, value = "getTask")
	public List<TaskDto> getTask(){
		return new ArrayList<>();
	}
	@RequestMapping(method = RequestMethod.GET, value = "getTask/{taskId}")
	public TaskDto getTask (@PathVariable Long taskId){
		return new TaskDto(1L,"test title", "test_content");
	}
	@RequestMapping (method = RequestMethod.DELETE, value = "deleteTask/{taskId}")
	public void deleteTask (@PathVariable Long taskId) {
	
	}
	@RequestMapping (method = RequestMethod.PUT, value = "updateTask/{taskDto}")
	public TaskDto updateTask (@PathVariable TaskDto taskDto){
		return new TaskDto(1L,"edited test title", "Test content");
	}
	@RequestMapping (method = RequestMethod.POST, value = "createTask/{taskDto}")
	public void createTask (@PathVariable TaskDto taskDto) {
	
	}
}

