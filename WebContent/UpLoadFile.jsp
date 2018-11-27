<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="fileServlet?op=upLoad" method="post" enctype="multipart/form-data">
	<table>
		<tr><td>文件名称&ensp;:&ensp; <input type="text" name="fileName" /></td></tr>
		<tr><td>上传附件&ensp;:&ensp; <input type="file" name="myFile" /></td></tr>
		<tr><td>文件描述&ensp;:&ensp; <textarea rows="6" cols="19" name="fileDesc"></textarea> </td></tr>
	</table>
	<input type="submit" value="上传" />
	<input type="reset" value="重置" />
</form>
</body>
</html>