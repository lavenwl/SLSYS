/** 
 * Project Name:slsys 
 * File Name:UserDao.java 
 * Package Name:com.sl.base.user.dao 
 * Date:2016年10月9日下午5:00:23 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.dao;  

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import com.sl.base.entity.hibernate.BaseUser;
import com.sl.global.dao.BaseDao;
import com.sl.global.entity.QueryBean;

/** 
 * ClassName:UserDao <br/> 
 * Function: 用户持久层 <br/> 
 * Reason:   用户相关数据库访问具体逻辑 <br/>
 * Date:     2016年10月9日 下午5:00:23 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface UserDao extends BaseDao<BaseUser, Long> {


}
  