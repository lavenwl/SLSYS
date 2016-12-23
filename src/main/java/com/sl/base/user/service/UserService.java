/** 
 * Project Name:slsys 
 * File Name:UserService.java 
 * Package Name:com.sl.base.user.service 
 * Date:2016年10月10日下午5:10:51 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.service;  

import com.sl.base.entity.hibernate.User;
import com.sl.base.user.dao.UserDao;
import com.sl.global.service.BaseService;

/** 
 * ClassName:UserService <br/> 
 * Function: 用户服务层. <br/> 
 * Reason:   用户相关逻辑处理类. <br/> 
 * Date:     2016年10月10日 下午5:10:51 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserService extends BaseService<User, UserDao>{
	
}
  