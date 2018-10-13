<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style>
     body{
        background:url("<%=path %>/images/index.JPG");
		/* padding-left:50px; */
		text-align:center;
		background-position:center top;
		background-size:cover;
		background-repeat:no-repeat ;
		height:700px;
	 }
	 div{
	        width: 500px;
            height: 400px;
            position:absolute;
            left:0;
            top: 0;
            bottom: 0;
            right: 0;
            margin: auto;
            font-family:楷体;
	 }
    </style>
</head>

<body >

    <div>
	   <p style="font-size:60px"><spring:message code="bank.main.title"/></h1>
	   <p style="font-size:30px;padding-top:3px"><spring:message code="bank.page.choose"/>
	      <a href="chinese.do?locale=zh_CN"><button style="font-size:20px"><spring:message code="bank.page.chinese"/></button></a>
	      <a href="english.do?locale=en_US"><button style="font-size:20px; height:32px; padding-top:3px">English</button></a>
	   </p>
	   
	   <a style="text-decoration:none" href="<%=path%>/toLogin.do"><spring:message code="bank.user.login"/> </a>&nbsp
	   <a style="text-decoration:none" href="<%=path%>/toRegister.do"><spring:message code="bank.user.register"/></a><br>
	   
    </div>
 
</body>
</html>