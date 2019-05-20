package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class TrelloBoardDto {
	
	private String name;
	private String id;
	
	public TrelloBoardDto(String name, String id) {
		this.name = name;
		this.id = id;
	}
	public TrelloBoardDto (){
	
	}
	
	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
