<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
 <body>
 <h3 align="center">学生信息管理</h3>
  <a href="addstudent.jsp">注册</a>
   <table border="1" align="center">
    <tr align="center">
     <td width="10%">ID</td>
     <td width="10%">姓名</td>
     <td width="10%">出生日期</td>
     <td width="10%">平均分</td>
     <td width="20%">备注</td>
     <td colspan="2" width="30%">操作</td>
    </tr>
  <c:forEach items="${student_List}" var="student" begin="${(pageNos-1)*10 }" end="${pageNos*10-1}">
    <tr align="center">
    <td>${student.student_id}</td>
    <td>${student.student_name}</td>
    <td><fmt:formatDate value="${student.brithday}" type="date"/></td>
    <td>${student.avgscore}</td>
    <td>${student.note}</td>
    <td><a href="edit.jsp">修改</a></td>
    <td><a href="Stu_delete?student_id=${student.student_id}">删除</a></td>
   </tr>  
  </c:forEach>
   <tr align="center">
    <td colspan="7">  
     <jsp:include page="footer.jsp"></jsp:include>  
    </td>
   </tr>
  </table>  
 </body>
</html>
