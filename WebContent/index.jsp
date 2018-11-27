<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	if(top.location != self.location){
		top.location = "index.jsp";
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/javascript/jquery-3.1.1.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type : "post",
		url : "http://59.110.218.127:8080/JD/loginServlet",
		data : "login_name=a123456&password=a123456",
		success : function(msg){
			alert(msg);
		}
	});
});
</script>
<style>
		*{
			margin: 0;
			padding: 0;
		}
		div{
			width: 100%;
			margin-top: 6%;
		}
		tr{
			font-size: 18px;
			height: 50px;
		}
		td{
			height: 30px;
		}
		input{
			
			font-size: 15px;
			height: 25px;
			width: 256px;
			border: 2px solid;
			border-radius: 7px;
		}
		caption {
			font-size: 30px;
			color: gray;
		}
	</style>
<body>
当前在线人数:${onlineNum }
<form action="loginServlet" method="post">
	<div align="center">
		<table>
		<caption>管&ensp;理&ensp;员&ensp;登&ensp;录</caption>
			<br />
			<tr>
				<td>账&ensp;号&ensp;:&ensp;<input type='text' name='login_name' placeholder='   请输入账号' /></td>
			</tr>
			<tr>
				<td>密&ensp;码&ensp;:&ensp;<input type='password' name='password' placeholder='   请输入密码' /></td>
			</tr>
			<tr>
				<td>
					<input style="width: 100px;height: 30px;margin: 10px 100px;" type='submit' value='登录' />
				</td>
			</tr>
		</table>
	</div>
</form>
</body>
</html>