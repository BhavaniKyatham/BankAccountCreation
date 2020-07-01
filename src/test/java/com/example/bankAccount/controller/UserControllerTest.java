package com.example.bankAccount.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedHashMap;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;
import com.example.bankAccount.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
    @Mock
    UserService userservice;
    
    MockMvc mockMvc;
    
    ObjectMapper objectMapper;
    @InjectMocks
    UserController usercontroller;
   
  
    UserRequestDto userRequestDto;
    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(usercontroller).build();
        
      userRequestDto=new UserRequestDto();
      userRequestDto.setAge(20);
      userRequestDto.setExperience(4);
      userRequestDto.setMailId("manasa@gmail.com");
      userRequestDto.setPanNumber("fxmne1257");
      userRequestDto.setPhoneNumber("9440293946");
      userRequestDto.setProfession("software enginerr");
      userRequestDto.setSalary(25000);
      userRequestDto.setUserName("manasa");
    }
        @Test
        public void Register() throws Exception
        {
            UserResponseDto userResponseDto=new UserResponseDto();
            userResponseDto.setCustomerId(4567899);
            userResponseDto.setPassword("emWnG2");
            userResponseDto.setMessage("user registerd successfully");
            userResponseDto.setStatusCode(200);
            //given
            
            when(userservice.userRegister(any(UserRequestDto.class))).thenReturn(userResponseDto);
            
            mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(objectMapper.writeValueAsString(userRequestDto)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", Matchers.any(LinkedHashMap.class)));
    
            verify(userservice).userRegister(any(UserRequestDto.class));
        }
        
       

}