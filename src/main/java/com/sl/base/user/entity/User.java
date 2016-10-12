/** 
 * Project Name:slsys 
 * File Name:User.java 
 * Package Name:com.sl.base.user.entity 
 * Date:2016年10月9日下午3:33:50 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.user.entity;  
/** 
 * ClassName:User <br/> 
 * Function: 用户实体类 <br/> 
 * Reason:   用户实体类 <br/> 
 * Date:     2016年10月9日 下午3:33:50 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class User {
	private int id;
	private String nickname;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
  