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
