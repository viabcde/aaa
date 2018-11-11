package com.pb.biz;
import java.util.Map;
import com.pb.entity.User;
public interface IUserBiz {
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	public Map<String, Object> login(String username, String password);
	/**
	 * 保存用户对象
	 * @param user
	 * @return
	 */
	public boolean save(User user);
}
