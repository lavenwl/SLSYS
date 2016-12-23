/** 
 * Project Name:slsys 
 * File Name:RoleServiceImpl.java 
 * Package Name:com.sl.base.role.service.impl 
 * Date:2016年12月10日上午11:39:17 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.role.service.impl;  

import com.sl.base.entity.hibernate.Role;
import com.sl.base.role.dao.RoleDao;
import com.sl.base.role.service.RoleService;
import com.sl.global.service.impl.BaseServiceImpl;

/** 
 * ClassName:RoleServiceImpl <br/> 
 * Function: 用户角色服务层实现类. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月10日 上午11:39:17 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleDao> implements RoleService {
	public RoleServiceImpl() {
		super(Role.class, RoleDao.class);
	}
}
  