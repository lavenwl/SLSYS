<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="../../common/head.jsp" %>
		 <link rel="stylesheet" href="assets/css/profile.css">
	</head>
	
	<body>
	    <%@include file="../../common/navbar.jsp" %>
		<%@include file="../../common/sideMenu.jsp" %>
	    
 		<!--  PAPER WRAP -->
	    <div class="wrap-fluid">
	        <div class="container-fluid paper-wrap bevel tlbr" style="padding-top:0px;">
				<%@include file="../../common/funcTree.jsp" %> 
				
	            <!-- CONTENT 网页内容开始--> 
			    <div class="content-wrap">
	                <!-- PROFILE -->
	                    <div class="row">
	                        <div class="col-sm-12">
	                            <!-- BLANK PAGE-->
	                            <div style="margin:-20px 15px;" class="nest" id="Blank_PageClose">
	                                <div class="title-alt">
	                                    <h6>新增角色</h6>
	                                    <div class="titleClose">
	                                        <a class="gone" href="#Blank_PageClose">
	                                            <span class="entypo-cancel"></span>
	                                        </a>
	                                    </div>
	                                    <div class="titleToggle">
	                                        <a class="nav-toggle-alt" href="#Blank_Page_Content">
	                                            <span class="entypo-up-open"></span>
	                                        </a>
	                                    </div>
	                                </div>
	
	                                <div class="body-nest" id="Blank_Page_Content">
	
	                                    <div class="row">
	                                        <!-- left column -->
	                                         <form  role="form" action="<s:property value='#session.actionName'/>!save.action" method="post">
	                                     
	                                        <!-- edit form column -->
	                                        <div class="col-md-9 personal-info">
	                                            <h3>详细信息</h3>
                                            	<%-- <input name="role.createDate" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.createDate"/>' type="hidden">
                                            	<input name="role.state" class="form-control" value='1' type="hidden">
                                            	<input name="role.updateDate" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.updateDate"/>' type="hidden">
                                                 --%><div class="form-group">
                                                    <label class="col-md-3 control-label">角色名称:</label>
                                                    <div class="col-md-8">
                                                        <input name="role.name" class="form-control" value='<s:property value="store.dataDetail.name"/>' type="text">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-md-3 control-label"></label>
                                                    <div class="col-md-8">
                                                        <input class="btn btn-primary" value="保存修改" type="submit">
                                                        <span></span>
                                                        <input class="btn btn-default" value="取消修改" type="reset">
                                                    </div>
                                                </div>
	                                        </div>
	                                        </form>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- END OF BLANK PAGE -->
	
	                    </div>
	                    
	                   
	              
	              
	                <!-- END OF PROFILE -->
		        </div>
			    <!-- CONTENT 网页内容结束--> 
	            <%@include file="../../common/upload.jsp" %>
	          	<%@include file="../../common/foot.jsp" %> 
	        </div>
	    </div>
	    <!--  END OF PAPER WRAP -->

	    <%@include file="../../common/rightSideMenu.jsp" %> 
		<%@include file="../../common/loadJs.jsp" %>
	</body>
</html>
<s:debug/> <s:fielderror />
