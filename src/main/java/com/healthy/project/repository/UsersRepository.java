package com.healthy.project.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthy.project.model.Users;



@Repository
public interface UsersRepository extends JpaRepository<Users , Long> {
	 public List<Users> findUsers(@Param("mobileNumber") String mobileNumber);
	 public List<Users> loginUsers(@Param("mobileNumber") String mobileNumber , @Param("password") String password);
	 
	 

}
