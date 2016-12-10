/** 
 * Project Name:slsys 
 * File Name:RoleDaoImpl.java 
 * Package Name:com.sl.base.role.dao.impl 
 * Date:2016年12月10日上午11:46:26 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.role.dao.impl;  

import java.util.List;

import com.sl.base.entity.hibernate.BaseRole;
import com.sl.base.role.dao.RoleDao;
import com.sl.global.dao.HibernateDao;
import com.sl.global.entity.QueryBean;

/** 
 * ClassName:RoleDaoImpl <br/> 
 * Function: 用户角色持久层实现类. <br/> 
 * Date:     2016年12月10日 上午11:46:26 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class RoleDaoImpl extends HibernateDao<BaseRole, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(BaseRole.class);
	}
}
  