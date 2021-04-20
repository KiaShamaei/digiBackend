package com.healthy.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.healthy.project.model.Material;
import com.healthy.project.service.MaterialService;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class MaterialController {
	
	@Autowired
	MaterialService materialService;
	
	@PostMapping(value = "/userinfo/addmaterial")
	public String addMaterial(@RequestBody Material material) {
		return materialService.addMaterial(material);
	}
	@PostMapping(value = "/userinfo/updateMaterial")
	public String updateMaterial(Material material)
	{
		return materialService.updateMaterial(material);
	}
	@PostMapping(value = "/userinfo/deleteMaterial")
	public String deleteMaterial(Long materialId) {
		return materialService.deleteMaterial(materialId);
	}
	@GetMapping(value = "/userinfo/getAllMaterial")
	public List < Material > getAllMateral(){
		return materialService.getAllMaterial();
	}
	@GetMapping(value = "/userinfo/getMaterialById")
	public Material getMaterialById(@RequestParam(value="materialId") long materialId) {
		return materialService.getMaterialById(materialId);
	}

}
