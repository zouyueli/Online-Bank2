<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
  <title>Insert title here</title>
  <link rel="stylesheet" href="css/common_form.css">
  <script language="JavaScript">
     function transfer(){
    	 var money = document.form.money.value;
    	 if(money==""){
    		 alert("<spring:message code='bank.js.money.transfer'/>");
    	 }else{
    		 if(isNaN(money)){
    			 alert("<spring:message code='bank.js.format'/>");
    		 }else if(money<0){
    			 alert("<spring:message code='bank.js.limit'/>");
    		 }else{
    			 var otherUserName = document.form.otherUserName.value;
    			 if(otherUserName==""){
      	       	      alert("<spring:message code='bank.js.username.transfer'/>");
      	         }else{
      	        	  window.document.form.submit();
      	         }
    		 }
    	 }
     }
  </script>
  <style type="text/css">
  .content-form{

      background: lightblue;
  } 
  </style>
</head>
<body>

<!-- 使用get和post会有区别，如果是post则通过中文的用户名去查数据库的记录，没有问题，
但是如果是get，则会出现问题。
 -->
 
<div class="content">
    <h1 class="content-title"><spring:message code="bank.business.button.transfer"/></h1>
	<div class="content-form" style="color:lightblue">
		<form name="form" action="<%=path%>/transfer.do" method="post">
		     <div>
		         <input class="money" name="money" type="text" placeholder="<spring:message code="bank.js.money.transfer"/>" style="width:250px;height:20px"/></br>   
		     </div>
		     <p id="remind_1"></p>
		     <div>
		         <input class="otherUserName" name="otherUserName" type="text" placeholder=" <spring:message code="bank.js.username.transfer"/>" style="width:250px;height:20px"></br>
		     </div>
		      <p id="remind_2"></p>
		     <div>
		         <input class="content-form-signup" type="button" value="<spring:message code="bank.business.button.transfer"/>" onClick="transfer()"
		         style="width:270px;height:40px;"/>
		     </div>
		</form>
	</div>
</div>
</body>
</html>