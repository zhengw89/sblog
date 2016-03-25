package com.sblog.repositories;

import java.util.Date;

import com.sblog.beans.User;

public interface IUserRepository {

	boolean exists(String email);

	boolean create(User user);
	
	boolean update(String id, String password, Date updateTime);
	
	User getById(String id);
}
