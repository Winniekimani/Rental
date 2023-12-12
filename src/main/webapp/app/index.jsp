
<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.app.View.toolbar.TopToolBar" %>
<%@ page import="com.winnie.app.userbean.ActiveMenuBean" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ include file="../main_content_header.jsp" %>
<div class="row">
<jsp:useBean id="toolbar" class="com.winnie.app.View.toolbar.TopToolBar" />
<jsp:useBean id="activeMenuBean" class="com.winnie.app.userbean.ActiveMenuBean" />
<jsp:setProperty name="activeMenuBean" property="activeMenu" value="${requestScope.activeMenu}"/>
${toolbar.menu(activeMenuBean.activeMenu)}

<h3>${applicationScope.AppName}</h3>
<br/>&nbsp;<br/>
<h3>Welcome: ${sessionScope.username}</h3>
 <!---- Content Ares Start  -------->
 <div class="col-md-10 maincontent">
  <!----------------   Menu Tab   --------------->
  <div class="panel panel-default contentinside">
   <div class="panel-heading"></div>
   <!----------------   Panel body Start   --------------->
   <div class="panel-body">

    <!----------------   Send Email Form Start   --------------->
    <div id="panelBodyItemlist" class="switchgroup">
     <div class="panel panel-default">
      <div class="panel-body">
       <jsp:useBean id="contentBean" class="com.winnie.app.userbean.ContentBean" scope="request"/>
       <jsp:setProperty name="contentBean" property="content" value="${requestScope.content}"/>
       ${contentBean.content}
      </div>
     </div>
    </div>
    <!----------------   Send Email Ends   --------------->
   </div>
   <!----------------   Panel body Ends   --------------->
  </div>
  <!-----------  Content Menu Tab Ends   ------------>
 </div>
 <!-------   Content Area Ends  --------->
</div>

<%@ include file="../main_content_footer.jsp" %>