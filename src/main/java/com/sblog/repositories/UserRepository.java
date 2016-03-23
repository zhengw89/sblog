package com.sblog.repositories;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import com.sblog.beans.User;

@Repository("userRepository")
public class UserRepository extends BaseRepository<User> implements IUserRepository {

	@Autowired
	protected UserRepository(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	public boolean exists(String email) {
		int count = DataAccessUtils.intResult(getHibernateTemplate()
						.find("select count(*) from User where email = ?", email));
		return count > 0;
	}

	public User getById(String id) {
		return super.getByKey(id);
	}
}
