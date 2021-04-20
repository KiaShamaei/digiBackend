package com.healthy.project.controller;

import java.text.ParseException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthy.project.model.UserInfo;
import com.healthy.project.model.Users;
import com.healthy.project.service.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:3000" )
public class UsersController {
@Autowired
UsersService usersService;
	
@CrossOrigin(origins = "http://localhost:3000")	
 @PostMapping("/adduser")
 
 public String addUser (@RequestBody Users user) throws ParseException {
	 return usersService.addUser(user);
 }
 @GetMapping("/loginuser")
 
 public UserInfo loginUser (@RequestParam(value="mobileNumber") String mobileNumber,@RequestParam(value="password") String password )  {
	 return usersService.loginUsers(mobileNumber, password);
 }
 @CrossOrigin(origins = "http://localhost:3000")
 @PostMapping("userinfo")
 public Users getUsers (@RequestBody UserInfo userInfo) {
	 return usersService.findUsers(userInfo.getUserInfo()).get(0);
 }
 @CrossOrigin(origins = "http://localhost:3000")
 @GetMapping("/userinfo/getuser")
 public Users getUsers(@RequestParam(value = "mobileNumber") String mobileNumber) {
	 return usersService.findUsers(mobileNumber).get(0);
 }
 
 @CrossOrigin(origins = "http://localhost:3000")
 @PostMapping("userinfo/updateuser")
 public String updateUser (@RequestBody Users user) throws ParseException {
	 return usersService.updateUser(user);
 }
 

}
