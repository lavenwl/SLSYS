/** 
 * Project Name:slsys 
 * File Name:UserService.java 
 * Package Name:com.sl.base.user.service 
 * Date:2016年10月10日下午5:10:51 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.service;  

import java.util.List;

import com.sl.base.user.entity.User;

/** 
 * ClassName:UserService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年10月10日 下午5:10:51 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserService {
	public List<User> listUsers();
}
  