package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DbService dbService;
	
	@MockBean
	private TaskMapper taskMapper;
	
	private Task task;
	private TaskDto taskDto;
	private List<Task> tasks;
	private List<TaskDto> tasksDto;
	private Gson gson;
	
	@Before
	public void init() {
		//Given
		task = new Task(1L, "Test title", "Test desc");
		taskDto = new TaskDto(1L, "Test title", "Test desc");
		tasks = new ArrayList<>();
		tasks.add(task);
		tasksDto = new ArrayList<>();
		tasksDto.add(taskDto);
		gson = new Gson();
	}
	
	@Test
	public void shouldGetTasks() throws Exception {
		//Given
		when(dbService.getAllTasks()).thenReturn(tasks);
		when(taskMapper.mapToTaskDtoList(tasks)).thenReturn(tasksDto);
		
		//When & Then
		mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].title", is("Test title")))
				.andExpect(jsonPath("$[0].content", is("Test desc")));
	}
	
	@Test
	public void shouldGetTask() throws Exception {
		//Given
		when(dbService.getTask(1L)).thenReturn(Optional.of(task));
		when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
		
		//When & Then
		mockMvc.perform(get("/v1/task/getTask/?taskId=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.title", is("Test title")))
				.andExpect(jsonPath("$.content", is("Test desc")));
	}
	
	@Test
	public void shouldCreateTask() throws Exception {
		//Given
		String jsonContent = gson.toJson(taskDto);
		when(dbService.saveTask(task)).thenReturn(task);
		
		
		//When & Then
		mockMvc.perform(post("/v1/task/createTask")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonContent))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldUpdateTask() throws Exception {
		//Given
		String jsonContent = gson.toJson(taskDto);
		
		when(dbService.saveTask(task)).thenReturn(task);
		when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
		when(taskMapper.mapToTask(taskDto)).thenReturn(task);
		
		//When & Then
		mockMvc.perform(put("/v1/task/updateTask")
				.contentType(MediaType.APPLICATION_JSON)
				.characterEncoding("UTF-8")
				.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.title", is("Test title")))
				.andExpect(jsonPath("$.content", is("Test desc")));
	}

	@Test
	public void shouldDeleteTaskWhenTaskIdExist() throws Exception {
		//Given
		String jsonContent = gson.toJson(taskDto);
		when(dbService.getTask(1L)).thenReturn(ofNullable(task));
	
		//When & Then
		mockMvc.perform(delete("/v1/task/deleteTask?taskId=1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
}

}
