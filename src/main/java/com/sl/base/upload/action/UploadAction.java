/** 
 * Project Name:slsys 
 * File Name:UploadAction.java 
 * Package Name:com.sl.base.upload.action 
 * Date:2016年12月12日下午4:02:46 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.upload.action;  

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.sl.global.action.BaseAction;
import com.sl.global.entity.BaseEntity;
import com.sl.global.service.BaseService;

/** 
 * ClassName:UploadAction <br/> 
 * Function: 上传功能控制层. <br/> 
 * Date:     2016年12月12日 下午4:02:46 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
@SuppressWarnings("rawtypes")
public class UploadAction extends BaseAction<BaseEntity,BaseService>{

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = 1424721710471724936L;

	public UploadAction() throws ClassNotFoundException{
		super(BaseEntity.class, BaseService.class);
	}
	/**
	 * 上传文件接收类
	 */
	private File uploadFile;
	/**
	 * 上传文件的名称
	 */
	private String uploadFileFileName;
	
	/**
	 * 
	 * upload:上传文件方法. <br/> 
	 * 所有上传单个文件的需求都可使用这个方法.<br/> 
	 * 流程：保存文件，返回文件的路径.<br/> 
	 * 
	 * @author laven 
	 * @return 
	 * @since JDK 1.6
	 */
	public String upload(){
	     try{
		     if(uploadFile!=null){  
			     String newFileName = UUID.randomUUID().toString()+"." +FilenameUtils.getExtension(uploadFileFileName);// 获取文件的后缀名 aa.jpg --> jpg
			     String imagePath = "uploadFile/user/photo/" + newFileName;
			     String realImagePath = context.getRealPath(imagePath);
			     FileUtils.copyFile(uploadFile, new File(realImagePath));
			     response.setContentType("text/plain");  
			     response.setCharacterEncoding("utf-8");
		         response.getWriter().print(imagePath);//把相应的地址放到前台解析，通过#符号分割  
		     }else{  
		         response.getWriter().print("上传失败，请重新上传！");  
		     }  
	     }catch(Exception e){
	    	 e.printStackTrace();
	     }
	     return null;  
	}
	
    public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}
  