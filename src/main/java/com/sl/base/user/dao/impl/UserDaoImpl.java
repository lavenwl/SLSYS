/** 
 * Project Name:slsys 
 * File Name:UserDaoImpl.java 
 * Package Name:com.sl.base.user.dao.impl 
 * Date:2016年10月9日下午5:01:48 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.dao.impl;  

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.sl.base.user.dao.UserDao;
import com.sl.base.user.entity.User;

/** 
 * ClassName:UserDaoImpl <br/> 
 * Function: 用户持久层 <br/> 
 * Reason:   用户相关数据库访问具体逻辑 <br/>
 * Date:     2016年10月9日 下午5:01:48 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public void deleteById(int id) {
		User user = findById(id);
		this.getHibernateTemplate().delete(user);
	}

	@Override
	public User findById(int id) {
		String hql = "from User where id=?";
		List<?> list = this.getHibernateTemplate().find(hql,new Object[]{id}); 
		if(!list.isEmpty())
		{
			return (User)list.get(0); 
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		String hql = "from User";
		return (List<User>) this.getHibernateTemplate().find(hql);
	}

	@Override
	public int count() {
		String hql = "select count(*) from User";
		List<?> list = this.getHibernateTemplate().find(hql); 
		return Integer.valueOf(list.get(0).toString());
	}



}
  