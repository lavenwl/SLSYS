package com.sl.wholesale.entity.hibernate;

// Generated 2016-12-23 23:53:14 by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.sl.global.entity.BaseEntity;
import com.sl.portal.entity.hibernate.User;

/**
 * UserInfo generated by hbm2java
 */
public class UserInfo extends BaseEntity implements java.io.Serializable {

	private Long id;
	private User user;
	private Company company;
	private long companyId;
	private Date createDate;
	private Date updateDate;
	private Integer state;
	private Set ordersForSale = new HashSet(0);
	private Set ordersForPurchase = new HashSet(0);

	public UserInfo() {
	}

	public UserInfo(User user, Company company, long companyId,
			Date createDate, Date updateDate) {
		this.user = user;
		this.company = company;
		this.companyId = companyId;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public UserInfo(User user, Company company, long companyId,
			Date createDate, Date updateDate, Integer state, Set ordersForSale,
			Set ordersForPurchase) {
		this.user = user;
		this.company = company;
		this.companyId = companyId;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
		this.ordersForSale = ordersForSale;
		this.ordersForPurchase = ordersForPurchase;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
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

	public Set getOrdersForSale() {
		return this.ordersForSale;
	}

	public void setOrdersForSale(Set ordersForSale) {
		this.ordersForSale = ordersForSale;
	}

	public Set getOrdersForPurchase() {
		return this.ordersForPurchase;
	}

	public void setOrdersForPurchase(Set ordersForPurchase) {
		this.ordersForPurchase = ordersForPurchase;
	}

}
