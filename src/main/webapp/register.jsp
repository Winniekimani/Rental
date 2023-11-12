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

<%=
application.getInitParameter("AppName")
%>


<h1>
<%= application.getAttribute("attributeFrom") %>
</h1>


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
