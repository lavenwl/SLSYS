/** 
 * Project Name:slsys 
 * File Name:UserAction.java 
 * Package Name:com.sl.base.user.action 
 * Date:2016年10月10日下午5:02:35 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.user.action;  

import com.sl.portal.entity.hibernate.User;
import com.sl.portal.user.service.UserService;
import com.sl.global.action.BaseAction;


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
public class UserAction extends BaseAction<User, UserService>{
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -6030003070957722917L;
	/**
	 * 新增数据时接收页面传来的值
	 */
	private User user = new User();
	/**
	 * 
	 * Creates a new instance of UserAction. 
	 * 初始化父类处理的实体类及处理实体类的服务类
	 * 
	 * @throws ClassNotFoundException
	 */
	public UserAction() throws ClassNotFoundException{
		super(User.class, UserService.class);
	}
	
	public String update(){
		return super.update(user);
	}
	
	public String save(){
		return super.save(user);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
  