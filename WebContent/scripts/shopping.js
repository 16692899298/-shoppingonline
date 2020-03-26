
function deleteCart(hp_id) {
	
	$.ajax({
		url : "deleteCart",// 请求的servlet地址
		type : "GET",// 请求方式
		data : {"hp_id":hp_id},// 发送到服务器的数据
		dataType : "text",// 设置返回数据类型
		success : function() {
			alert("已删除");
			window.location.href="shopping"
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {
			
		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}



function alterCount(cid) {
	
	var count=$("#"+cid).val();
//	window.location.href="alterQuantity?"+cid+"_"+$("#"+cid).val()
	$.ajax({
		url : "AlertQuantityServlet",// 请求的servlet地址
		type : "GET",// 请求方式
		//data : "pid="+cid+"_"+$("#"+cid).val(),// 发送到服务器的数据
		data :{"pid":cid,"count":count},
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			if(total==1){
				alert("成功")
			}
			//$("#cartCount").html(total);
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {

		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}


//-按钮事件
function reduce(id){
	var stock=$("#hpStock"+id).val()
	var old=$("#"+id).val()
	if($("#"+id).val()==1){
		$("#"+id).val(1)
	}else if($("#"+id).val()>=2&&parseInt(old)<parseInt(stock)){
		$("#"+id).val(parseInt(old)-1)
		alterCount(id)
	}else{
		alert("您选择的数量超过库存")
	}
}

//+按钮事件
function increase(id){
	
	var stock=$("#hpStock"+id).val()//获得库存
	var old=$("#"+id).val()//获得原来的数量
	//alert(stock)
	//alert(old)
	if(parseInt(old)<parseInt(stock)){
		$("#"+id).val(parseInt(old)+1)
		alterCount(id)
	}else{
		alert("您选择的数量超过库存!")
	}
}



function checkStock(id){
	alert(1111)
	var stock=$("#hpStock"+id).val()//获得库存
	var old=$("#"+id).val()//获得原来的数量
	if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}else if(parseInt(old)<=0||isNaN(parseInt(old)) || parseInt(old) % 1 != 0){
		alert("订单异常！")
	}
	else{
		alterCount(id)
	}
}




function buttonTest(id) {
	alert("测试id="+id)
}











