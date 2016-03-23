package com.sblog.services;

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
}
