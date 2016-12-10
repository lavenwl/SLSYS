/** 
 * Project Name:slsys 
 * File Name:BaseAction.java 
 * Package Name:com.sl.global.action 
 * Date:2016年11月2日上午11:06:40 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.action;  

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sl.base.entity.hibernate.BaseUser;
import com.sl.global.entity.Store;
import com.sl.global.service.BaseService;
import com.sl.portal.entity.Menu;

/** 
 * ClassName:BaseAction <br/> 
 * Function: 基础类action. <br/> 
 * Reason:   记录action通用的基本属性 <br/> 
 * Date:     2016年11月2日 上午11:06:40 <br/> 
 * @author   laven 
 * @version   
 * @param <T>
 * @since    JDK 1.6 
 * @see       
 */
public class BaseAction<T> extends ActionSupport implements ServletResponseAware, ServletRequestAware, SessionAware, CookiesAware,ServletContextAware{
	
	/** 
	 * serialVersionUID:序列化ID. 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = 1L;
	public HttpServletResponse response;
	public HttpServletRequest request;
	public ServletContext context;
	@SuppressWarnings("rawtypes")
	public Map session;
	@SuppressWarnings("rawtypes")
	public Map cookies;
	public Store store;


	/**
	 * action默认执行方法. 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		return "success";
	}
	
	/**
	 * 
	 * list:获取对象集合. <br/> 
	 * 根据参数获取对象集合.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String list(){
		return "success";
	}
	/**
	 * 
	 * detail:查询对象的详细信息. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String detail(){
		return "success";
	}
	
	/**
	 * 
	 * add:添加对象. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String add(){
		return "success";
	}
	
	/**
	 * 
	 * edit:获取修改的对象，跳转至修改页面. <br/>  
	 * 
	 * @author laven 
	 * @return 需要跳转的页面
	 * @since JDK 1.6
	 */
	public String edit(){
		return "success";
	}
	
	/**
	 * 
	 * update:更新对象. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String update(){
		return "success";
	}
	
	/**
	 * 
	 * delete:删除选择的对象. <br/> 
	 * 
	 * @author laven 
	 * @return 返回跳转的页面
	 * @since JDK 1.6
	 */
	public String delete(){
		return "success";
	}
	/**
	 * 
	 * save:保存单个对象. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String save(){
		return "success";
	}
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		if(null == store){
			store = new Store();
			store.setMenuList(Menu.getTestData());
			
		}
		session.put("page", "userlist");
		session.put("storekey", store);
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	
	public Store<T> getStore() {
		return store;
	}

	public void setStore(Store<T> store) {
		this.store = store;
	}
}
  