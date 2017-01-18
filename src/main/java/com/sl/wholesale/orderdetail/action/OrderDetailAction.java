/** 
 * Project Name:slsys 
 * File Name:ItemAction.java 
 * Package Name:com.sl.wholesale.item.action 
 * Date:2016年11月18日下午7:43:02 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.orderdetail.action;  

import com.sl.global.action.BaseAction;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.orderdetail.service.OrderDetailService;

/** 
 * ClassName:ItemAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:43:02 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class OrderDetailAction extends BaseAction<OrderDetail,OrderDetailService> {
	public OrderDetailAction() throws ClassNotFoundException{
		super(OrderDetail.class, OrderDetailService.class);
	}
	
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private OrderDetail orderDetail = new OrderDetail();
	private OrderDetailService orderDetailService;
	
	public String update(){
		return super.update(orderDetail);
	}
	
	public String save(){
		return super.save(orderDetail);
	}
	/**
	 * 
	 * addTr:订单页面添加一行明细. <br/> 
	 * 只能订单页面调用这个方法，因为返回的字段是这个页面所特殊的.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String addTr(){
		String orderId = request.getParameter("orderId");
		OrderDetail orderDetail = orderDetailService.addTr(Long.parseLong(orderId));
		store.setDataDetail(orderDetail);
		return "addTr";
	}
	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public OrderDetailService getOrderDetailService() {
		return orderDetailService;
	}

	public void setOrderDetailService(OrderDetailService orderDetailService) {
		this.orderDetailService = orderDetailService;
	}
	
	
}
  