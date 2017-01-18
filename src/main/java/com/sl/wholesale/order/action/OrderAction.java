/** 
 * Project Name:slsys 
 * File Name:OrderAction.java 
 * Package Name:com.sl.wholesale.order.action 
 * Date:2016年11月18日下午7:41:36 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.wholesale.order.action;  

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;
import com.sl.wholesale.entity.hibernate.Goods;
import com.sl.wholesale.entity.hibernate.Order;
import com.sl.wholesale.entity.hibernate.OrderDetail;
import com.sl.wholesale.order.service.OrderService;

/** 
 * ClassName:OrderAction <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年11月18日 下午7:41:36 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class OrderAction extends BaseAction<Order, OrderService> {
	public OrderAction() throws ClassNotFoundException{
		super(Order.class, OrderService.class);
	}
	/**
	 * 新增数据时，接收页面传过来的数据
	 */
	private Order order = new Order();
	private OrderService orderService;

	public String add() throws InstantiationException, IllegalAccessException{
		Order order = orderService.add();
		store.setDataDetail(order);
		return "add";
	}
	public String update(){
		return super.update(contentStr);
	}

	

	public String save(){
		return super.save(order);
	}
	/**
	 * 
	 * addItem:订单页面添加一条明细信息. <br/> 
	 * 只允许在订单页面调用这个方法，因为这里返回的字段只针对这个页面特殊设置.<br/> 
	 * 为了统一页面的请求格式，这里只起到转发的作用，真正的处理逻辑在orderDetailService中.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String addOrderDetail(){
		return "addOrderDetail";
	}
	
	public String getPrice(){
		Long goodsId = Long.parseLong(request.getParameter("goodsId"));
		Long saleModeId = Long.parseLong(request.getParameter("saleModeId"));
		double price = orderService.getPrice(goodsId, saleModeId);
		 try{
		     response.setContentType("text/plain");  
		     response.setCharacterEncoding("utf-8");
	         response.getWriter().print(price);//把相应的地址放到前台解析，通过#符号分割  
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return null;  
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}


	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	
	
	public static void main(String[] args) {
		Map<String, String> request = new HashMap<String, String>();
		request.put("id", "[1,3,5]");
		request.put("name", "[laven,day,name]");
		Class c = Order.class;
		
		Field[] fields = c.getDeclaredFields();
		List<String> fieldList = new ArrayList<String>();
		Map<String, String> fieldMap = new HashMap<String, String>();
		for(Field field : fields){
			fieldList.add(field.getName());
			fieldMap.put(field.getName(), "");
			System.out.println(field.getName());
			System.out.println(field.getType());
			System.out.println(field.toGenericString());
			System.out.println("------------------");
		}
	}
	
}
  