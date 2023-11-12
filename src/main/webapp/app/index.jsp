
<%@ page import="com.winnie.app.View.toolbar.TopToolBar"%>
<!DOCTYPE html>
<html>
<head>
  <style>
    /* add-house-css */
    .addHouseButton {
      padding: 12px;
      border-radius: 5px;
      border: none;
      background-color: rgb(10, 79, 182);
      color: white;
      cursor: pointer;
      width: 100px;
      display: flex;
      justify-content: center;
    }

    .addHouseButton a {
      text-decoration: none;
      color: white;
    }

    /* add-tenant-css */
    .addTenantButton {
      padding: 12px;
      border-radius: 5px;
      border: none;
      background-color: rgb(10, 79, 182);
      color: white;
      cursor: pointer;
      width: 100px;
      display: flex;
      justify-content: center;
    }

    .addTenantButton a {
      text-decoration: none;
      color: white;
    }

    ul.topnav {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }

    ul.topnav li {
      float: left;
    }

    ul.topnav li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }

    ul.topnav li a:hover {
      background-color: blue;
    }

    /* ul.topnav li a.active { background-color: pink; } */

    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }
  </style>
</head>

<body>
  <%=new TopToolBar().menu((int)request.getAttribute("activeMenu")) %>
  <h3><%= application.getInitParameter("AppName")%><h3>
  <br/>&nbsp;<br/>
  <h3>Welcome: <%= session.getAttribute("username") %> </h3><br/>

 <%= request.getAttribute("content") %>
   <a href=\"./logout\">Logout</a>
  </body>
  </html>
