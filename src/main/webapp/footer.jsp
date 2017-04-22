<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
  <center>
<c:if test="${pageNos>1 }">
<a href="Stu_message?pageNos=1" >首页</a>
<a href="Stu_message?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <countPage }">
<a href="Stu_message?pageNos=${pageNos+1 }">下一页</a>
<a href="Stu_message?pageNos=${countPage }">末页</a>
</c:if>
</center>
<form action="Stu_message">
<h4 align="center">共${countPage}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="跳转">
</h4>
</form>
</body>
</html>
