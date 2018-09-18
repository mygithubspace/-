package com.study.workdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.study.workdemo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value="select * from t_user where user_name=?1",nativeQuery=true)
	public User findByUserName(String userName);
}
