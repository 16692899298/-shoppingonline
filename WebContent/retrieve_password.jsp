
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>亚马逊</title>
<link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/adv.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/scripts/jquery-2.1.0.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/scripts/adv.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/index.js"></script>
<script type="text/javascript">
function SendMail() {
	var email=$("#email").val;
	$.ajax({
		url : "sendEmail",// 请求的servlet地址
		type : "GET",// 请求方式
		data : {"email":email},// 发送到服务器的数据<%--data : "userName=" + userName.value,    --%>
		dataType : "text",// 设置返回数据类型
		success : function(total) {
			
			if(total==1){
			alert("验证码发送成功");
			}else{
				alert("用户名邮箱不匹配!")
			}
		},// 响应成功后执行的回调方法data响应文本
		complete : function(XMLHttpRequest, statusText) {
			
		},// 响应完成后执行的回调方法
		error : function(XMLHttpRequest, statusText) {
			alert("操作失败!")
		}// 响应失败后执行的回调方法
	})
}

</script>
</head>
<body>
<%@ include file="index_top.jsp" %>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>请键入找回密码的相关信息：</h1>
			<form id="loginForm" method="post" action="retrievePassWordServlet">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="userName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">真实姓名：</td>
						<td><input class="text" type="text" id="uName" name="uName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">邮箱：</td>
						<td><input class="text" type="text" id="email" name="email" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text" type="text" id="ma" name="ma" onfocus="FocusItem(this)" onblur="CheckItem(this);"  /><span></span></td>
						<td><input class="text" type="button" id="bma" name="bma"  value="发送验证码" onclick="SendMail();"  /><span></span></td>
						
					</tr>
					
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2019 上海海文 All Rights Reserved. 
</div>
</body>
</html>
