/** 
 * Project Name:slsys 
 * File Name:CompanyServiceImpl.java 
 * Package Name:com.sl.wholesale.company.service.impl 
 * Date:2016年12月19日下午3:15:09 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.orderdetail.service.impl;  

import java.util.Date;

import com.sl.global.service.impl.BaseServiceImpl;
import com.sl.global.util.StringUtil;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.goods.service.GoodsService;
import com.sl.wholesale.orderdetail.dao.OrderDetailDao;
import com.sl.wholesale.orderdetail.service.OrderDetailService;
import com.sl.wholesale.order.service.OrderService;
import com.sl.wholesale.salemode.service.SaleModeService;

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
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, OrderDetailDao> implements
		OrderDetailService {
	/**
	 * 
	 * Creates a new instance of GoodsServiceImpl. 
	 *
	 */
	public OrderDetailServiceImpl() {
		super(OrderDetail.class, OrderDetailDao.class);
	}
	/**
	 * 物资类型的服务类
	 */
	private OrderService orderService;
	private GoodsService goodsService;
	private SaleModeService saleModeService;
	private OrderDetailDao orderDetailDao;
	
	@Override
	public OrderDetail add() {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setCreateDate(new Date());
		orderDetail.setUpdateDate(new Date());
		orderDetail.setState(1);
		orderDetail = save(orderDetail);
		return orderDetail;
	}
	
	private String getNewOrderDetailCode(Long orderId) {
		String orderCode = orderService.queryById(orderId).getOrderCode();
		String indexString = getIndexStr(orderId);
		return orderCode + indexString;
	}

	private String getIndexStr(Long orderId) {
		int sum = orderDetailDao.getOrderDetailSum(orderId);
		return StringUtil.fillLeft(String.valueOf(sum+1), '0', 4);
	}

	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		Long orderId = orderDetail.getOrder().getId();
		Long goodsId = orderDetail.getGoods().getId();
		Long saleModeId = orderDetail.getSaleMode().getId();
		//处理内部bean对象
		orderDetail.setOrder(orderService.queryById(orderDetail.getOrder().getId()));
		orderDetail.setGoods(goodsService.queryById(goodsId));
		orderDetail.setSaleMode(saleModeService.queryById(saleModeId));
		return super.save(orderDetail);
	}

	@Override
	public int update(OrderDetail orderDetail) {
		Long orderId = orderDetail.getOrder().getId();
		Long goodsId = orderDetail.getGoods().getId();
		Long saleModeId = orderDetail.getSaleMode().getId();
		//处理内部bean对象
		orderDetail.setOrder(orderService.queryById(orderDetail.getOrder().getId()));
		orderDetail.setGoods(goodsService.queryById(goodsId));
		orderDetail.setSaleMode(saleModeService.queryById(saleModeId));
		super.update(orderDetail);
		return 1;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public SaleModeService getSaleModeService() {
		return saleModeService;
	}

	public void setSaleModeService(SaleModeService saleModeService) {
		this.saleModeService = saleModeService;
	}

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public void setOrderDetailDao(OrderDetailDao orderDetailDao) {
		this.orderDetailDao = orderDetailDao;
	}

	@Override
	public OrderDetail addTr(Long orderId) {
		OrderDetail orderDetail = new OrderDetail();
		String orderDetailCode = getNewOrderDetailCode(orderId);
		orderDetail.setOrderDetailCode(orderDetailCode);
		orderDetail.setOrder(orderService.queryById(orderId));
		orderDetail.setGoods(goodsService.queryById(1));
		orderDetail.setSaleMode(saleModeService.queryById(1));
		orderDetail.setCreateDate(new Date());
		orderDetail.setUpdateDate(new Date());
		orderDetail.setState(1);
		orderDetail = save(orderDetail);
		return orderDetail;
	}

	
}
  