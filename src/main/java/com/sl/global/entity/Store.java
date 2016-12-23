/** 
 * Project Name:slsys 
 * File Name:Store.java 
 * Package Name:com.sl.global.entity 
 * Date:2016年11月16日下午7:44:17 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.entity;  

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sl.global.service.BaseService;
import com.sl.global.util.GlobalUtil;
import com.sl.global.util.SpringContextUtil;
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
	//二级数据，如用户角色下拉数据集合
	public Map<String , List<BaseEntity>> subDataList;
	//二级数据，如用户列表内显示用户类型名称
	public Map<String, Map<Long, BaseEntity>> subDataMap;
	//显示数据字段列表（待用）
	public Map<String, String> showMap;
	//菜单数据
	public List<Menu> menuList;
	//功能路径(页面显示系统中功能路径的数据集合)
	public List<Menu> funcList;
	//对象详细信息
	private T dataDetail;
	
	private Class<T> entityClass;
	
	public Store(Class<T> persistentClass){
		entityClass = persistentClass;
	}
	/**
	 * 
	 * setFuncList:对当前页面所在系统的功能区域进行提醒. <br/> 
	 * 后续放在menu菜单功能的service逻辑层中.<br/> 
	 * 
	 * @author laven 
	 * @param actionName 
	 * @since JDK 1.6
	 */
	public void setFuncList(String actionName,List<Menu> menuList){
		
	}
	
	public void setSubDataList() {
		if(subDataList == null){
			subDataList = new HashMap<String, List<BaseEntity>>();
		}
		Field[] fields = entityClass.getDeclaredFields();
		for(Field field : fields){
			if(field.getType().getName().startsWith("com.sl")){
				String serviceName = GlobalUtil.getService(field.getName());
				if(serviceName != null){
					BaseService baseService = (BaseService)SpringContextUtil.getBean(serviceName);
					List<BaseEntity> list = baseService.list();
					subDataList.put(field.getName(), list);
				}
			}
		}
	}
	/**
	 * 
	 * setSubDataMap:初始化页面数据需要的二级数据的散列集合. <br/> 
	 * 页面数据只有id，且需要显示名称等其他数据是使用此集合获取.<br/> 
	 * 
	 * @author laven  
	 * @since JDK 1.6
	 */
	public void setSubDataMap() {
		if(subDataMap == null){
			subDataMap = new HashMap<String, Map<Long, BaseEntity>>();
		}
		Field[] fields = entityClass.getDeclaredFields();
		for(Field field : fields){
			if(field.getType().getName().startsWith("com.sl")){
				String serviceName = GlobalUtil.getService(field.getName());
				if(serviceName != null){
					BaseService baseService = (BaseService)SpringContextUtil.getBean(serviceName);
					List<BaseEntity> list = baseService.list();
					Map<Long, BaseEntity> map = new HashMap<Long, BaseEntity>();
					for(BaseEntity baseEntity : list){
						map.put(baseEntity.getId(), baseEntity);
					}
					subDataMap.put(field.getName(), map);
				}
			}
		}
	}
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
		setSubDataMap();
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
		setSubDataList();
		this.dataDetail = dataDetail;
	}
	
}
  