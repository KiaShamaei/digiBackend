package com.healthy.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthy.project.model.Category;
import com.healthy.project.model.Material;
import com.healthy.project.repository.MaterialRepository;

@Service
public class MaterialService {
	@Autowired
	MaterialRepository materialRepository;
	
	public String addMaterial(Material material) {
		String result="";
		if(materialRepository.save(material)!=null)
			result="Success";
		else
			result="Faild";
		return result;
	}
	
	public String updateMaterial(Material material) {
		String result="";
		if(materialRepository.save(material)!=null)
			result="Success";
		else
			result="Faild";
		return result;
	}
	
	public String deleteMaterial(Long materialId) {
		Optional < Material > materialDb = this.materialRepository.findById(materialId);
		if (materialDb.isPresent()) {
            this.materialRepository.delete(materialDb.get());
            return "Success";
        } else {
        	return "Faild";
        }
	}
	public List < Material > getAllMaterial() {
        return this.materialRepository.findAll();
    }
	public Material getMaterialById(long materialId) {

        Optional < Material > materialDb = this.materialRepository.findById(materialId);

        if (materialDb.isPresent()) {
            return materialDb.get();
        } else {
            return new Material();
        }
    }

}
