/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.service.impl;  

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.global.util.DateUtil;
import com.sl.global.util.StringUtil;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.goods.dao.GoodsDao;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.goodstype.service.GoodsTypeService;
import com.sl.wholesale.order.dao.OrderDao;
import com.sl.wholesale.order.service.OrderService;
import com.sl.wholesale.price.service.PriceService;
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
	private PriceService priceService;
	private OrderDao orderDao;

	@Override
	public Order save(Order order) {
		return super.save(order);
	}

	
	@Override
	public int update(Order order) {
		super.update(order);
		return 1;
	}

	public int update(String contentStr){
		JSONObject jsonContent = JSON.parseObject(contentStr);
		String s = jsonContent.get("orderStr").toString();
		String ss = jsonContent.get("orderDetailStr").toString();
		Order order = JSON.toJavaObject(JSON.parseObject(s), Order.class); //.parseObject(s, Order.class);
		List<OrderDetail> orderDetailList = JSON.parseArray(ss, OrderDetail.class);
		order.setOrderDetails(new HashSet(orderDetailList));
		super.update(order);
		return 1;
	}
	
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public PriceService getPriceService() {
		return priceService;
	}

	public void setPriceService(PriceService priceService) {
		this.priceService = priceService;
	}

	@Override
	public double getPrice(Long goodsId, Long saleModeId) {
		double price = priceService.getPrice(goodsId, saleModeId);
		return price;
	}

	@Override
	public Order add() {
		Order order = new Order();
		String orderCode = getNewOrderCode();
		order.setOrderCode(orderCode);
		order.setCreateDate(new Date());
		order.setUpdateDate(new Date());
		order.setState(1);
		order = save(order);
		return order;
	}

	private String getNewOrderCode() {
		String dateString = DateUtil.getDateCodeString();
		String indexString = getIndexStr();
		return dateString + indexString;
	}
	
	/**
	 * 
	 * getOrderSumToday:获取订单号的序列号部分. <br/> 
	 * 生成订单号的时候使用.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	private String getIndexStr() {
			int sum = orderDao.getOrderSumToday();
			return StringUtil.fillLeft(String.valueOf(sum+1), '0', 4);
		}
	
	public static void main(String[] args) {
		String dateString = DateUtil.getDateCodeString();
		System.out.println(StringUtil.fillLeft("12", '0', 4));
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
}
  