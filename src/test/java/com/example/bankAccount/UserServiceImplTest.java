package com.example.bankAccount;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bankAccount.dao.UserDao;
import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;
import com.example.bankAccount.model.User;
import com.example.bankAccount.serviceImpl.UserServiceImpl;



@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
    User user;
    UserResponseDto responseDto;

    @Mock
    UserDao userDao;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    UserRequestDto userRequestDto;
    
    @BeforeEach
    public void setUp() {
    	
    	 userRequestDto=new UserRequestDto();
    	 userRequestDto.setAge(20);
         userRequestDto.setExperience(4);
         userRequestDto.setMailId("manasa@gmail.com");
         userRequestDto.setPanNumber("fxmne1257");
         userRequestDto.setPhoneNumber("9440293946");
         userRequestDto.setProfession("software enginerr");
         userRequestDto.setSalary(25000);
         userRequestDto.setUserName("manasa");
         
    	responseDto = new UserResponseDto();
    	responseDto.setCustomerId(3546722);
    	responseDto.setPassword("EwQ23S");
    	responseDto.setMessage("user registered succeefully");
        responseDto.setStatusCode(200);
    }

    @Test
    public void registerUserTest() {
    	
    	
    	      //given
    			when(userDao.save(any(User.class))).thenReturn(any(User.class));
    			
    			//when
    			userServiceImpl.userRegister(userRequestDto);
    			
    			//then
    			verify(userDao).save(any(User.class));
        
  
    }

}