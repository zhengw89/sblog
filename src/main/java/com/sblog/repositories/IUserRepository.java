package com.sblog.repositories;

import com.sblog.beans.User;

public interface IUserRepository {

	boolean exists(String email);

	boolean create(User user);
	
	User getById(String id);
}
