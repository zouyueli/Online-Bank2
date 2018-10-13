<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background:#f4f4f4">
<h1><spring:message code="bank.business.button.detail"/></h1>
<table border="1" height="200px" width="600px">
<tr>
  <th><spring:message code="bank.page.detail.type"/></th>
  <th><spring:message code="bank.page.detail.money"/></th>
  <th><spring:message code="bank.page.detail.date"/></th>
</tr>
<c:forEach items="${detaillist}" var="detail">
    <tr  align="center">
    <td>${detail.reason }</td>
    <td>${detail.money }</td>
    <td><fmt:formatDate value="${detail.date }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
    </tr> 
</c:forEach>

</table>
</body>
</html>