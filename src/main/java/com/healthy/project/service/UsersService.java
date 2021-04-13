package com.healthy.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.simple.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import com.healthy.project.model.Users;
import com.healthy.project.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository userRepository;
	public List<Users> findUsers(String mobile) {

		return userRepository.findUsers(mobile);
	}

	public String addUser(Users user) throws ParseException {
		String response = "";

		if (findUsers(user.getMobileNumber()).size() > 0) {
			return response = "mobile number is it!";
		}

		user.setCreateDate(getDateWithoutTimeUsingFormat());
		String hashPassword=hashPassword(user.getPassword());
		user.setPassword(hashPassword);
		if (userRepository.save(user) != null) {
			return response = "Success";
		} else {
			return response = "Failed";
		}

	}

	

	// ----------------------------------------------
	public JSONObject loginUsers(String mobileNumber, String password) {
		List<Users> result = userRepository.findUsers(mobileNumber);
		JSONObject obj = new JSONObject();
		if (result.size() > 0) {
			Users users = result.get(0);
			String passwordCheck=checkPassword(password,users.getPassword());
			if(passwordCheck.equals("true")) {
				obj.put("userId", users.getUserId());
				obj.put("Name", users.getName());
				obj.put("Family", users.getFamily());
				obj.put("Mobile", users.getMobileNumber());
			}
			else
			{
				obj.put("userId", -1);
			}
			
			
			

		} else {
			obj.put("userId", 0);

		}
		return obj;
	}
//make date parameter 
	public static Date getDateWithoutTimeUsingFormat() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.parse(formatter.format(new Date()));
	}
//make hashPassword 
	private String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
		
	}
//check hash password 
	private String checkPassword(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return "true";
		else
			return "false";
	}

}
