package com.pb.web.action;

import java.util.Map;

import com.pb.biz.IUserBiz;

public class UserAction extends BaseAction {
	private IUserBiz biz;
	private String username;
	private String password;
	private String tip;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setBiz(IUserBiz biz) {
		this.biz = biz;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String login() {
		Map<String, Object> map=biz.login(username, password); // 用户登录
		if(map.get("user")!=null){
			session.put("user", map.get("user")); // 用户登陆成功
		}else{
			// 用户登录失败
			if(map.get("pwd_error")!=null){
				this.setTip(String.valueOf(map.get("pwd_error")));
			}else if(map.get("no_user")!=null){
				this.setTip(String.valueOf(map.get("no_user")));
			}
			return ERROR;
		}
		return SUCCESS;
	}
}
