package com.healthy.project.controller;

import java.text.ParseException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthy.project.model.Users;
import com.healthy.project.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsersController {
@Autowired
UsersService usersService;
	
	
 @PostMapping("/adduser")
 
 public String addUser (@RequestBody Users user) throws ParseException {
	 return usersService.addUser(user);
 }
 @GetMapping("/loginuser")
 
 public JSONObject loginUser (@RequestParam(value="mobileNumber") String mobileNumber,@RequestParam(value="password") String password )  {
	 return usersService.loginUsers(mobileNumber, password);
 }

}
