package com.pb.dao.impl;

import java.util.List;
import com.pb.dao.IUserDao;
import com.pb.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

	public List<User> findByUsername(String username) {
		return findByProperty(USERNAME, username);
	}
	
}
