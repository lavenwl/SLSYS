/** 
 * Project Name:slsys 
 * File Name:UserServiceImpl.java 
 * Package Name:com.sl.base.user.service.impl 
 * Date:2016年10月9日下午3:37:45 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.service.impl;  

import java.util.List;

import com.sl.base.user.dao.UserDao;
import com.sl.base.user.entity.User;
import com.sl.base.user.service.UserService;

/** 
 * ClassName:UserServiceImpl <br/> 
 * Function: 用户功能应用层 <br/> 
 * Reason:   用户相关功能具体业务逻辑类 <br/> 
 * Date:     2016年10月9日 下午3:37:45 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	@Override
	public List<User> listUsers() {
		return userDao.findAll();
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
  