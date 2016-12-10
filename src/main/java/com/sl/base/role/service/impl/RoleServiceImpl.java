/** 
 * Project Name:slsys 
 * File Name:RoleServiceImpl.java 
 * Package Name:com.sl.base.role.service.impl 
 * Date:2016年12月10日上午11:39:17 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.role.service.impl;  

import java.util.List;

import com.sl.base.entity.hibernate.BaseRole;
import com.sl.base.role.dao.RoleDao;
import com.sl.base.role.service.RoleService;
import com.sl.global.entity.QueryBean;

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
public class RoleServiceImpl implements RoleService {
	private RoleDao roleDao;
	@Override
	public List<BaseRole> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseRole> query(QueryBean queryRoleBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseRole queryById(long id) {
		return roleDao.queryById(id);
	}

	@Override
	public int deleteById(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(BaseRole baseRole) {
		// TODO Auto-generated method stub
		return 0;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
  