
/** 
 * Project Name:slsys 
 * File Name:Menu.java 
 * Package Name:com.sl.portal.entity 
 * Date:2016年11月18日下午3:53:37 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.portal.entity;  

import java.util.ArrayList;
import java.util.List;

/** 
 * ClassName:Menu <br/> 
 * Function: 菜单类. <br/> 
 * Reason:   临时添加，写入一些固定数据，后续会挪动到base目录下以建表的形式赋予权限功能. <br/> 
 * Date:     2016年11月18日 下午3:53:37 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class Menu {
	//菜单名
	private String name;
	//命名空间
	private String namespace;
	//请求名称
	private String action;
	//下级菜单
	private List<Menu> subMenu;
	
	public Menu(String name, String namespace, String action, List<Menu> subMenu){
		this.name = name;
		this.namespace= namespace;
		this.action = action;
		this.subMenu = subMenu;
	}
	public Menu() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNamespace() {
		return namespace;
	}
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	
	public static List<Menu> getTestData(){
		List<Menu> list = new ArrayList<Menu>();
		Menu menu1 = new Menu("制作订单","ws","order.action",null);
		Menu menu2 = new Menu("我的订单","ws","order!list.action",null);
		List<Menu> list1 = new ArrayList<Menu>();
		list1.add(menu1);
		list1.add(menu2);
		Menu menuF1 = new Menu("平台交易","ws","",list1);
		
		Menu menu3 = new Menu("商品管理","ws","goods.action",null);
		
		Menu menu41 = new Menu("测试列表","","",null);
		Menu menu42 = new Menu("测试列表","","",null);
		Menu menu43 = new Menu("测试列表","","",null);
		List<Menu> list4 = new ArrayList<Menu>();
		list4.add(menu41);
		list4.add(menu42);
		list4.add(menu43);
		Menu menu4 = new Menu("商品种类","ws","goodsType.action",list4);
		Menu menu5 = new Menu("用户管理","portal","user.action",null);
		Menu menu6 = new Menu("角色管理","portal","role.action",null);
		Menu menu7 = new Menu("商家管理","ws","company.action",null);
		Menu menu8 = new Menu("订单管理","ws","order.action",null);
		Menu menu9 = new Menu("订单详情","ws","orderDetail.action",null);
		Menu menu10 = new Menu("用户详情","ws","userInfo.action",null);
		Menu menu11 = new Menu("销售模式","ws","saleMode.action",null);
		Menu menu12 = new Menu("组合单价","ws","price.action",null);
		List<Menu> list2 = new ArrayList<Menu>();
		list2.add(menu3);
		list2.add(menu4);
		list2.add(menu5);
		list2.add(menu6);
		list2.add(menu7);
		list2.add(menu8);
		list2.add(menu9);
		list2.add(menu10);
		list2.add(menu11);
		list2.add(menu12);
		Menu menuF2 = new Menu("平台管理","base","",list2);
		
		list.add(menuF1);
		list.add(menuF2);
		return list;
	}
	
}

