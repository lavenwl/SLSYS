/** 
 * Project Name:slsys 
 * File Name:QueryBean.java 
 * Package Name:com.sl.global.entity 
 * Date:2016年12月8日下午3:12:05 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.entity;  
/** 
 * ClassName:QueryBean <br/> 
 * Function: TODO 所有查询bean的父类. <br/> 
 * Reason:   用于子类的继承，以实现方法的统一处理参数问题. <br/> 
 * Date:     2016年12月8日 下午3:12:05 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class QueryBean {
	private Long id;
	private Integer state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	

	
	
	
	
}
  