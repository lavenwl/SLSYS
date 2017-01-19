package com.sl.wholesale.entity.hibernate;

// Generated 2017-1-19 16:12:52 by Hibernate Tools 4.0.0

import com.sl.global.entity.BaseEntity;
import com.sl.portal.entity.hibernate.User;
import java.util.Date;

/**
 * 			@description entity generated by hbm2java.
 * 			@author LAVEN
 * 			@since JDK 1.7 
 * 	    
 */
public class UserInfo extends BaseEntity implements java.io.Serializable {

	private Long id;
	private User user;
	private Company company;
	private Date createDate = new Date();
	private Date updateDate = new Date();
	/**
	 * 数据状态(1:有效；0删除)
	 */
	private Integer state = 1;

	public UserInfo() {
	}

	public UserInfo(User user) {
		this.user = user;
	}

	public UserInfo(User user, Company company, Date createDate,
			Date updateDate, Integer state) {
		this.user = user;
		this.company = company;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.state = state;
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

	/**       
	 *      * 数据状态(1:有效；0删除)
	 */
	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * toString
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@")
				.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("state").append("='").append(getState()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserInfo))
			return false;
		UserInfo castOther = (UserInfo) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getState() == castOther.getState()) || (this
						.getState() != null && castOther.getState() != null && this
						.getState().equals(castOther.getState())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());

		result = 37 * result
				+ (getState() == null ? 0 : this.getState().hashCode());
		return result;
	}

}
