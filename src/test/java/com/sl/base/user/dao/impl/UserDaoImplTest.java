/** 
 * Project Name:slsys 
 * File Name:UserDaoImplTest.java 
 * Package Name:com.sl.base.user.dao.impl 
 * Date:2016年10月10日上午11:13:14 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.dao.impl;  

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sl.base.user.dao.UserDao;
import com.sl.base.user.entity.User;

/** 
 * ClassName:UserDaoImplTest <br/> 
 * Function: 测试类<br/> 
 * Reason:   持久层操作逻辑测试 <br/> 
 * Date:     2016年10月10日 上午11:13:14 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserDaoImplTest {
	private Logger log = LoggerFactory.getLogger(UserDaoImplTest.class);
	private static ApplicationContext ac = null;
	private static UserDao userDao = null;
	
	public ApplicationContext getAc()
	{
		if(ac == null)
		{
			ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		}
		return ac;
	}
	
	public UserDao getUserDao()
	{
		if(userDao == null)
		{
			userDao = (UserDao) getAc().getBean("userDao");
		}
		return userDao;
	}
	
	public UserDaoImplTest(){
		getUserDao();
	}
	
	@Test
	public void testSave() {
		User user = new User();
		user.setNickname("123");
		userDao.save(user);
		log.debug("test save");
	}
	
	@Test
	public void testFindeById(){
		userDao.findById(4);
	}

}
  