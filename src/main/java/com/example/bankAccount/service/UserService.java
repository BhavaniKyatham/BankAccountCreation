package com.example.bankAccount.service;

import com.example.bankAccount.dto.LoginRequestDto;
import com.example.bankAccount.dto.LoginResponseDto;
import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;

public interface UserService {

	UserResponseDto userRegister(UserRequestDto userRequestDto);

	LoginResponseDto userLogin(LoginRequestDto loginRequestDto);

}
