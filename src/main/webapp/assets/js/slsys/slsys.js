//菜单请求
function menuRequest(url){
	$.post(url,
		function(data,status){
			if(status=="success"){
				$("#mainContent").append(data); 
			}else{
				alert("返回错误");
			}
		});
}

//订单制作是添加一行明细
function addOrderDetail(event){
	var $tbody = $(event).parents('table').children('tbody');
	var orderId = $('#orderId').val();
	var data = new Object();
	data.orderId = orderId;
	$.post("orderDetail!addTr.action",
			data,
		function(data,status){
			if(status=="success"){
				$tbody.append(data); 
			}else{
				alert("返回错误");
			}
		});
}
//订单制作删除一行明细
function removeOrderDetail(event){
	$(event).parents('tr').remove();
}
//订单制作时明细字段完成计算功能
function calculate(event){
	// if(event.name.indexOf("goods")>=0){
	// 	alert("商品名修改");
	// }else if (event.name.indexOf("sale")>=0){
	// 	alert("修改销售模式")
	// }else if (event.name.indexOf("num")>=0){
	// 	alert("修改数量计算");
	// }
	if(event.name.indexOf(".money")>=0){
		var allSumMoney=0;
		var allSaleMoney=0;
		//合计金额
		$(event).parents('tbody').children('tr').each(function(){
			var orderDetailCode = $(this).children('#orderDetailCode').text();
			var sumMoney = Number($("#sumMoney" + orderDetailCode).val());
			var money = Number($("#money" + orderDetailCode).val());
			allSumMoney += sumMoney;
			allSaleMoney += money;
		});
		$("#orderSumMoney").val(allSumMoney);
		$("#orderMoney").val(allSaleMoney);
	}else{
		var orderDetailCode = $(event).parents('tr').children('#orderDetailCode').text();
		var goodsId = $('#goodsId'+orderDetailCode).val();
		var saleModeId = $('#saleModeId'+orderDetailCode).val();
		var data = new Object();
		data.goodsId=goodsId;
		data.saleModeId=saleModeId;
		$.post("order!getPrice.action",
			data,
			function(data,status){
				if(status=="success"){
					if(data < 0){
						alert("通知店长维护价格");
					}else{
						var price = Number(data);
						var num = Number($('#num'+orderDetailCode).val());
						$("#price" + orderDetailCode).val(price);
						$("#sumMoney" + orderDetailCode).val(price*num);
						$("#money" + orderDetailCode).val(price*num);

						var allSumMoney=0;
						var allSaleMoney=0;
						//合计金额
						$(event).parents('tbody').children('tr').each(function(){
							var orderDetailCode = $(this).children('#orderDetailCode').text();
							var sumMoney = Number($("#sumMoney" + orderDetailCode).val());
							var money = Number($("#money" + orderDetailCode).val());
							allSumMoney += sumMoney;
							allSaleMoney += money;
						});
						$("#orderSumMoney").val(allSumMoney);
						$("#orderMoney").val(allSaleMoney);
					}
				}else{
					alert("返回错误");
				}
			});
	}
	
}
function submitOrderForm(){


	var trNum = $('tbody tr').length;

	var dataArray = decodeURIComponent($("#orderForm").serialize());
	while(dataArray.indexOf("+")!=-1){
		dataArray=dataArray.replace("+"," ");
	}
	var arr = dataArray.split('&');


	var item,key,value,newData={};
	var order = new Object();
	var orderDetailArray = new Array();
	for(var i=0;i<arr.length;i++){
		item = arr[i].split('=');
		key = item[0];
		value = item[1];

		
		if(key.indexOf("orderDetail")!=-1){
			var prop = key.substring(key.indexOf("].")+2, key.length);
			var index = Number(key.substring(key.indexOf("[")+1,key.indexOf("]"))-1);
			if(orderDetailArray[index]==undefined){
				orderDetailArray[index] = new Object();
				if(prop.indexOf(".") != -1){
					var object = new Object();
					var objectprop = prop.substring(prop.indexOf(".")+1, prop.length);
					var newprop = prop.substring(0, prop.indexOf("."));
					object[objectprop]=value;
					orderDetailArray[index][newprop] = object;
				}else{
					orderDetailArray[index][prop] = value;
				}
			}else{
				if(prop.indexOf(".") != -1){
					var object = new Object();
					var objectprop = prop.substring(prop.indexOf(".")+1, prop.length);
					var newprop = prop.substring(0, prop.indexOf("."));
					object[objectprop]=value;
					orderDetailArray[index][newprop] = object;
				}else{
					orderDetailArray[index][prop] = value;
				}
				
			}
		}else{
			var prop = key.substring(key.indexOf(".")+1, key.length);
			if(prop.indexOf(".") != -1){
				var object = new Object();
				var objectprop = prop.substring(prop.indexOf(".")+1, prop.length);
				var newprop = prop.substring(0, prop.indexOf("."));
				object[objectprop]=value;
				order[newprop]=object;
			}else{
				order[prop] = value;
			}
		}
	}
	var content = {};
	content.orderStr = order;
	content.orderDetailStr=orderDetailArray;
	var data = new Object();
	data.contentStr = JSON.stringify(content);
	$.post("order!update.action",
			data,
			function(data,status){
				if(status=="success"){
					alert("success: data:" + data);
				}else{
					alert("返回错误");
				}
			});

	return false;
}


























