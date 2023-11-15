
<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.app.View.toolbar.TopToolBar" %>
<%@ page import="com.winnie.app.userbean.ActiveMenuBean" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>





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

<%--
 <jsp:useBean id="toolbar" class="com.winnie.app.View.toolbar.TopToolBar" />
 <jsp:useBean id="activeMenuBean" class="com.winnie.app.userbean.ActiveMenuBean" />

 <jsp:setProperty name="activeMenuBean" property="activeMenu" value='<%= request.getAttribute("activeMenu") %>'/>
 <%= toolbar.menu(activeMenuBean.getActiveMenu()) %>
--%>

<jsp:useBean id="toolbar" class="com.winnie.app.View.toolbar.TopToolBar" />
<jsp:useBean id="activeMenuBean" class="com.winnie.app.userbean.ActiveMenuBean" />
<jsp:setProperty name="activeMenuBean" property="activeMenu" value="${requestScope.activeMenu}"/>
${toolbar.menu(activeMenuBean.activeMenu)}

<%--
  <h3><%= application.getInitParameter("AppName")%><h3>
  <br/>&nbsp;<br/>
  <h3>Welcome: <%= session.getAttribute("username") %> </h3><br/>
--%>

<h3>${applicationScope.AppName}</h3>
<br/>&nbsp;<br/>
<h3>Welcome: ${sessionScope.username}</h3>

<%--
 <%= request.getAttribute("content") %>
 ---%>

<%--
 <jsp:useBean id="contentBean" class="com.winnie.app.userbean.ContentBean" scope="request"/>
 <jsp:setProperty name="contentBean" property="content" value='<%= request.getAttribute("content") %>'/>
 <%= contentBean.getContent() %>

 --%>

 <jsp:useBean id="contentBean" class="com.winnie.app.userbean.ContentBean" scope="request"/>
 <jsp:setProperty name="contentBean" property="content" value="${requestScope.content}"/>
 ${contentBean.content}


  </body>
  </html>