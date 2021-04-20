package com.healthy.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private  Long CategoryId;
	@Column( columnDefinition = "nvarchar (1000)",nullable = true)
	private String CategoryName;
	@Column( columnDefinition = "nvarchar (255)" ,nullable = true)
	private String CategoryCode;
	private Boolean IsActive;
	public Long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getCategoryCode() {
		return CategoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		CategoryCode = categoryCode;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	public Category() {
		
		// TODO Auto-generated constructor stub
	}
	public Category(Long categoryId, String categoryName, String categoryCode, Boolean isActive) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
		CategoryCode = categoryCode;
		IsActive = isActive;
	}
	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", CategoryCode="
				+ CategoryCode + ", IsActive=" + IsActive + "]";
	} 
	
	
	

}
