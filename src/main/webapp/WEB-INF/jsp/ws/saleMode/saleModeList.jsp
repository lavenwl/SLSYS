<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

				<%@include file="../../common/funcTree.jsp" %> 
				
	            <!-- CONTENT 网页内容开始--> 
			    <div class="content-wrap">
			                <div class="row">
			                    <div class="col-sm-12">
			                        <div class="nest" id="FootableClose">
			                            <div class="title-alt">
			                                <h6>用户列表</h6>
			                                <div class="titleClose">
			                                    <a class="gone" href="#FootableClose">
			                                        <span class="entypo-cancel"></span>
			                                    </a>
			                                </div>
			                                <div class="titleToggle">
			                                    <a class="nav-toggle-alt" href="#Footable">
			                                        <span class="entypo-up-open"></span>
			                                    </a>
			                                </div>
											<button onclick="window.location.href='<s:property value="#session.actionName"/>!add.action'" type="button" class="btn btn-primary" style="margin: 8px 20px 0px 0px; float: right;">
			                                    <span class="entypo-plus-squared"></span>&nbsp;&nbsp;新增</button>
			                            </div>
			
			                            <div class="body-nest" id="Footable">
			
			                                <table class="table-striped footable-res footable metro-blue" data-page-size="6">
			                                    <thead>
			                                        <tr>
			                                            <th data-hide="phone,tablet">序列号</th>
			                                            <th>销售模式（单位）</th>
			                                            <th data-hide="phone,tablet">创建时间</th>
			                                            <th data-hide="phone,tablet">修改时间</th>
			                                        <!--     <th data-hide="phone">数据状态</th>  -->
			                                            <th>操作</th>
			                                        </tr>
			                                    </thead>
			                                    <tbody>
			                                    	<s:iterator value="store.dataList">
			                                            <tr>
			                                                <td><s:property value="id"/></td>
			                                                <td><s:property value="name"/></td>
			                                                <td><s:property value="createDate"/></td>
			                                                <td data-value="1"><s:property value="updateDate"/></td>
			                                             <%--    <td data-value="1"><span class="status-metro status-active" title="Active"><s:property value="state"/></span></td>
			                                                  --%><td>
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
			                                            <td colspan="7">
			                                                <div class="pagination pagination-centered"></div>
			                                            </td>
			                                        </tr>
			                                    </tfoot>
			                                </table>
			                            </div>
			                        </div>
			                    </div>
			                </div>
			            </div>
			          
			  
			    <!-- CONTENT 网页内容结束--> 
	            
	         
	    <script type="text/javascript">
		    $(function() {
		        $('.footable-res').footable();
		    });
	    </script>  


