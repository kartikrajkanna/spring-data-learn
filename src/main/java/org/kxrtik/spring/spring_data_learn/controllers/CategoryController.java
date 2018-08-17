package org.kxrtik.spring.spring_data_learn.controllers;

import org.kxrtik.spring.spring_data_learn.services.JpaCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@Autowired
	JpaCategoryService jpaCategoryService;
	
	@RequestMapping("/")
	public String handleHome() {
		System.out.println("WelcomePage");
		return "home";
	}
	
	@RequestMapping("/create")
	public String handleCreateCategory() {
		return "create";
	}
	
	@RequestMapping("/getCategories")
	public String handleGetCategories() {
		return "categories";
	}
	
	@RequestMapping("/getCategory/{tag}")
	public String handleGetCategoryByTag(String tag) {
		return "category";
	}
	
	@RequestMapping("/getCategory/{name}")
	public String handleGetCategoryByName(String name) {
		return "category";
	}
}
