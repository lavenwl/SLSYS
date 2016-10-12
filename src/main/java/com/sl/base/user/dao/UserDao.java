/** 
 * Project Name:slsys 
 * File Name:UserDao.java 
 * Package Name:com.sl.base.user.dao 
 * Date:2016年10月9日下午5:00:23 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.dao;  

import java.util.List;

import com.sl.base.user.entity.User;

/** 
 * ClassName:UserDao <br/> 
 * Function: 用户持久层 <br/> 
 * Reason:   用户相关数据库访问具体逻辑 <br/>
 * Date:     2016年10月9日 下午5:00:23 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserDao {
	/**
	 * 
	 * save:保存用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param user 
	 * @since JDK 1.6
	 */
	public void save(User user); 
	
	/**
	 * 
	 * save:更新用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param user 
	 * @since JDK 1.6
	 */
	public void update(User user); 
	
	/**
	 * 
	 * save:删除用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param user 
	 * @since JDK 1.6
	 */
	public void deleteById(int id); 
	
	/**
	 * 
	 * save:根据ID查找用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param user 
	 * @since JDK 1.6
	 */
	public User findById(int id); 
	
	/**
	 * 
	 * save:查找所有用户对象. <br/> 
	 * 
	 * @author laven 
	 * @param user 
	 * @since JDK 1.6
	 */
	public List<User> findAll(); 
	
	/**
	 * 
	 * count:查询用户数量. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public int count();
}
  