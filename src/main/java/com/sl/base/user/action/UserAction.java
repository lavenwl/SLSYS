/** 
 * Project Name:slsys 
 * File Name:UserAction.java 
 * Package Name:com.sl.base.user.action 
 * Date:2016年10月10日下午5:02:35 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.action;  

import java.util.List;

import com.sl.base.user.dao.UserDao;
import com.sl.base.user.entity.User;
import com.sl.base.user.service.UserService;

/** 
 * ClassName:UserAction <br/> 
 * Function: 用户相关请求分发类 <br/> 
 * Reason:   用户相关请求分发处理逻辑 <br/> 
 * Date:     2016年10月10日 下午5:02:35 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserAction {
	private List<User> userList;
	private UserService userService;
	private UserDao userDao;
	public String listUsers(){
		userList = userService.listUsers();
		return "success";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
}
  