/** 
 * Project Name:slsys 
 * File Name:LoginAction.java 
 * Package Name:com.sl.portal.login.action 
 * Date:2016年11月16日下午9:47:12 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.login.action;  

import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;
import com.sl.portal.entity.hibernate.User;
import com.sl.portal.login.service.LoginService;
import com.sl.wholesale.entity.hibernate.UserInfo;

/** 
 * ClassName:LoginAction <br/> 
 * Function: 登陆相关请求类. <br/> 
 * Date:     2016年11月16日 下午9:47:12 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class LoginAction extends BaseAction<User,LoginService>{
	
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -7572466147970157505L;

	public LoginAction() throws ClassNotFoundException{
		super(User.class, LoginService.class);
	}
	
}
  