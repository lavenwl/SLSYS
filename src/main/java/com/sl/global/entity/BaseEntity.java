/** 
 * Project Name:slsys 
 * File Name:BaseEntity.java 
 * Package Name:com.sl.global.entity 
 * Date:2016年12月15日下午11:26:33 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.global.entity;  

import java.util.Date;

/** 
 * ClassName:BaseEntity <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2016年12月15日 下午11:26:33 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class BaseEntity {

	private Long id;
	private Date createDate;
	private Date updateDate;
	private Integer state;

	public BaseEntity() {
	}

	public BaseEntity(long id, Date createDate, Date updateDate,
			Integer state) {
		this.id = id;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	

}
  