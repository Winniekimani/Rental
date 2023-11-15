


<%---this is index page-----%>
<%---
<%@ page import="com.winnie.jsputils.Calculator"%>
<%!
  String appHeader="<h2>Rental Software</h2>";
     Calculator newCalculator = new Calculator();
    int justAnotherNo = new Calculator().addNumbers(3000,4000);
%>
  ---%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Login</title>

  <style>

    <jsp:include page="./style/style.jsp"/>

    <%--
     <%@ include file="./style/style.jsp"%>
     ---%>

  </style>
</head>
<body>

<h2>Rental Software</h2>

<h2>${applicationScope.AppName}</h2>

<c:set var="pagelink" value="Home/<a href='index.jsp'>Login</a>Register" scope="application"/>

<%---
<h2><%= application.getInitParameter("AppName")%></h2>

<%
    application.setAttribute("pagelink", "Home/<a href='index.jsp'>Login</a>Register");
%>
----%>




<%--
<%
    int hundred=100;
    int oneThousand=1000;
    int sum=newCalculator.addNumbers(hundred,oneThousand);

        out.println("the sum is:" +sum);

        Request.setAttribute("MyName","WinnieKimani");
    %>

    <br>
    <h2><%=justAnotherNo %></h2>

    <br>
    <h2><%=newCalculator.addNumbers(2000,4000) %></h2>

   --%>


 <jsp:useBean id="loginForm"  class="com.winnie.app.userbean.LoginForm" />

 <jsp:setProperty name="loginForm" property="usernamePlaceHolder" value="Enter Unique Username"/>
<div class="login-container">
  <h2>Login</h2>
   Time to Login ${loginForm.timeToLogin}
  <form action="./login" method="post">
    <label for="username">Username:</label>
    <!---<input type="text" placeholder="username" name="username" required /> --->
    <input type="text" placeholder="${loginForm.usernamePlaceHolder}" name="username" required />

    <label for="password">Password:</label>
    <!----<input type="password" placeholder="password" name="password" required>-->
    <input type="password" placeholder="${loginForm.passwordPlaceHolder}" name="password" required>
    <input type="submit" value="submit" />


  </form>

   <%---<a href="./registerUser">Register User</a>-----%>
    <a href="register.jsp">Register User</a>

</div>
</body>
</html>