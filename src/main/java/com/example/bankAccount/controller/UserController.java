package com.example.bankAccount.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankAccount.dto.LoginRequestDto;
import com.example.bankAccount.dto.LoginResponseDto;
import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;
import com.example.bankAccount.service.UserService;

/**
 * @author V.Manasa
 *
 */
@RestController
public class UserController {
	private static Log logger = LogFactory.getLog(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * This method is used to register User and get UserResponseDto with
	 * customerId,password
	 * @param userRequestDto
	 * @return UserResponseDto with customerId and password
	 */
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> userRegister(@Valid @RequestBody UserRequestDto userRequestDto) {
		logger.info("inside user registaration method");
		return new ResponseEntity<>(userService.userRegister(userRequestDto), HttpStatus.OK);
	}

	/**
	 * This method is used for logging
	 * @param loginRequestDto
	 * @return loginResponsedto with message and code and userId
	 */
	@PostMapping("users/login")
	public ResponseEntity<LoginResponseDto> userLogin(@Valid @RequestBody LoginRequestDto loginRequestDto) {
		logger.info("inside user login method");
		return new ResponseEntity<>(userService.userLogin(loginRequestDto), HttpStatus.OK);
	}
	
	

  

}
