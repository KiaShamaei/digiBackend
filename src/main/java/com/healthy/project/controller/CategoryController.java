package com.healthy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthy.project.model.Category;
import com.healthy.project.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	
	@PostMapping(value = "/userinfo/addcategory")
	public String addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	@PostMapping(value = "/userinfo/updateCategory")
	public String updateCategory(Category category)
	{
		return categoryService.updateCategory(category);
	}
	@PostMapping(value = "/userinfo/deleteCategory")
	public String deleteCategory(Long categoryId) {
		return categoryService.deleteCategory(categoryId);
	}
	@GetMapping(value = "/userinfo/getAllCategory")
	public List < Category > getAllCategory(){
		return categoryService.getAllCategory();
	}
	@GetMapping(value = "/userinfo/getCategoryById")
	public Category getCategoryById(@RequestParam(value="categoryId") long categoryId) {
		return categoryService.getCategoryById(categoryId);
	}
}
