package com.healthy.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.simple.JSONObject;  
import com.healthy.project.model.Users;
import com.healthy.project.repository.UsersRepository;


@Service
public class UsersService {
	@Autowired
	UsersRepository userRepository;

	public String addUser(Users user) throws ParseException {
		String response = "";

		if (findUsers(user.getMobileNumber()).size() > 0) {
			return response = "mobile number is it!";
		}

		user.setCreateDate(getDateWithoutTimeUsingFormat());
		if (userRepository.save(user) != null) {
			return response = "Success";
		} else {
			return response = "Failed";
		}

	}
	public List<Users> findUsers(String mobile) {

		return userRepository.findUsers(mobile);
	}
	//----------------------------------------------
	public JSONObject loginUsers (String mobileNumber , String password){
		List<Users> result = userRepository.loginUsers(mobileNumber, password); 
		JSONObject obj=new JSONObject(); 
		if( result.size() >0 ) {
			
			Users users=result.get(0);
			obj.put("userId", users.getUserId());
			obj.put("Name", users.getName());
			obj.put("Family", users.getFamily());
			obj.put("Mobile", users.getMobileNumber());

		}else {
			obj.put("userId", 0);
			
		}
		return	obj;
	}
	
	public static Date getDateWithoutTimeUsingFormat() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.parse(formatter.format(new Date()));
	}

	

	

}
