<%@ page language="java" contentType="text/html; charset=GBK"  
   pageEncoding="GBK"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>  
 <head>  
 <meta http-equiv="Content-Type" content="text/html; charset=GBK">  
 <title>管理员管理页面</title>  
 </head>  
 <body>  
<table border="1" height="200px" width="600px">
<h1>所有用户的信息</h1>
<tr>
  <th>用户名</th>
  <th>余额</th>
  <th>是否冻结</th>
</tr>
<c:forEach items="${alluser}" var="user">
    <tr  align="center">
    <td>
      <a href="<%=path %>/getUserDetails.do?id=${user.id}">${user.username}</a>
    </td>
    <td>${user.money}</td>
    <td>
    <form action="<%=path%>/modifyIsFreeze.do">
      <input type="hidden" name="id" value="${user.id}">
      <input name="isFreeze" value="${user.isFreeze}">
      <input type="submit" value="提交"/>
    </form>
    
    
    </td>
    </tr> 
</c:forEach>
 </table>  
</body>  
 </html>  