package com.example.bankAccount;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bankAccount.dao.UserDao;
import com.example.bankAccount.dto.LoginRequestDto;
import com.example.bankAccount.dto.LoginResponseDto;
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
    
    LoginResponseDto loginResponseDto;
    
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
        
        loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("user logged in");
        loginResponseDto.setUserId(1);
        loginResponseDto.setStatusCode(200);
    }

  /*  @Test
    public void registerUserTest() {
    	
    	
    	      //given
    			when(userDao.save(any(User.class))).thenReturn(any(User.class));
    			
    			//when
    			userServiceImpl.userRegister(userRequestDto);
    			
    			//then
    			verify(userDao).save(any(User.class));
        
  
    } */
    
    @Test
    public void loginUserTest() {
        
        User user = new User();
       
        user.setCustomerId(2345678);
        user.setPassword("ESwe2c");
        
       
        
        LoginRequestDto loginRequestDto = new LoginRequestDto();
        loginRequestDto.setCustomerId(2345678);
        loginRequestDto.setPassword("ESwe2c");
       
        
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setMessage("user logged in");
        loginResponseDto.setStatusCode(200);
        loginResponseDto.setUserId(1);
        when(userDao.findByCustomerIdAndPassword(2345678, "ESwe2c")).thenReturn(Optional.of(user));
        userServiceImpl.userLogin(loginRequestDto);
        verify(userDao).findByCustomerIdAndPassword(2345678, "ESwe2c");
    }

}

