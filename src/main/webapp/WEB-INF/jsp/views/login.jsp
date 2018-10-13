
<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <title><spring:message code="bank.user.login"/></title>
    <link rel="stylesheet" href="css/common_form.css">
</head>
<script language="JavaScript">
   function login(){
	   var username = document.form.username.value;
	   if(username==""){
		   alert("<spring:message code='bank.user.username'/>");
	   }else{
		   var password = document.form.password.value;
		   if(password==""){
			   alert("<spring:message code='bank.user.password'/>");
		   }else{
               document.form.submit();
		   }
	   }
   }

</script>
<body>
<header>
    <div class="header-line"></div>
</header>
<div class="content">
    <h1 class="content-title"><spring:message code="bank.user.login"/></h1>
    <div class="content-form">
        <form name="form" method="post" action="login.do">
            <div id="change_margin_1">
                <input class="user" type="text" name="username" placeholder="<spring:message code="bank.user.username"/>">
            </div>
            <p id="remind_1"></p>
            <div id="change_margin_2">
                <input class="password" type="password" name="password" placeholder="<spring:message code="bank.user.password"/>" >
            </div>
            <p id="remind_2"></p>
            <div id="change_margin_3">
                <input class="content-form-signup" type="button" value="<spring:message code="bank.user.login"/>" onClick="login()">
            </div>
        </form>
        <div class="content-login-description"><spring:message code="bank.user.account"/><a class="content-login-link" href="<%=path%>/toRegister.do"><spring:message code="bank.user.register"/></a></div>
    </div>
</div>
</body>
</html>

