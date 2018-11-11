package com.pb.dao;

import java.util.List;

import com.pb.entity.User;

public interface IUserDao extends IBaseDao<User> {
	public static final String USERNAME="username"; // 用户名
	// 按用户名查询
	public List<User> findByUsername(String username);
}
