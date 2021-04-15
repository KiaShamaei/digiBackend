package com.healthy.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import org.json.simple.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import com.healthy.project.model.UserInfo;
import com.healthy.project.model.Users;
import com.healthy.project.repository.UsersRepository;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UsersService {
	@Autowired
	UsersRepository userRepository;
	public List<Users> findUsers(String mobile) {

		return userRepository.findUsers(mobile);
	}

	public String addUser(Users user) throws ParseException {
		//return "ddd";
		String response="";
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
	public UserInfo loginUsers(String mobileNumber, String password) {
		List<Users> result = userRepository.findUsers(mobileNumber);
	String token = "";
		UserInfo user = new UserInfo();
		if (result.size() > 0) {
			Users users = result.get(0);
			String passwordCheck=checkPassword(password,users.getPassword());
			if(passwordCheck.equals("true")) {
				// make token if passwor is correct 
				 token = getJWTToken(mobileNumber);
				user.setToken(token);
				user.setUserInfo(mobileNumber);
				user.setIsValid(true);
				return user ;
				
			}
			else
			{
				//password is invalid .......
				token = "0";
				user.setToken(token);
				user.setUserInfo("password not valid");
				user.setIsValid(false);
				return user;
			}
		

		} else {
			//username doesnt exist 
			token = "0";
			user.setToken(token);
			user.setUserInfo("username not valid");
			user.setIsValid(false);
			return user;

		}
		
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
//make token for users
	private String getJWTToken(String username) {
		String secretKey = "7sheen";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
