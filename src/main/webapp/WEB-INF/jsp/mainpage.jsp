<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'mainpage.jsp' starting page</title>
	 <link rel="stylesheet" href="css/common_form.css">

  <script language="JavaScript">
     function inquiry(){
       window.document.form1.submit();
     }
     function deposit(){
       var money = prompt("<spring:message code='bank.js.money.deposit'/>：","");
       if(money==""){
    	   alert("<spring:message code='bank.js.money.deposit'/>"); 
       }else if(money==null){
       }else{
    	   if(isNaN(money)){
    		   alert("<spring:message code='bank.js.format'/>");
    	   }else if(money<0){
    		   alert("<spring:message code='bank.js.limit'/>");
    	   }else{
    		   var url = "<%=path%>/deposit.do?money="+money;
               window.location.href = url;
    	   }   
       }
     }
     function withdrawal(){
       var money = prompt("<spring:message code='bank.js.money.withdrawal'/>：","");
       if(money==""){
    	   alert("<spring:message code='bank.js.money.withdrawal'/>");
       }else if(money==null){
       }else{
    	   if(isNaN(money)){
    		   alert("<spring:message code='bank.js.format'/>");
    	   }else if(money<0){
    		   alert("<spring:message code='bank.js.limit'/>");
    	   }else{
    		   var url = "<%=path%>/withdrawal.do?&money="+money;
               window.location.href = url;  
    	   }   
       }
     }
    
     function exit(){ 
    	 if(confirm("<spring:message code='bank.js.exit'/>")){
    		 window.document.form5.submit();
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
  
  <div class="content" >
	    <h1 class="content-title"><spring:message code="bank.main.title"/></h1>
		<div class="content-form">
			<form name="form">
			    <div>
			      <form>
			       <font color="red" size="2px">${sessionScope.user.username}</font>
			      </form>
			    </div> 
			    
			    <!-- 查询明细 -->
			    <div>
				    <form action="<%=path %>/getAllDetails.do" method="post">
				       <input  class="content-form-signup" type="submit" value="<spring:message code="bank.business.button.detail"/>" />
				    </form>
			    </div>
			    
			    <!-- 查询余额表单 -->
			    <div>
			       <form name="form1" action="inquiry.do"method="post">
			         <input  class="content-form-signup" type="button" value="<spring:message code="bank.business.button.balance"/>" onClick="inquiry()" />
			       </form>
			    </div>
			    
			    <!-- 存款表单 -->
			    <div>
				    <form name="form2" method="post">
				      <input  class="content-form-signup" type="button" value="<spring:message code="bank.business.button.deposit"/>"  onClick="deposit()"/>
				    </form>
			    </div>
			    
			    <!-- 取款表单 -->
			    <div>
				    <form name="form3"method="post">
				      <input  class="content-form-signup"type="button" value="<spring:message code="bank.business.button.withdrawal"/>"  onClick="withdrawal()"/>
				    </form>
			    </div>
			    
			    <!-- 转账表单 -->
			    <div>
				    <form method="post" action="<%=path %>/toTransferForm.do">
				      <input  class="content-form-signup"type="submit" value="<spring:message code="bank.business.button.transfer"/>"  />
				    </form>
			    </div>
			    
			    <!-- 退出 -->
			    <div>
				    <form  name="form5" action="exit.jsp" method="post">
				      <input  class="content-form-signup"type="button" value="<spring:message code="bank.business.button.exit"/>"  onClick="exit()"/>
				    </form>
			    </div>
			</form>
		</div> 
  </div>
  </body>
</html>
