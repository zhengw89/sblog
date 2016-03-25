package com.sblog.services;

import com.sblog.beans.User;

public interface IUserService {

	User getByUserId(String userId);
	
	boolean updatePassword(String userId, String newPassword);
}
