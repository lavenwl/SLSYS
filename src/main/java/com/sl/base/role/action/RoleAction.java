/** 
 * Project Name:slsys 
 * File Name:UserAction.java 
 * Package Name:com.sl.base.user.action 
 * Date:2016年10月10日下午5:02:35 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.role.action;  

import com.sl.base.entity.hibernate.Role;
import com.sl.base.role.service.RoleService;
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
public class RoleAction extends BaseAction<Role, RoleService>{
	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = -6030003070957722917L;
	/**
	 * 
	 * Creates a new instance of RoleAction. 
	 * 初始化父类两个参数，处理的实体类。处理这个实体类需要的服务层类
	 * 
	 * @throws ClassNotFoundException
	 */
	public RoleAction() throws ClassNotFoundException{
		super(Role.class, RoleService.class);
	}
	/**
	 * 新增数据时用于接收页面传来的新数据
	 */
	private Role role = new Role();

	public String update(){
		return super.update(role);
	}
	
	public String save(){
		return super.save(role);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
  