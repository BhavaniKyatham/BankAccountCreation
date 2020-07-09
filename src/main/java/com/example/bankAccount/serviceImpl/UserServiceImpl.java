package com.example.bankAccount.serviceImpl;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.bankAccount.dao.AccountDao;
import com.example.bankAccount.dao.UserDao;
import com.example.bankAccount.dto.LoginRequestDto;
import com.example.bankAccount.dto.LoginResponseDto;
import com.example.bankAccount.dto.UserRequestDto;
import com.example.bankAccount.dto.UserResponseDto;
import com.example.bankAccount.helper.UserHelper;
import com.example.bankAccount.model.Account;
import com.example.bankAccount.model.AccountType;
import com.example.bankAccount.model.User;
import com.example.bankAccount.service.UserService;

/**
 * @author v.manasa This class is used for User related operations like userLogin and register User
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Autowired
	AccountDao accountDao;

	/**
	 *this method is used for registration and when the user register it will generate accountnumber and customerid and password
	 */
	@Override
	public UserResponseDto userRegister(UserRequestDto userRequestDto) {
		User user = new User();
		Account account = new Account();
		UserHelper helper = new UserHelper();
		UserResponseDto responseDto = new UserResponseDto();

		if (userRequestDto.getAge() >= 18) {
			BeanUtils.copyProperties(userRequestDto, user);
			user.setCustomerId(helper.getCustomerId());
			user.setPassword(helper.generatePassword(6));
			User user1 = userDao.save(user);

			account.setAccountNumber(helper.generateAccountNumber());
			account.setAccountType(AccountType.savings);
			account.setBalance(5000);
			account.setUserId(user1.getUserId());
			accountDao.save(account);

			BeanUtils.copyProperties(user1, responseDto);
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

	/**
	 *This method is used for user login with customerid and password
	 */
	@Override
	public LoginResponseDto userLogin(LoginRequestDto loginRequestDto) {

		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> user1 = userDao.findByCustomerIdAndPassword(loginRequestDto.getCustomerId(),
				loginRequestDto.getPassword());

		if (user1.isPresent()) {
			logger.info("user logged in successfully");
			loginResponseDto.setUserId(user1.get().getUserId());
			loginResponseDto.setMessage("User logged in Successfully");
			loginResponseDto.setStatusCode(HttpStatus.OK.value());

			return loginResponseDto;
		}
		loginResponseDto.setMessage("Invalid credentials!!!");
		loginResponseDto.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		return loginResponseDto;

	}

}
