/** 
 * Project Name:slsys 
 * File Name:UserAction.java 
 * Package Name:com.sl.base.user.action 
 * Date:2016年10月10日下午5:02:35 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.action;  

import java.util.Date;
import java.util.List;

import com.sl.base.entity.hibernate.BaseUser;
import com.sl.base.user.entity.QueryUserBean;
import com.sl.base.user.service.UserService;
import com.sl.global.action.BaseAction;
import com.sl.global.entity.QueryBean;


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
public class UserAction extends BaseAction<BaseUser>{
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -6030003070957722917L;
	
	private UserService userService;
	
	private BaseUser baseUser = new BaseUser();
	
	public String execute(){
		return list();
	}

	public String add(){
		BaseUser baseUser = new BaseUser();
		baseUser.setCreateDate(new Date());
		baseUser.setUpdateDate(new Date());
		store.setDataDetail(baseUser);
		return "userAdd";
	}
	
	public String list(){
		List<BaseUser> userList = userService.list();
		store.setDataList(userList);
		return "userList";
	}
	
	public String detail(){
		long id = Long.valueOf(request.getParameter("id"));
		BaseUser baseUser = userService.queryById(id);
		store.setDataDetail(baseUser);
		return "userDetail";
	}
	
	public String edit(){
		long id = Long.valueOf(request.getParameter("id"));
		BaseUser baseUser = userService.queryById(id);
		store.setDataDetail(baseUser);
		return "userEdit";
	}
	
	public String update(){
		if(null != baseUser){
			int res = userService.update(baseUser);
		}
		return "userUpdate";
	}
	
	public String delete(){
		long id = Long.valueOf(request.getParameter("id"));
		int res = userService.deleteById(id);
		return "userDelete";
	}
	
	public String save(){
		if(null != baseUser){
			int res = userService.save(baseUser);
		}
		return "userSave";
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BaseUser getBaseUser() {
		return baseUser;
	}

	public void setBaseUser(BaseUser baseUser) {
		this.baseUser = baseUser;
	}

	
	
}
  