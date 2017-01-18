/** 
 * Project Name:slsys 
 * File Name:CompanyDaoImpl.java 
 * Package Name:com.sl.wholesale.company.dao.impl 
 * Date:2016年12月19日下午3:11:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.dao.impl;  

import java.util.Date;

import com.sl.global.dao.HibernateDao;
import com.sl.global.util.DateUtil;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.order.dao.OrderDao;

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
public class OrderDaoImpl extends HibernateDao<Order, Long> implements OrderDao {

	public OrderDaoImpl() {
		super(Order.class);
	}

	@Override
	public int getOrderSumToday() {
		Date startDate = DateUtil.getStartOfToDayDate();
		Date endDate = DateUtil.getStartOfTomorrowDate();
		String hql = "select count(*) from Order a where a.createDate >= ? and a.createDate < ? and a.state <> 0";
		return queryCountByHql(hql,startDate, endDate);
	}

	
}
  