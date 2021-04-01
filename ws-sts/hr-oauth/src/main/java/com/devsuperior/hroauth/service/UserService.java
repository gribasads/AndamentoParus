package com.devsuperior.hroauth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	
	@Autowired
	private UserFeignClient userFeignClient;

	
	public User findByEmail(String email) {
		User user = userFeignClient.finByEmail(email).getBody();
		if(user==null) {
			logger.error("EMAIL NOT FOUND"+email);
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("email found" + email);
		return user;
	}

}
