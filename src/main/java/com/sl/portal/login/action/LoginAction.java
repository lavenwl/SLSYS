/** 
 * Project Name:slsys 
 * File Name:LoginAction.java 
 * Package Name:com.sl.portal.login.action 
 * Date:2016年11月16日下午9:47:12 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.login.action;  

import java.util.ArrayList;

import antlr.collections.List;

import com.sl.base.entity.hibernate.BaseUser;
import com.sl.global.action.BaseAction;

/** 
 * ClassName:LoginAction <br/> 
 * Function: 登陆相关请求类. <br/> 
 * Date:     2016年11月16日 下午9:47:12 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class LoginAction extends BaseAction<BaseUser>{
	
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -7572466147970157505L;

	private BaseUser user;
	
	@Override
	public String execute() {
		user = new BaseUser();
		user.setId(2);
		ArrayList<BaseUser> list = new ArrayList<BaseUser>();
		list.add(new BaseUser());
		store.setName("test");
		store.setDataList(list);
		return "success";
	}

	
	public String list() {
		user = new BaseUser();
		user.setId(2);
		ArrayList<BaseUser> list = new ArrayList<BaseUser>();
		list.add(new BaseUser());
		store.setName("test");
		store.setDataList(list);
		return "success";
	}
	
	public String login(){
		user = new BaseUser();
		user.setId(2);
		ArrayList<BaseUser> list = new ArrayList<BaseUser>();
		list.add(new BaseUser());
		store.setName("test");
		store.setDataList(list);
		return "success";
	}

	public BaseUser getUser() {
		return user;
	}

	public void setUser(BaseUser user) {
		this.user = user;
	}
	
	
}
  