/** 
 * Project Name:slsys 
 * File Name:Store.java 
 * Package Name:com.sl.global.entity 
 * Date:2016年11月16日下午7:44:17 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.entity;  

import java.util.List;
import java.util.Map;

import com.sl.portal.entity.Menu;

/** 
 * ClassName:Store <br/> 
 * Function: 存储页面数据. <br/> 
 * Date:     2016年11月16日 下午7:44:17 <br/> 
 * @author   laven 
 * @version   
 * @param <T>
 * @since    JDK 1.6 
 * @see       
 */
public class Store<T> {
	//测试名称
	public String name;
	//显示数据集合
	public List<T> dataList;
	//显示数据字段列表（待用）
	public Map<String, String> showMap;
	//菜单数据
	public List<Menu> menuList;
	//对象详细信息
	private T dataDetail;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public Map<String, String> getShowMap() {
		return showMap;
	}
	public void setShowMap(Map<String, String> showMap) {
		this.showMap = showMap;
	}
	public T getDataDetail() {
		return dataDetail;
	}
	public void setDataDetail(T dataDetail) {
		this.dataDetail = dataDetail;
	}

	
	
}
  