<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="p" uri="http://www.itcast.cn/tag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线支付</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<p:user/>
	<form action="${pageContext.request.contextPath}/pay" method="post">
		订单号：<INPUT TYPE="text" NAME="orderid" value="${param.id}">
		支付金额：<INPUT TYPE="text" NAME="money" value="${param.money}">元
		<div class="divBank">
			<div class="divText">选择网上银行</div>
			<div style="margin-left: 20px;">
				<div style="margin-bottom: 20px;">
					<input id="ICBC-NET-B2C" type="radio" name="yh"
						value="ICBC-NET-B2C" checked="checked" /> 
						<img name="ICBC-NET-B2C" align="middle" src="<c:url value='/client/bank_img/icbc.bmp'/>" /> 
						<input id="CCB-NET-B2C" type="radio" name="yh" value="CCB-NET-B2C" /> 
						<img name="CCB-NET-B2C" align="middle" src="<c:url value='/client/bank_img/ccb.bmp'/>" />
				</div>
			</div>
			<div style="margin: 40px;">
				<INPUT TYPE="submit" value="确定支付">
			</div>
		</div>
	</form>
</body>
</html>
