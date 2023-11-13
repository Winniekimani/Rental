

<%@ page import="com.winnie.app.View.toolbar.TopToolBar" %>
<%@ page import="com.winnie.app.userbean.ActiveMenuBean" %>





<!DOCTYPE html>
<html>
<head>

  <%--
  <%@ include file="../style/style.jsp"%>
    ---%>

   <jsp:include page="../style/style.jsp"/>
</head>

<body>

<%--
  <%=new TopToolBar().menu((int)request.getAttribute("activeMenu")) %>
---%>


 <jsp:useBean id="toolbar" class="com.winnie.app.View.toolbar.TopToolBar" scope="request"/>
 <jsp:useBean id="activeMenuBean" class="com.winnie.app.userbean.ActiveMenuBean" scope="request"/>

 <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>'/>
 <%= toolbar.menu(activeMenuBean.getActiveMenu()) %>


  <h3><%= application.getInitParameter("AppName")%><h3>
  <br/>&nbsp;<br/>
  <h3>Welcome: <%= session.getAttribute("username") %> </h3><br/>

<%--
 <%= request.getAttribute("content") %>
 ---%>

 <jsp:useBean id="contentBean" class="com.winnie.app.userbean.ContentBean" scope="request"/>
 <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>'/>
 <%= contentBean.getContent() %>

   <a href=\"./logout\">Logout</a>
  </body>
  </html>
