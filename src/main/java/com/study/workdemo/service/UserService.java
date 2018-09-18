package com.study.workdemo.service;

import com.study.workdemo.entity.User;

public interface UserService {

	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User findByUserName(String userName);
	/**
	 * 添加用户
	 * @param user
	 */
	public void save(User user);
	
}
