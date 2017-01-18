/** 
 * Project Name:slsys 
 * File Name:CompanyService.java 
 * Package Name:com.sl.wholesale.company.service 
 * Date:2016年12月19日下午3:13:22 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.orderdetail.service;  

import com.sl.global.service.BaseService;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.orderdetail.dao.OrderDetailDao;

/** 
 * ClassName:CompanyService <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:13:22 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public interface OrderDetailService extends BaseService<OrderDetail, OrderDetailDao> {

	OrderDetail add();

	OrderDetail addTr(Long orderId);

}
  