/** 
 * Project Name:slsys 
 * File Name:CompanyDaoImpl.java 
 * Package Name:com.sl.wholesale.company.dao.impl 
 * Date:2016年12月19日下午3:11:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.orderdetail.dao.impl;  

import java.util.Date;

import com.sl.global.dao.HibernateDao;
import com.sl.global.util.DateUtil;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.orderdetail.dao.OrderDetailDao;

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
public class OrderDetailDaoImpl extends HibernateDao<OrderDetail, Long> implements OrderDetailDao {

	public OrderDetailDaoImpl() {
		super(OrderDetail.class);
	}

	@Override
	public int getOrderDetailSum(Long orderId) {
		String hql = "select count(*) from OrderDetail a where a.order.id = ? and a.state <> 0";
		return queryCountByHql(hql,orderId);
	}

}
  