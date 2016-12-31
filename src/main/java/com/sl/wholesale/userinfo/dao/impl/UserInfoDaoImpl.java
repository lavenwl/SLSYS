/** 
 * Project Name:slsys 
 * File Name:CompanyDaoImpl.java 
 * Package Name:com.sl.wholesale.company.dao.impl 
 * Date:2016年12月19日下午3:11:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.userinfo.dao.impl;  

import com.sl.global.dao.HibernateDao;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.UserInfo;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.userinfo.dao.UserInfoDao;

/** 
 * ClassName:CompanyDaoImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:11:05 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UserInfoDaoImpl extends HibernateDao<UserInfo, Long> implements UserInfoDao {

	public UserInfoDaoImpl() {
		super(UserInfo.class);
	}

}
  