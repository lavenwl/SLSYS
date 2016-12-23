/** 
 * Project Name:slsys 
 * File Name:BaseAction.java 
 * Package Name:com.sl.global.action 
 * Date:2016年11月2日上午11:06:40 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.action;  

import java.util.Date;
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
import com.sl.global.entity.BaseEntity;
import com.sl.global.entity.Store;
import com.sl.global.service.BaseService;
import com.sl.global.util.SpringContextUtil;
import com.sl.global.util.StringUtil;
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
@SuppressWarnings("rawtypes")
public class BaseAction<E extends BaseEntity,S extends BaseService> extends ActionSupport implements ServletResponseAware, ServletRequestAware, SessionAware, CookiesAware,ServletContextAware{
	
	/** 
	 * serialVersionUID:序列化ID. 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = 1L;
	public HttpServletResponse response;
	public HttpServletRequest request;
	public ServletContext context;
	public Map session;
	public Map cookies;
	public Store store;
	public Class<E> baseEntityClass;
	public Class<S> baseServiceClass;
	public S baseService;
	
	public BaseAction(Class<E> baseEntityClass,Class<S> baseServiceClass) throws ClassNotFoundException{
			this.baseEntityClass = baseEntityClass;
			this.baseServiceClass = baseServiceClass;
	}

	/**
	 * action默认执行方法. 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		return list();
	}
	
	/**
	 * 
	 * list:获取对象集合. <br/> 
	 * 获取数据库对应表的所有有效（state=1）对象的集合.<br/> 
	 * 默认都要过滤state字段为有效时才为有效数据获取集合。
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String list(){
		List<E> entityList = getBaseService().list();
		store.setDataList(entityList);
		return "list";
	}
	/**
	 * 
	 * detail:查询对象的详细信息. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String detail(){
		long id = Long.valueOf(request.getParameter("id"));
		//TODO 测试这里是否可以去掉这个强转操作
		E entity = (E) getBaseService().queryById(id);
		store.setDataDetail(entity);
		return "detail";
	}
	
	/**
	 * 
	 * add:添加对象. <br/> 
	 * 跳转到添加的页面，初始化对象的默认参数<br/>
	 * @author laven 
	 * @return 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String add() throws InstantiationException, IllegalAccessException{
		E baseEntity = baseEntityClass.newInstance();
		baseEntity.setCreateDate(new Date());
		baseEntity.setUpdateDate(new Date());
		store.setDataDetail(baseEntity);
		return "add";
	}
	
	/**
	 * 
	 * edit:获取修改的对象，跳转至修改页面. <br/>  
	 * 
	 * @author laven 
	 * @return 需要跳转的页面
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String edit(){
		long id = Long.valueOf(request.getParameter("id"));
		E entity = (E) getBaseService().queryById(id);
		store.setDataDetail(entity);
		return "edit";
	}
	
	/**
	 * 
	 * update:更新对象. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String update(E baseEntity){
		if(null != baseEntity){
			getBaseService().update(baseEntity);
		}
		return "update";
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
		long id = Long.valueOf(request.getParameter("id"));
		getBaseService().deleteById(id);
		return "delete";
	}
	/**
	 * 
	 * save:保存单个对象. <br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	@SuppressWarnings("unchecked")
	public String save(E baseEntity){
		if(null != baseEntity){
			getBaseService().save(baseEntity);
		}
		return "save";
	}
	
	
	@Override
	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		if(null == store){
			store = new Store(baseEntityClass);
			store.setMenuList(Menu.getTestData());
		}
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
	
	@SuppressWarnings("unchecked")
	public Store<E> getStore() {
		return store;
	}

	public void setStore(Store<E> store) {
		this.store = store;
	}

	@SuppressWarnings("unchecked")
	public S getBaseService(){
		if(baseService == null){
			baseService = (S) SpringContextUtil.getBean(StringUtil.lowerFirstChar(baseServiceClass.getSimpleName()));
		}
		return baseService;
	}
	public void setBaseService(Class<S> baseServiceClass) throws InstantiationException, IllegalAccessException {
		this.baseService = baseServiceClass.newInstance();
	}
	
}
  