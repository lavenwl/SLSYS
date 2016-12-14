<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!-- 
功能：单个文件上传功能
用法：1.页面引入此文件
	2.页面内需要拥有下列元素
<img id="uploadShow" src="">
<div id="uploadMessage">上传图片详情...</div>
<input id="uploadFacade" name="uploadFile" type="file" accept=".png,.jpg,.gif">
<input id="uploadUrl" name="" type="hidden"/>

 --> 
<!-- 关于上传的代码开始 -->
	<style type="text/css">
		#uploadShow {
		    width:150px;
		    height:150px;
		}
	</style>

	<div style="display:none" >
		<form id="uploadForm" action="upload!upload" method="post" enctype="multipart/form-data" target="hidden_frame"> 
	    	<input id="uploadAgent" type="file" name="uploadFile"/><br>
	    	<input id="uploadSubmit" type="submit" name="ti"/>
	    </form>
	</div>

	<script type="text/javascript" src="assets/js/upload/jquery-form.js"></script>
	<script type="text/javascript">
    
 		<!--绑定伪表单修改事件，更新到代理表单进行异步提交-->
		document.getElementById("uploadFacade").onchange=function(){ 
			var uploadFacade=document.getElementById("uploadFacade");
			var uploadAgent=document.getElementById("uploadAgent");
			var uploadForm = document.getElementById("uploadForm");
			var uploadSubmit = document.getElementById("uploadSubmit");
			uploadForm.replaceChild(uploadFacade, uploadAgent);
			///这里使用form表单内的提交按钮的点按事件，不能使用form的submit事件，如果使用了则不是返回字符串，会跳转新页面，原因待解决？
			uploadSubmit.click();
			//uploadForm.submit();
		};
		<!--初始化定义ajax异步提交函数-->
		$(document).ready(function() { 
		    var options = { 
		        //target:        '#uploadMessage',   // 用服务器返回的数据 更新 id为output1的内容.
		        beforeSubmit:  showRequest,  // 提交前
		        success:       showResponse,  // 提交后 
		        //另外的一些属性: 
		        //url:       url         // 默认是form的action，如果写的话，会覆盖from的action. 
		        //type:      type        // 默认是form的method，如果写的话，会覆盖from的method.('get' or 'post').
		        //dataType:  null        // 'xml', 'script', or 'json' (接受服务端返回的类型.) 
		        //clearForm: true        // 成功提交后，清除所有的表单元素的值.
		        resetForm: true        // 成功提交后，重置所有的表单元素的值.
		        //由于某种原因,提交陷入无限等待之中,timeout参数就是用来限制请求的时间,
		        //当请求大于3秒后，跳出请求. 
		        //timeout:   3000 
		    }; 
		 
		    //'ajaxForm' 方式的表单 .
		    //$('#myForm').ajaxForm(options);  
		    //或者 'ajaxSubmit' 方式的提交.
		    $('#uploadForm').submit(function() { 
		        $(this).ajaxSubmit(options); 
		        return false; //来阻止浏览器提交.
		    }); 
		}); 

		// 提交前
		function showRequest(formData, jqForm, options) { 
			// formdata是数组对象,在这里，我们使用$.param()方法把他转化为字符串.
		    var queryString = $.param(formData); //组装数据，插件会自动提交数据
		    //alert(queryString); //类似 ： name=1&add=2  
		    return true; 
		} 

		//提交后 
		function showResponse(responseText, statusText)  { 
			var url=responseText;
			document.getElementById("uploadUrl").value=url;
			document.getElementById("uploadShow").src=responseText;
		} 

	</script>
<!-- 关于上传的代码结束 -->