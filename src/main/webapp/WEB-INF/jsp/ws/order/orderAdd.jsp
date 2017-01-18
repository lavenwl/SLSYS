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
	                                    <h6>新增订单(<s:property value="store.dataDetail.orderCode"/>)</h6>
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
	                                         <form  role="form" action="<s:property value='#session.actionName'/>!update.action" method="post" id="orderForm" onsubmit="return false;">
	                                        
	
	                                        <!-- edit form column -->
	                                        <div class="col-md-12 personal-info">
	                                            
	                                            <h3>订单信息</h3>
                                            	<input name="order.createDate" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.createDate"/>' type="hidden">
                                            	<input name="order.orderCode" class="form-control" value='<s:property value="store.dataDetail.orderCode"/>' type="hidden">
                                            	<input name="order.id" id="orderId" class="form-control" value='<s:property value="store.dataDetail.id"/>' type="hidden">
                                            	<input name="order.state" class="form-control" value='<s:property value="store.dataDetail.state"/>' type="hidden">
                                            	<input name="order.updateDate" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.updateDate"/>' type="hidden">
                                                <div class="form-group col-xs-12 col-sm-6">
                                                    <label class="col-md-5 control-label">采购用户:</label>
                                                    <div class="col-md-7">
                                                        <div class="ui-select">
                                                            <select name="order.userInfoByPurchase.id" id="user_time_zone" class="form-control">
                                                            <s:iterator value="store.subDataList.get('userInfoByPurchase')">
                                                            	<s:if test="id == store.dataDetail.userInfoByPurchase.id">
                                                            		<option value="<s:property value='id'/>" selected="selected"><s:property value='user.username'/>
                                                            	</s:if>
                                                            	<s:else>
                                                            		<option value="<s:property value='id'/>"><s:property value='user.username'/>
                                                            	</s:else>
                                                            </s:iterator>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group  col-xs-12 col-sm-6">
                                                    <label class="col-md-5 control-label">销售用户:</label>
                                                    <div class="col-md-7">
                                                        <div class="ui-select">
                                                             <select name="order.userInfoBySale.id" id="user_time_zone" class="form-control">
	                                                            <s:iterator value="store.subDataList.get('userInfoBySale')">
	                                                            	<s:if test="id == store.dataDetail.userInfoBySale.id">
	                                                            		<option value="<s:property value='id'/>" selected="selected"><s:property value='user.username'/>
	                                                            	</s:if>
	                                                            	<s:else>
	                                                            		<option value="<s:property value='id'/>"><s:property value='user.username'/>
	                                                            	</s:else>
	                                                            </s:iterator>
	                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group col-xs-12 col-sm-12">
                                                <table id="orderAddItemTable" class="table-striped footable-res footable metro-blue" data-page-size="6">
			                                    <thead>
			                                        <tr>
			                                            <th data-hide="phone,tablet">序列号</th>
			                                            <th>商品名称</th>
			                                            <th>数量</th>
			                                            <th>销售单位</th>
			                                            <th>组合单价</th>
			                                            <th>计算金额</th>
			                                            <th>销售金额</th>
			                                            <th>操作</th>
			                                        </tr>
			                                    </thead>
			                                    <tbody>
			                                    	<s:iterator value="store.subDataList.get('items')">
			                                            <tr>
			                                                <td><s:property value="id"/></td>
			                                                <td>
																<s:set var="goodsId" value="goods.id"></s:set>
				                                                <s:property value="store.subDataMap.get('goods').get(#goodsId).name"/>
			                                                </td>
			                                                <td><s:property value="num"/></td>
			                                                <td>
																<s:set var="saleModeId" value="saleMode.id"></s:set>
				                                                <s:property value="store.subDataMap.get('saleMode').get(#saleModeId).name"/>
			                                                </td>
			                                                <td><s:property value="price"/></td>
			                                                <td><s:property value="sumMoney"/></td>
			                                                <td><s:property value="money"/></td>
			                                                <td>
			                                                	 <div class="btn-group">
								                                    <button onclick="window.location.href='<s:property value="#session.actionName"/>!edit.action?id=<s:property value="id"/>'" type="button" class="btn btn-info">
							                                    		<span class="entypo-pencil"></span>&nbsp;&nbsp;修改
							                                    	</button> 
								                                    <div class="btn-group">
									                                    <button data-toggle="dropdown" class="btn btn-warning dropdown-toggle" type="button">更多
									                                        <span class="caret"></span>
									                                    </button>
									                                    <ul role="menu" class="dropdown-menu">
									                                        <li><a href="<s:property value='#session.actionName'/>!detail.action?id=<s:property value='id'/>">详情</a>
									                                        </li>
									                                        <li><a href="#">标记</a>
									                                        </li>
									                                        <li><a href="#">其他</a>
									                                        </li>
									                                        <li class="divider"></li>
									                                        <li><a href="#">Separated link</a>
									                                        </li>
									                                    </ul>
								                                    </div>
								                                    <button onclick="window.location.href='<s:property value="#session.actionName"/>!delete.action?id=<s:property value="id"/>'" type="button" class="btn btn-danger">
							                                    	<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;删除
							                                    	</button>
								                                </div>
							                                </td>
			                                            </tr>
			                                        </s:iterator>
			                                        
			                                                    
			                                    </tbody>
			                                    <tfoot>
			                                        <tr>
			                                            <td colspan="8">
			                                                <div class="pagination pagination-centered">
				                                                <div class="btn-group">
								                                    <button onclick="addOrderDetail(this)" type="button" class="btn btn-primary" style="margin: 8px 20px 0px 0px; float: right;">
				                                    				<span class="entypo-plus-squared"></span>&nbsp;&nbsp;新增</button>
								                                </div>
			                                                </div>
			                                            </td>
			                                        </tr>
			                                    </tfoot>
			                                </table>
                                            </div>  
                                             
                                            <div class="form-group  col-xs-12 col-sm-6">
                                                 <label class="col-md-5 control-label">合计金额:</label>
                                                 <div class="col-md-7">
                                                     <input name="order.sumMoney"  id="orderSumMoney" class="form-control" value='<s:property value="store.dataDetail.sumMoney"/>' type="text">
                                                 </div>
                                             </div>
                                             <div class="form-group  col-xs-12 col-sm-6">
                                                 <label class="col-md-5 control-label">交易金额:</label>
                                                 <div class="col-md-7">
                                                     <input name="order.money" id="orderMoney" class="form-control" value='<s:property value="store.dataDetail.money"/>' type="text">
                                                 </div>
                                             </div>

                                             <div class="form-group">
                                                 <label class="col-md-5 control-label"></label>
                                                 <div class="col-md-7">
                                                     <input class="btn btn-primary" value="保存" type="submit" onclick="submitOrderForm()">
                                                     <span></span>
                                                     <input class="btn btn-default" value="取消" type="reset">
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
	            <%-- <%@include file="../../common/upload.jsp" %> --%>
	           	<%@include file="../../common/foot.jsp" %> 
	        </div>
	    </div>
	    <!--  END OF PAPER WRAP -->

	    <%@include file="../../common/rightSideMenu.jsp" %> 
		<%@include file="../../common/loadJs.jsp" %> 
	</body>
</html>