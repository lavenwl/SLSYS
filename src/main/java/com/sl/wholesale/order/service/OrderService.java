/** 
 * Project Name:slsys 
 * File Name:CompanyService.java 
 * Package Name:com.sl.wholesale.company.service 
 * Date:2016年12月19日下午3:13:22 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.service;  

import com.sl.global.service.BaseService;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.order.dao.OrderDao;

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
public interface OrderService extends BaseService<Order, OrderDao> {

	double getPrice(Long goodsId, Long saleModeId);

	Order add();

}
  