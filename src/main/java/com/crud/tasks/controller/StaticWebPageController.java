package com.crud.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class StaticWebPageController {
	
	@RequestMapping("/")
	public String index(Map<String,Object> model){
		model.put("variable", "My Thymeleaf variable");
		model.put("two", 2);
		model.put("firstEquation", "2 * 2 = ");
		model.put("secondEquation", "2 * 2 + 2 = ");
		model.put("thirdEquation", "2 - 2 * 2 = ");
		return "index";
	}
}
