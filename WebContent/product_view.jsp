<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊 - 产品显示</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<%-- <script type="text/javascript" src="scripts/product_view.js"></script> --%>
<script type="text/javascript">

function addToCart(pid) {
	
	var stock=$("#stock").html()
	var count=$("#count").val()
	//alert(stock)
	if(parseInt(count)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}else if(parseInt(count)<=0||isNaN(parseInt(count)) || parseInt(count) % 1 != 0){
		alert("订单异常！")
	}else{
		$.ajax({
			url : "addTocart",// 请求的servlet地址
			type : "GET",// 请求方式
			data : {"pid":pid,"count":count},// 发送到服务器的数据<%--data : "userName=" + userName.value,    --%>
			dataType : "text",// 设置返回数据类型
			success : function(a) {
				
				if(a==0){
					alert("您选择的数量超过库存!")
				}else{
				alert("成功添加到购物车")
				}
			},// 响应成功后执行的回调方法data响应文本
			complete : function(XMLHttpRequest, statusText) {
				
			},// 响应完成后执行的回调方法
			//error : function(XMLHttpRequest, statusText) {
				//alert("添加到购物车失败!")
			//}// 响应失败后执行的回调方法
		})
	}

}





function goingToBuy(pid) {
	var stock=$("#stock").val()
	var count=$("#count").val()
	
	if(parseInt(count)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}else if(parseInt(count)<=0||isNaN(parseInt(count)) || parseInt(count) % 1 != 0){
		alert("订单异常！")
	}
	else{
		
	window.location.href="goingToBuy?pid="+pid+"&count="+$("#count").val();
	}
	
}

//-按钮事件
function minus(){

	if($("#count").val()==1){
		$("#count").val(1)
	}else if($("#count").val()>=2){
		var old=$("#count").val()
		$("#count").val(parseInt(old)-1)
	}
}

//+按钮事件
function add(){
	var stock=$("#stock").html()
	var old=$("#count").val()
	if(parseInt(old)<parseInt(stock)){
		$("#count").val(parseInt(old)+1)
	}else{
		alert("您选择的数量超过库存!")
	}
	
}



function checkStock(){
	
	var stock=$("#stock").html()
	var old=$("#count").val()
	
	if(parseInt(old)>parseInt(stock)){
		alert("您选择的数量超过库存!")
	}else if(parseInt(old)<=0||isNaN(parseInt(old)) || parseInt(old) % 1 != 0){
		alert("订单异常！")
	}
}

/* function isInteger(num) {
    if (!isNaN(num) && num % 1 == 0) {
      return true;
    } else {
      return false;
    }

  } */


function remaind() {
	alert("请先登录亚马逊！")
	window.location.href="login.jsp"
}



</script>

</head>
<body>
	<%@ include file="index_top.jsp"%>
	<div id="position" class="wrap">
		<c:set value="${requestScope.categoryForProduct}" var="s"></c:set>
您现在的位置 <a href="wwww">亚马逊</a>  
		 <a href="category?cate=parent&hpc_id=${s[0] }">${s[1] }</a> 
		 <a href="category?cate=child&hpc_id=${s[2] }">${s[3] }</a>
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<%@ include file="index_product_sort.jsp"%>
		</div>
		<div id="product" class="main">
			<c:set var="p" value="${requestScope.productInfo }"></c:set>
			<h1>商品名称:${p.hp_name }</h1>
			<div class="infos">
				<div class="thumb">
					<img style="width: 100px; height: 100px;" src="${p.hp_file_name }" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${p.price }</span>
					</p>
					<c:choose>
						<c:when test="${p.hp_stock>0 }">
							<p>
								库 存：<span id="stock">${p.hp_stock }</span>(有货)
							</p>
						</c:when>
						<c:otherwise>
							<p>库 存：<input id="stock" type="hidden" value="${p.hp_stock }">无货
						</c:otherwise>
					</c:choose>
					<input type="button" id="minus" value=" - " width="3px"
						onclick="minus();"> 
					<input type="text" id="count"
						name="count" onblur="checkStock()" value="1" maxlength="5"
						size="1" style="text-align: center; vertical-align: middle">
					<input type="button" id="add" value=" + " width="2px"
						onclick="add();">
					<c:choose>
						<c:when test="${sessionScope.user==null }">
							<div class="button">
								<input type="button" name="button" value="" onclick="remaind();"
									style="background: url(images/buyNow.png)" /> 
								<input type="image"
									name="imageField" src="images/cartbutton.png" onclick="remaind()" />
							</div>

						</c:when>
						<c:otherwise>
							<div class="button">
								<input type="button" name="button" value=""
									onclick="goingToBuy(${p.hp_id });"
									style="background: url(images/buyNow.png)" /> 
								<input type="image"
									name="imageField" src="images/cartbutton.png"
									onclick="addToCart(${p.hp_id });" />
							</div>
						</c:otherwise>
					</c:choose>

				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					商品名字：${p.hp_name }<br /> 商品描述：${p.hp_description }<br />
					商品价格：￥${p.price }<br /> 商品库存：${p.hp_stock }<br />
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2019 上海海文 All Rights Reserved.
	</div>
</body>
</html>

