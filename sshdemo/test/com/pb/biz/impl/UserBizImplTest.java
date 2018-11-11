package com.pb.biz.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pb.biz.IUserBiz;
import com.pb.entity.User;

import junit.framework.Assert;
import junit.framework.TestCase;

public class UserBizImplTest extends TestCase {
	private IUserBiz biz;

	protected void setUp() throws Exception {
		super.setUp();
		// 实例化Spring容器
		System.out.println("初始化spring开始....");
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		// 取得UserBizImpl对象
		System.out.println("初始化spring结束....");
		biz=(IUserBiz) ac.getBean("userBiz");
		System.out.println("测试前....");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		System.out.println("测试后....");
	}

	/**
	 * 测试用户登录是否成功
	 */
	public void testLogin() {
		Assert.assertTrue(biz.login("admin", "admin").get("user")!=null);
	}
	
	/**
	 * 测试保存用户对象
	 */
	public void testSave(){
		User user=new User();
		user.setUsername("admin");
		user.setPassword("admin");
		Assert.assertTrue(biz.save(user));
	}
}
