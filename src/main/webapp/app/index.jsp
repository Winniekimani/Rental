
<%@ page import="com.winnie.app.View.toolbar.TopToolBar"%>
<!DOCTYPE html>
<html>
<head>

  <%--
  <%@ include file="../style/style.jsp"%>
    ---%>

   <jsp:include page="../style/style.jsp"/>
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
