package com.example.bankAccount.helper;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

public class UserHelper {
	
	int customerId=0;
	long accountNumber=0l;
	Random random=new Random();
	
	public int getCustomerId()
	{
		for(int count=0;count<=100000000;count++)
		{
			customerId=random.nextInt(100000000);
			
		}
		return customerId;
	}
	
	public String generatePassword(int length)
	{
		final String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		return RandomStringUtils.random(length, chars);
	}
	
	public Long generateAccountNumber()
	{
		
		accountNumber = (random.nextInt(1000000)+1000000000l) * (random.nextInt(900)+100);
		/*for(int count=0;count<=1000000000;count++)
		{
			accountNumber=random.nextInt(1000000000);
			
		} */
		return accountNumber;
	}
		
	
	/*long number = 0l;
	Random rand = new Random();
	number = (rand.nextInt(1000000)+1000000000l) * (rand.nextInt(900)+100); */

}
