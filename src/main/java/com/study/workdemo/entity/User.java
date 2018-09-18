package com.study.workdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chengpeng
 * @create 2018-09-18 15:30
 * 用户实体类
 */
@Entity
@Table(name="t_user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;//编号
	@Column(length=50)
    private String userName;//用户名
	@Column(length=50)
    private String password;//密码

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
