<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<tr>
    <td data-hide="phone,tablet" id="orderDetailCode"><s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/></td>
    <td>
    	<select name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].goods.id" id="goodsId<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control goodsId" onchange="calculate(this)" style="width:60px;">
	        <s:iterator value="store.subDataList.get('goods')">
	        	<s:if test="id == store.dataDetail.goods.id">
	        		<option value="<s:property value='id'/>" selected="selected"><s:property value='name'/>
	        	</s:if>
	        	<s:else>
	        		<option value="<s:property value='id'/>"><s:property value='name'/>
	        	</s:else>
	        </s:iterator>
        </select>
    </td>
    <td>
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].num" id="num<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control sum" value='<s:property value="store.dataDetail.num"/>' type="text" oninput="calculate(this)" >
    </td>
    <td>
    	<select name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].saleMode.id" id="saleModeId<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control saleModeId" onchange="calculate(this)" style="width:60px;">
	        <s:iterator value="store.subDataList.get('saleMode')">
	        	<s:if test="id == store.dataDetail.saleMode.id">
	        		<option value="<s:property value='id'/>" selected="selected"><s:property value='name'/>
	        	</s:if>
	        	<s:else>
	        		<option value="<s:property value='id'/>"><s:property value='name'/>
	        	</s:else>
	        </s:iterator>
        </select>
    </td>
    <td>
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].price" id="price<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.price"/>' type="text" >
    </td>
    <td>
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].sumMoney" id="sumMoney<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.sumMoney"/>' type="text"  >
    </td>
    <td>
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].money" id="money<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.money"/>' type="text" oninput="calculate(this)" >
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].createDate" id="createDate<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.createDate"/>' type="hidden">
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].updateDate" id="updateDate<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:date format="yyyy-MM-dd hh:mm:ss" name="store.dataDetail.updateDate"/>' type="hidden">
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].id" id="id<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.id"/>' type="hidden">
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].state" id="state<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.state"/>' type="hidden">
    	<input name="orderDetail[<s:property value='store.dataDetail.orderDetailCode.substring(10,14).replace("0","")'/>].order.id" id="orderId<s:property value="store.dataDetail.orderDetailCode.substring(10,14)"/>" class="form-control" value='<s:property value="store.dataDetail.order.id"/>' type="hidden">
    </td>
    <td>
	    <div class="btn-group">
	    	<button onclick="removeOrderDetail(this)" type="button" class="btn btn-danger">
           		<span class="entypo-cancel-squared"></span>&nbsp;&nbsp;删除
           	</button>
	    </div>
    </td>
</tr>
