package com.pb.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pb.biz.IUserBiz;
import com.pb.dao.IUserDao;
import com.pb.entity.User;

public class UserBizImpl implements IUserBiz {
	private IUserDao dao;

	public void setDao(IUserDao dao) {
		this.dao = dao;
	}
	/**
	 * 用户登录
	 */
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> list = dao.findByUsername(username!=null?username.trim():"");
		if (list != null && list.size() > 0) {
			User user=list.get(0); // 取得用户
			if (password != null && user.getPassword() != null && password.trim().equals(user.getPassword().trim())) {
				map.put("user", user); // 保存用户
			}else{
				map.put("pwd_error", "pwd_error"); // 密码错误
			}
		}else{
			map.put("no_user", "no_user"); // 用户名不存在
		}
		return map;
	}
	/**
	 * 保存用户对象
	 */
	public boolean save(User user) {
		return dao.save(user);
	}
}
