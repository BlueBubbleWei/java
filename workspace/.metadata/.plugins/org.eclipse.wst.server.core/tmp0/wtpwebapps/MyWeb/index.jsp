
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.content{
		width:50%;
		height:50%;
		margin:0 auto;
		border:1px solid #000;
		background:lightblue;
		padding:20px;
	}
</style>
</head>
<body>
<h1>hELLO world!</h1>
	<div class="content">
		<form action="#" method="post" name="myform">
		<p><span>用户名</span><input type="text" name="username" placeholder="请输入用户名"  /></p>
		<p><span>密码</span><input type="password" name="userpwd" placeholder="请输入密码"  /></p>
		<p><span>性别</span><input type="radio"name="sex" checked="checked" value="male"  />男
		<input type="radio"name="sex" value="female"  />女
		</p>
		<input type="submit" value="提交" />
		</form>
	</div>

</body>
</html>