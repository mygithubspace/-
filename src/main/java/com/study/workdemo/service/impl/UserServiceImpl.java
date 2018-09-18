package com.study.workdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.workdemo.entity.User;
import com.study.workdemo.repository.UserRepository;
import com.study.workdemo.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

}
