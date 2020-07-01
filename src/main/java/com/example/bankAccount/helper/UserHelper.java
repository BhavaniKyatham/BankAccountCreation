package com.example.bankAccount.helper;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class UserHelper {
	
	int customerId=0;
	Random random=new Random();
	public int getCustomerId()
	{
		for(int count=0;count<=10000000;count++)
		{
			customerId=random.nextInt(10000000);
			
		}
		return customerId;
	}
	
	public String generatePassword(int length)
	{
		final String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return RandomStringUtils.random(length, chars);
	}
	
			

}
