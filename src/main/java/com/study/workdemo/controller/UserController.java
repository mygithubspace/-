package com.study.workdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.workdemo.entity.User;
import com.study.workdemo.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengpeng
 * @create 2018-09-18 14:10
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        User currentUser = userService.findByUserName(user.getUserName());
        if (currentUser==null || !user.getPassword().equals(currentUser.getPassword())){
            map.put("success",false);
            map.put("errorMsg","用户名或密码错误！");
        }
        else {
        	map.put("success", true);
            if (currentUser!=null) {
            	currentUser.setPassword("");
			}
            map.put("currentUser",currentUser);
        }
        return map;
    }
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(User user){
    	Map<String, Object> map=new HashMap<>();
    	if (userService.findByUserName(user.getUserName())!=null) {
    		map.put("success", false);
    		map.put("errorMsg", "用户名已存在");
    	}else {
    		userService.save(user);
    		map.put("success", true);
		}
    	return map;
    }
}
