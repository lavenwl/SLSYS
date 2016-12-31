/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.service.impl;  

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;
import com.sl.wholesale.order.dao.OrderDao;
import com.sl.wholesale.order.service.OrderService;
import com.sl.wholesale.userinfo.service.UserInfoService;

/** 
 * ClassName:CompanyServiceImpl <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月19日 下午3:15:09 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderDao> implements
		OrderService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public OrderServiceImpl() {
		super(Order.class, OrderDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private UserInfoService userInfoService;

	@Override
	public int save(Order order) {
		Long purchaseId = order.getUserInfoByPurchase().getId();
		Long saleId = order.getUserInfoBySale().getId();
		//处理内部bean对象
		order.setUserInfoByPurchase(userInfoService.queryById(order.getUserInfoByPurchase().getId()));
		order.setUserInfoBySale(userInfoService.queryById(order.getUserInfoBySale().getId()));
		super.save(order);
		return 1;
	}

	@Override
	public int update(Order order) {
		Long purchaseId = order.getUserInfoByPurchase().getId();
		Long saleId = order.getUserInfoBySale().getId();
		//处理内部bean对象
		order.setUserInfoByPurchase(userInfoService.queryById(order.getUserInfoByPurchase().getId()));
		order.setUserInfoBySale(userInfoService.queryById(order.getUserInfoBySale().getId()));
		super.update(order);
		return 1;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	
}
  