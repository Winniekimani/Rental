


<%---this is index page-----%>
<%---
<%@ page import="com.winnie.jsputils.Calculator"%>
<%!
  String appHeader="<h2>Rental Software</h2>";
     Calculator newCalculator = new Calculator();
    int justAnotherNo = new Calculator().addNumbers(3000,4000);
%>
  ---%>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>

  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
    }

    .login-container {
      background-color: #fff;
      width: 400px;
      margin: 50px auto;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
    }

    h2 {
      color: rgb(1, 69, 171);
    }

    form {
      text-align: left;
    }

    input[type="text"],
    input[type="password"] {
      width: 95%;
      padding: 10px;
      margin: 10px 0;
      border: 1px solid #ccc;
      border-radius: 5px;

    }

    input[type="text"]:focus,
    input[type="password"]:focus {
      border-color: rgb(238, 238, 238);
      outline: none;
    }

    input[type="submit"] {
      background-color: rgb(0, 53, 133);
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 10px;
      cursor: pointer;
    }
  </style>
</head>
<body>

<h2>Rental Software</h2>

<%= application.getInitParameter("AppName")%>
<%
    application.setAttribute("attributeFrom", "this was set in loginPage");
%>




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
<div class="login-container">
  <h2>Login</h2>

  <form action="./login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required />

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="submit" />


  </form>

   <%---<a href="./registerUser">Register User</a>-----%>
    <a href="register.jsp">Register User</a>

</div>
</body>
</html>