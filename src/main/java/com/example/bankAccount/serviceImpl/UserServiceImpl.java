package com.example.bankAccount.serviceImpl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.bankAccount.dao.UserDao;
import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;
import com.example.bankAccount.helper.UserHelper;
import com.example.bankAccount.model.User;
import com.example.bankAccount.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserResponseDto userRegister(UserRequestDto userRequestDto) {
		User user=new User();
		UserHelper helper=new UserHelper();
		UserResponseDto responseDto=new UserResponseDto();
		
		if(userRequestDto.getAge()>=18)
		{
			BeanUtils.copyProperties(userRequestDto, user );
			user.setCustomerId(helper.getCustomerId());
			user.setPassword(helper.generatePassword(6));
			User user1=userDao.save(user);
			
			
			BeanUtils.copyProperties(user1,responseDto );
			responseDto.setCustomerId(user1.getCustomerId());
			responseDto.setPassword(user1.getPassword());
			responseDto.setMessage("user registered succeefully");
			responseDto.setStatusCode(HttpStatus.OK.value());
			return responseDto;
		}
		 responseDto.setMessage("for registaration user age should be greater than 18 years!!!");
         responseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
         return responseDto;
	}

	

}
