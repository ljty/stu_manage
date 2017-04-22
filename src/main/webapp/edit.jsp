<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">学生信息修改</h3>
<form action="Stu_edit" method="post" accept-charset="ISO-8859-1">
 <table  align="center">
<tr ><td>ID:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input id="frameColor" name="stu_id" ></td></tr>
<tr><td>姓名:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input id="frameColor" name="stu_name" ></td></tr>
<tr><td>出生日期:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input id="frameColor" name="stu_brithday"  ></td></tr>
<tr><td>平均分:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input id="frameColor" name="stu_avregarde" ></td></tr>
<tr><td>备注:&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input id="frameColor" name="stu_note" ></td></tr>
<tr >
<td align="center"><input type="submit" value="修改"/></td>
<td align="center"><input type="reset" value="重置"/></td></tr>
</table>
</form>
</body>
</html>