<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./header.jsp" %>
<div class="row">
    <div class="col-md-12">
        <br/><br/><br/><br/><br/><br/><br/><br/>
        <div class="panel panel-default login">
            <div class="panel-heading logintitle">Login</div>
            <div class="panel-body">
                <form class="form-horizontal center-block" role="form" action="./login" method="post">
                    <input type="hidden" name="action" value="login">
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-warning-sign"
                                                                                 aria-hidden="true"></span></span>
                        <select class="form-control" name="userrole">
                            <option value="none" selected="selected" hidden>Select User</option>
                            <option value="admin">Admin</option>
                            <option value="tenant">Tenant</option>
                        </select>
                    </div>
                    <br/>
                    <div>
                    </div>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-user"
                                                                                 aria-hidden="true"></span></span>
                        <input type="text" maxlength="200" class="form-control" name="username"
                               placeholder="username" required aria-describedby="sizing-addon1">
                    </div>
                    <br/>
                     <%-- <div class="input-group input-group-lg">
                                            <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-user"
                                                                                                     aria-hidden="true"></span></span>
                                            <input type="text" maxlength="200" class="form-control" name="email"
                                                   placeholder="email" required aria-describedby="sizing-addon1">
                                        </div>--%>
                    <div class="input-group input-group-lg">
                        <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-lock"
                                                                                 aria-hidden="true"></span></span>
                        <input type="password" name="password" maxlength="200" class="form-control"
                               placeholder="Password" required aria-describedby="sizing-addon1">
                    </div>
                    <br/>
                    <div class="col-sm-7 col-sm-offset-2">
                        <button type="submit" class="btn btn-primary btn-block btn-lg">Login</button>
                    </div>
                </form>
            </div>
            <div style="text-align:center;font-weight:bold;color:red">
                <%
                    String loginError = (String) application.getAttribute("loginError");

                    if (loginError != null && !loginError.equals("")) {

                %>
                <span style="color:red"> <%= application.getAttribute("loginError") %> </span><br/>

                <% } %>
            </div>
            <a href="./register.jsp" style="text-align:Center;font-weight:bold;font-size:120%;padding: 0 2%">Register</a>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp" %>