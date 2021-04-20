package com.healthy.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Material {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private  Long MaterialId;
	@Column( columnDefinition = "nvarchar (1000)",nullable = true)
	private String MaterialName;
	@Column( columnDefinition = "nvarchar (1000)",nullable = true)
	private String MaterialCode;
	private Boolean IsActive;
	private  Long CategoryId;
	
	
	public Long getMaterialId() {
		return MaterialId;
	}
	public void setMaterialId(Long materialId) {
		MaterialId = materialId;
	}
	public String getMaterialName() {
		return MaterialName;
	}
	public void setMaterialName(String materialName) {
		MaterialName = materialName;
	}
	public String getMaterialCode() {
		return MaterialCode;
	}
	public void setMaterialCode(String materialCode) {
		MaterialCode = materialCode;
	}
	public Boolean getIsActive() {
		return IsActive;
	}
	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	public Long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}
	public Material() {
		
		// TODO Auto-generated constructor stub
	}
	public Material(Long materialId, String materialName, String materialCode, Boolean isActive, Long categoryId) {
		
		MaterialId = materialId;
		MaterialName = materialName;
		MaterialCode = materialCode;
		IsActive = isActive;
		CategoryId = categoryId;
	}
	
	
	
	
	

}
