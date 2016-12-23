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
	                        <div class="well profile">
	                            <div class="col-sm-12">
	                                <div class="col-xs-12 col-sm-4 text-center">
	
	                                    <ul class="list-group">
	                                        <li class="list-group-item text-left">
	                                            <span class="entypo-user"></span>&nbsp;&nbsp;详细页面</li>
	                                        <li class="list-group-item text-center">
	                                            <img src="http://api.randomuser.me/portraits/men/10.jpg" alt="" class="img-circle img-responsive img-profile">
	
	                                        </li>
	                                        <li class="list-group-item text-center">
	                                            <span class="pull-left">
	                                                <strong>预留功能</strong>
	                                            </span>
	
	
	                                            <div class="ratings">
	
	                                                <a href="#">
	                                                    <span class="fa fa-star"></span>
	                                                </a>
	                                                <a href="#">
	                                                    <span class="fa fa-star"></span>
	                                                </a>
	                                                <a href="#">
	                                                    <span class="fa fa-star"></span>
	                                                </a>
	                                                <a href="#">
	                                                    <span class="fa fa-star"></span>
	                                                </a>
	                                                <a href="#">
	                                                    <span class="fa fa-star-o"></span>
	                                                </a>
	
	                                            </div>
	
	
	                                        </li>
	
	                                        <li class="list-group-item text-right">
	                                            <span class="pull-left">
	                                                <strong>开户时间</strong>
	                                            </span><s:property value="store.dataDetail.createDate"/></li>
	                                        <li class="list-group-item text-right">
	                                            <span class="pull-left">
	                                                <strong>更新时间</strong>
	                                            </span><s:property value="store.dataDetail.updateDate"/></li>
	                                        <li class="list-group-item text-right">
	                                            <span class="pull-left">
	                                                <strong>昵称</strong>
	                                            </span><s:property value="store.dataDetail.phone"/></li>
	
	                                    </ul>
	
	                                </div>
	                                <div class="col-xs-12 col-sm-8 profile-name">
	                                    <h2><s:property value="store.dataDetail.phone"/>
	                                        <span class="pull-right social-profile">
	                                            <i class="entypo-facebook-circled"></i>  <i class="entypo-twitter-circled"></i>  <i class="entypo-linkedin-circled"></i>  <i class="entypo-github-circled"></i>  <i class="entypo-gplus-circled"></i>
	                                        </span>
	                                    </h2>
	                                    <hr>
	
	                                    <dl class="dl-horizontal-profile">
	                                        <dt>用户ID</dt>
	                                        <dd><s:property value="store.dataDetail.id"/></dd>
	
	                                        <dt>用户名</dt>
	                                        <dd><s:property value="store.dataDetail.phone"/></dd>
	
	                                        <dt>电子邮箱</dt>
	                                        <dd><s:property value="store.dataDetail.phone"/></dd>
	
	                                        <dt>电话</dt>
	                                        <dd><s:property value="store.dataDetail.phone"/></dd>
	
	                                        <dt>更新时间</dt>
	                                        <dd><s:property value="store.dataDetail.updateDate"/></dd>
	
	                                        <dt>增加时间</dt>
	                                        <dd><s:property value="store.dataDetail.createDate"/></dd>
	
	                                        <dt>备注</dt>
	                                        <dd><s:property value="store.dataDetail.state"/></dd>
	
	                                        <dt>外号及称呼</dt>
	                                        <dd>
	                                            <span class="tags">老鼠干</span>
	                                            <span class="tags">F区-1086</span>
	                                            <span class="tags">阿海</span>
	                                            <span class="tags">小姑娘</span>
	                                        </dd>
	
	                                    </dl>
	
	
	                                    <hr>
	
	                                    <h5>
	                                        <span class="entypo-arrows-ccw"></span>&nbsp;&nbsp;最近活动记录</h5>
	
	                                    <div class="table-responsive">
	                                        <table class="table table-hover table-striped table-condensed">
	
	                                            <tbody>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 今天, 1:00 - 配货F区-1086 第3张单子.</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 今天, 12:23 - 买饭20元.</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 今天, 12:20 - 清点进货物品 100斤白糖50包.</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 昨天 - 配货E区-1065 第2张单子 花生10斤.</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 2 天前 - 做单B区-1088 12:35:33.</td>
	                                                </tr>
	                                                <tr>
	                                                    <td><i class="pull-right fa fa-edit"></i> 2 天前 - 送货阿杰.</td>
	                                                </tr>
	                                            </tbody>
	                                        </table>
	                                    </div>
	
	                                </div>
	
	                            </div>
	                            <div class="col-xs-12 divider text-center">
	                                <div class="col-xs-12 col-sm-4 emphasis">
	                                    <h2>
	                                        <strong>205</strong>
	                                    </h2>
	                                    <p>
	                                        <small>累计单子</small>
	                                    </p>
	                                    <button class="btn btn-success btn-block">
	                                        <span class="fa fa-plus-circle"></span>&nbsp;&nbsp;保留功能</button>
	                                </div>
	                                <div class="col-xs-12 col-sm-4 emphasis">
	                                    <h2>
	                                        <strong>98</strong>
	                                    </h2>
	                                    <p>
	                                        <small>当年单子</small>
	                                    </p>
	                                    <button class="btn btn-info btn-block">
	                                        <span class="fa fa-user"></span>&nbsp;&nbsp;保留功能</button>
	                                </div>
	                                <div class="col-sm-4 emphasis">
	                                    <h2>
	                                        <strong>3</strong>
	                                    </h2>
	                                    <p>
	                                        <small>当天单子</small>
	                                    </p>
	                                    <button class="btn btn-default btn-block">
	                                        <span class="fa fa-user"></span>&nbsp;&nbsp;保留功能</button>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	  				</div>
	                <!-- END OF PROFILE -->
		        </div>
			    <!-- CONTENT 网页内容结束--> 
	            
	          	<%@include file="../../common/foot.jsp" %> 
	        </div>
	    </div>
	    <!--  END OF PAPER WRAP -->

	    <%@include file="../../common/rightSideMenu.jsp" %> 
		<%@include file="../../common/loadJs.jsp" %>
	</body>
</html>
<s:debug/><s:property value="pagein"/>
