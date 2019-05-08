package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
	
	@Autowired
	private TaskRepository repository;
	
	public List<Task> getAllTasks() {
		return repository.findAll();
	}
	
	public Optional<Task> getTask(final long id) {
		return repository.findById(id);
	}
	
	public Task saveTask(final Task task) {
		return repository.save(task);
	}
	
	public void deleteById(final Long id) {
		repository.deleteById(id);
	}
	
	public boolean existsById(final Long id){
		if (repository.existsById(id)){
			return true; }
		else {
			return false;
		}
		}
	}




