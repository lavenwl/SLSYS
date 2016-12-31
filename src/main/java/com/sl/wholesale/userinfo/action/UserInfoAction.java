/** 
 * Project Name:slsys 
 * File Name:GoodsAction.java 
 * Package Name:com.sl.wholesale.goods.action 
 * Date:2016年11月18日下午7:36:50 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.userinfo.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.UserInfo;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.userinfo.service.UserInfoService;

/** 
 * ClassName:GoodsAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:36:50 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserInfoAction extends BaseAction<UserInfo,UserInfoService>{
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -4431445486861351032L;
	/**
	 * 
	 * Creates a new instance of GoodsAction. 
	 * 
	 * @throws ClassNotFoundException
	 */
	public UserInfoAction() throws ClassNotFoundException{
		super(UserInfo.class, UserInfoService.class);
	}
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private UserInfo userInfo = new UserInfo();
	
	public String update(){
		return super.update(userInfo);
	}
	
	public String save(){
		return super.save(userInfo);
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}



	
}
  