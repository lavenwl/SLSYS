<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<%@include file="common/head.jsp" %>
	</head>
	
	<body>
	    <%@include file="common/navbar.jsp" %>
		<%@include file="common/sideMenu.jsp" %>
	    
 		<!--  PAPER WRAP -->
	    <div class="wrap-fluid">
	        <div class="container-fluid paper-wrap bevel tlbr" style="padding-top:0px;">
	            <!-- CONTENT 网页内容开始--> 
	            <div id="mainContent">
	            	<h1>这里是首页需要放置的内容</h1>
	            </div>
	            <!-- CONTENT 网页内容结束--> 
	            
	          	<%@include file="common/foot.jsp" %> 
	        </div>
	    </div>
	    <!--  END OF PAPER WRAP -->

	    <%@include file="common/rightSideMenu.jsp" %> 
		<%@include file="common/loadJs.jsp" %>
	
	</body>
</html>