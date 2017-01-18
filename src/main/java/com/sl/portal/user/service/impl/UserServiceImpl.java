/** 
 * Project Name:slsys 
 * File Name:UserServiceImpl.java 
 * Package Name:com.sl.base.user.service.impl 
 * Date:2016年10月9日下午3:37:45 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.user.service.impl;  

import com.sl.portal.entity.hibernate.User;
import com.sl.portal.role.service.RoleService;
import com.sl.portal.user.dao.UserDao;
import com.sl.portal.user.service.UserService;
import com.sl.global.service.impl.BaseServiceImpl;

/** 
 * ClassName:UserServiceImpl <br/> 
 * Function: 用户功能应用层 <br/> 
 * Reason:   用户相关功能具体业务逻辑类 <br/> 
 * Date:     2016年10月9日 下午3:37:45 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService{
	private RoleService roleService;
	public UserServiceImpl(){
		super(User.class, UserDao.class);
	}
	
	@Override
	public User save(User user) {
		Long id = user.getRole().getId();
		//处理内部bean对象
		//TODO 测试这里的逻辑是否可以去掉
		user.setRole(roleService.queryById(user.getRole().getId()));
		return super.save(user);
	}

	@Override
	public int update(User user) {
		Long id = user.getRole().getId();
		//处理内部bean对象
		//TODO 测试这里的逻辑是否可以去掉
		user.setRole(roleService.queryById(user.getRole().getId()));
		super.update(user);
		return 1;
	}

	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
}
  