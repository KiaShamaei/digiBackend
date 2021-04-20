package com.healthy.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthy.project.model.Category;
import com.healthy.project.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public String addCategory(Category category) {
		String result="";
		if(categoryRepository.save(category)!=null)
			result="Success";
		else
			result="Faild";
		return result;
		
	}
	
	public String updateCategory(Category category) {
		String result="";
		if(categoryRepository.save(category)!=null)
			result="Success";
		else
			result="Faild";
		return result;
	}
	
	public String deleteCategory(Long categoryId) {
		Optional < Category > productDb = this.categoryRepository.findById(categoryId);
		if (productDb.isPresent()) {
            this.categoryRepository.delete(productDb.get());
            return "Success";
        } else {
        	return "Faild";
        }
	}
	public List < Category > getAllCategory() {
        return this.categoryRepository.findAll();
    }
	public Category getCategoryById(long CategoryId) {

        Optional < Category > categoryDb = this.categoryRepository.findById(CategoryId);

        if (categoryDb.isPresent()) {
            return categoryDb.get();
        } else {
            return new Category();
        }
    }

}
