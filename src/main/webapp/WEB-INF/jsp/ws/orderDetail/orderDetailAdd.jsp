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
	                                    <h6>新增商户</h6>
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
	                                        <div class="col-md-3">
	                                            <div class="text-center">
	                                                <img id="uploadShow" src="http://placehold.it/150" class="avatar img-circle" alt="avatar">
	                                                <h6 id="uploadMessage">上传图片详情...</h6>
													<div class="input-group">
	                                                    <span class="input-group-btn">
	                                                        <span class="btn btn-primary btn-file">
	                                                            选择<input id="uploadFacade" name="uploadFile" type="file" accept=".png,.jpg,.gif">
	                                                            <input id="uploadUrl" name="orderDetail.url" type="hidden"/>
	                                                        </span>
	                                                    </span>
	                                                </div>
	                                            </div>
	                                        </div>
	
	                                        <!-- edit form column -->
	                                        <div class="col-md-9 personal-info">
	                                            <div class="alert alert-info alert-dismissable">
	                                                <a class="panel-close close" data-dismiss="alert">×</a> 
	                                                <i class="fa fa-coffee"></i>
	                                                This is an
	                                                <strong>.alert</strong>. 用户是否有重要的提醒（预留功能）.
	                                            </div>
	                                            <h3>详细信息</h3>
	
                                           
                                            	<input name="orderDetail.createDate" class="form-control" value='<s:property value="store.dataDetail.createDate"/>' type="hidden">
                                            	<input name="orderDetail.state" class="form-control" value='1' type="hidden">
                                            	<input name="orderDetail.updateDate" class="form-control" value='<s:property value="store.dataDetail.updateDate"/>' type="hidden">
                                                <div class="form-group">
                                                    <label class="col-lg-3 control-label">订单ID:</label>
                                                    <div class="col-lg-8">
                                                        <div class="ui-select">
                                                             <select name="orderDetail.order.id" id="user_time_zone" class="form-control">
	                                                            <s:iterator value="store.subDataList.get('order')">
	                                                            	<s:if test="id == store.dataDetail.order.id">
	                                                            		<option value="<s:property value='id'/>" selected="selected"><s:property value='id'/>
	                                                            	</s:if>
	                                                            	<s:else>
	                                                            		<option value="<s:property value='id'/>"><s:property value='id'/>
	                                                            	</s:else>
	                                                            </s:iterator>
	                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="col-lg-3 control-label">商品名称:</label>
                                                    <div class="col-lg-8">
                                                        <div class="ui-select">
                                                             <select name="orderDetail.goods.id" id="user_time_zone" class="form-control">
	                                                            <s:iterator value="store.subDataList.get('goods')">
	                                                            	<s:if test="id == store.dataDetail.goods.id">
	                                                            		<option value="<s:property value='id'/>" selected="selected"><s:property value='name'/>
	                                                            	</s:if>
	                                                            	<s:else>
	                                                            		<option value="<s:property value='id'/>"><s:property value='name'/>
	                                                            	</s:else>
	                                                            </s:iterator>
	                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="col-lg-3 control-label">数量:</label>
                                                    <div class="col-lg-8">
                                                        <input name="orderDetail.num" class="form-control" value='<s:property value="store.dataDetail.num"/>' type="text">
                                                    </div>
                                                </div>
                                                
                                                
                                                <div class="form-group">
                                                    <label class="col-lg-3 control-label">销售模式（单位）:</label>
                                                    <div class="col-lg-8">
                                                        <div class="ui-select">
                                                             <select name="orderDetail.saleMode.id" id="user_time_zone" class="form-control">
	                                                            <s:iterator value="store.subDataList.get('saleMode')">
	                                                            	<s:if test="id == store.dataDetail.saleMode.id">
	                                                            		<option value="<s:property value='id'/>" selected="selected"><s:property value='name'/>
	                                                            	</s:if>
	                                                            	<s:else>
	                                                            		<option value="<s:property value='id'/>"><s:property value='name'/>
	                                                            	</s:else>
	                                                            </s:iterator>
	                                                            </select>
                                                        </div>
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
