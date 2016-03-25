package com.sblog.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sblog.beans.User;
import com.sblog.repositories.IUserRepository;

@Service("userService")
@Transactional
public class UserService extends BaseService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	public User getByUserId(String userId) {
		return this.userRepository.getById(userId);
	}

	public boolean updatePassword(String userId, String newPassword) {
		
		if(userId == null || newPassword == null) return false;
		
		return this.userRepository.update(userId, newPassword, new Date());
	}
}
