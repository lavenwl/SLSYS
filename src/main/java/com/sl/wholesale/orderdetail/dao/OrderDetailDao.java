/** 
 * Project Name:slsys 
 * File Name:CompanyDao.java 
 * Package Name:com.sl.wholesale.company.dao 
 * Date:2016年12月19日下午3:07:50 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.orderdetail.dao;  

import com.sl.global.dao.BaseDao;
import com.sl.wholesale.entity.hibernate.OrderDetail;

/** 
 * ClassName:CompanyDao <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:07:50 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface OrderDetailDao extends BaseDao<OrderDetail, Long> {

	int getOrderDetailSum(Long orderId);

}
  