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
			                                            <th>物资名称</th>
			                                            <th>物资类别</th>
			                                            <th>物资规格</th>
			                                            <th>物资品牌</th>
			                                            <th>供应商</th>
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
			                                                <td>
				                                                <s:set var="goodsTypeId" value="goodsType.id"></s:set>
				                                                <s:property value="store.subDataMap.get('goodsType').get(#goodsTypeId).name"/>
			                                                </td>
			                                                <td><s:property value="spec"/></td>
			                                                <td><s:property value="brand"/></td>
			                                                <td><s:property value="provider"/></td>
			                                                <td><s:property value="createDate"/></td>
			                                                <td data-value="1"><s:property value="updateDate"/></td>
			                                             <%--    <td data-value="1"><span class="status-metro status-active" title="Active"><s:property value="state"/></span></td>
			                                                  --%><td>
			                                                	 <div class="btn-group">
								                                    <button onclick="window.location.href='<s:property value="#session.actionName"/>!edit.action?id=<s:property value="id"/>'" type="button" class="btn btn-info">
							                                    		<span class="entypo-pencil"></span>&nbsp;&nbsp;修改
							                                    	</button> 
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
			                                            <td colspan="9">
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
	