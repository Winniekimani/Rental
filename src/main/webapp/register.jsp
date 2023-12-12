<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="./header.jsp" />
<div class="row">
    <div class="col-md-12">
        <div class="panel panel-default login">
            <div class="panel-heading logintitle">Register As Tenant</div>
            <div class="panel-body">
                <form class="form-horizontal center-block" role="form" action="./user" method="POST">
                    <input type="hidden" name="action" value="register">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" maxlength="200" class="form-control" name="name" placeholder="Name" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">UserName</label>
                        <div class="col-sm-10">
                            <input type="text" maxlength="200" class="form-control" name="username" placeholder="Name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" maxlength="200" class="form-control" name="email" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" maxlength="200" class="form-control" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Confirm Password</label>
                        <div class="col-sm-10">
                            <input type="password" maxlength="200" class="form-control" name="confirmPassword" placeholder="Password" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Phone</label>
                        <div class="col-sm-10">
                            <input type="text" maxlength="200" class="form-control" name="phone" placeholder="Phone No." required>
                        </div>
                    </div>



                    <div style="text-align:center;font-weight:bold;color:red">
                        <%
                            String loginError = (String) application.getAttribute("loginError");

                            if (loginError != null && !loginError.equals("")) {

                        %>
                        <span style="color:red"> <%= application.getAttribute("loginError") %> </span><br/>

                        <% } %>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-7 col-sm-offset-2" style="margin:0 0 0 40%">
                            <button type="submit" class="btn btn-primary">RegisterTenant Now</button>
                        </div>
                    </div>
                    <br><Br><Br>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="./footer.jsp" />
<%--
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

&lt;%&ndash;---${initParam.AppName}------&ndash;%&gt;



  <c:out value="${initParam.AppName}" />
<h1>${applicationScope.pagelink}</h1>
  &lt;%&ndash;----<h1><c:out value="${applicationScope.pagelink}" /></h1>-&ndash;%&gt;

  <div class="login-container">
      <br> <br>
      <h3>Register User</h3>
      <form action="./user" method="post">
        <label for="username">Username:</label>
        <input type="text"  name="username" required />

        <label for="password">Password:</label>
        <input type="password" name="password" required>

        <label >Confirm Password:</label>
        <input type="password" name="confirmPassword" required>

        <input type="submit"  />
      </form>
      <a href="./">Back to Login</a>
  </div>

  </body>
  </html>
--%>
