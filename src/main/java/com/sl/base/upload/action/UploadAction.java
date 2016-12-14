/** 
 * Project Name:slsys 
 * File Name:UploadAction.java 
 * Package Name:com.sl.base.upload.action 
 * Date:2016年12月12日下午4:02:46 
 * Copyright (c) 2016, laven_wang@126.com All Rights Reserved. 
 * 
*/  
  
package com.sl.base.upload.action;  
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;




//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;








import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;


//import org.apache.commons.io.IOUtils;
import com.sl.base.upload.entity.UploadFile;
import com.sl.global.action.BaseAction;

/** 
 * ClassName:UploadAction <br/> 
 * Function: 上传功能控制层. <br/> 
 * Date:     2016年12月12日 下午4:02:46 <br/> 
 * @author   laven 
 * @version   
 * @since    JDK 1.6 
 * @see       
 */
public class UploadAction extends BaseAction<UploadFile>{

	/** 
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 * @since JDK 1.6 
	 */ 
	private static final long serialVersionUID = 1424721710471724936L;

	private File uploadFile;
	private String uploadFileFileName;
	public String execute(){
		return "success";
	}
	
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
  