/** 
 * Project Name:slsys 
 * File Name:LoginServiceImpl.java 
 * Package Name:com.sl.portal.login.service.impl 
 * Date:2016年11月16日下午11:00:07 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.login.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.portal.entity.hibernate.User;
import com.sl.portal.login.service.LoginService;
import com.sl.portal.user.dao.UserDao;

/** 
 * ClassName:LoginServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月16日 下午11:00:07 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class LoginServiceImpl extends BaseServiceImpl<User, UserDao> implements
LoginService{

	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public LoginServiceImpl() {
		super(User.class, UserDao.class);
	}

}
  