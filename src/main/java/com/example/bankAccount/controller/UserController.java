package com.example.bankAccount.controller;

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

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponseDto> userRegister(@RequestBody UserRequestDto userRequestDto)
	{
		  
		   return new ResponseEntity<>(userService.userRegister(userRequestDto),HttpStatus.OK);
	}
	
	@PostMapping("users/login")
	public ResponseEntity<LoginResponseDto> userLogin(@RequestBody LoginRequestDto loginRequestDto)
	{
		  
		   return new ResponseEntity<>(userService.userLogin(loginRequestDto),HttpStatus.OK);
	}
	

}
