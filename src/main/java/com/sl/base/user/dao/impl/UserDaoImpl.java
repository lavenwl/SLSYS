/** 
 * Project Name:slsys 
 * File Name:UserDaoImpl.java 
 * Package Name:com.sl.base.user.dao.impl 
 * Date:2016年10月9日下午5:01:48 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.dao.impl;  

import com.sl.base.entity.hibernate.User;
import com.sl.base.user.dao.UserDao;
import com.sl.global.dao.HibernateDao;

/** 
 * ClassName:UserDaoImpl <br/> 
 * Function: 用户持久层 <br/> 
 * Reason:   用户相关数据库访问具体逻辑 <br/>
 * Date:     2016年10月9日 下午5:01:48 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserDaoImpl extends HibernateDao<User, Long> implements UserDao {

	@SuppressWarnings("unchecked")
	public UserDaoImpl() {
		super(User.class);
	}
	
}
  