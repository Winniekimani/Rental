<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.common.CommonMethods" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<% if (CommonMethods.IsSessionExpired(request, response)) {
    return;
} %>

<%@include file="./tenant_content_header.jsp" %>

<div class="row">

    <%@include file="./menu_tenant.jsp" %>
    <!---- Content Ares Start -------->
    <div class="col-md-10 maincontent">
        <!---------------- Menu Tab --------------->

        <div class="panel panel-default contentinside">
            <div class="panel-heading">Manage Tenant</div>
            <!---------------- Panel body Start --------------->
            <div class="panel-body">
                <ul class="nav nav-tabs panelBodyItem">
                    <li role="presentation"><a href="#panelBodyItemlist">Tenant List</a></li>
                </ul>

                <!---------------- Display Tenant Data List Start --------------->
                <div id="panelBodyItemlist" class="switchgroup">
                    <table class="table table-bordered table-hover">
                        <tr class="active">
                            <td>Id</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Email</td>
                            <td>Phone</td>
                            <td>Lease Start Date</td>
                            <td>Lease End Date</td>
                            <td>House Id</td>
                            <td>House Name</td>
                            <td>Rent Amount</td>

                        </tr>

                        <c:set var="email" value="${sessionScope.email}"/>
                        <%--   <c:set var="tenant" value="${requestScope.tenant}"/>--%>
                        <c:set var="tenantBean" value="${sessionScope.tenantBean}"/>

                        <c:set var="tenant" value="${tenantBean.tenantByEmail(email)}"/>

                        <tr>
                            <td>
                                ${tenant.id}
                            </td>
                            <td>
                                ${tenant.firstName}
                            </td>
                            <td>
                                ${tenant.lastName}
                            </td>
                            <td>
                                ${tenant.email}
                            </td>
                            <td>
                                ${tenant.phone}
                            </td>

                            <td>
                                ${tenant.leaseStartDate}
                            </td>
                            <td>
                                ${tenant.leaseEndDate}
                            </td>
                            <td>
                                ${tenant.houseId}
                            </td>
                            <td>
                                ${tenant.houseName}
                            </td>
                            <td>
                                ${tenant.rentAmount}
                            </td>
                            <td>
                                <a href="#">
                                    <button type="button" class="btn btn-primary" data-toggle="modal"
                                            data-target="#myModal${tenant.id}"><span class="glyphicon glyphicon-wrench"
                                                                                     aria-hidden="true"></span></button>
                                </a>
                            </td>
                        </tr>


                    </table>
                </div>
                <!---------------- Display Tenant Data List Ends --------------->

                <!------ Tenant Edit Info Modal Start Here ---------->

                <%--<c:forEach items="${tenantBean.tenantByEmail(email)}" var="tenant">--%>
                <div class="modal fade" id="myModal${tenant.id}" tabindex="-1" role="dialog"
                     aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Edit Tenant Information</h4>
                            </div>

                            <div class="modal-body">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <form class="form-horizontal" action="./tenant-user-update"
                                              method="post">
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Tenant Id</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" name="id"
                                                           placeholder="Tenant ID" value="${tenant.id}"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">House ID</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" name="houseId"
                                                           placeholder="houseId" value="${tenant.houseId}"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">FirstName</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="firstName"
                                                           value="${tenant.firstName}" placeholder="Name">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">LastName</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="lastName"
                                                           value="${tenant.lastName}}" placeholder="Name">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Email</label>
                                                <div class="col-sm-10">
                                                    <input type="email" class="form-control" name="email"
                                                           value="${tenant.email}" placeholder="email">
                                                </div>
                                            </div>


                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Phone</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" name="phone"
                                                           value="${tenant.phone}" placeholder="Phone">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Start Date</label>
                                                <div class="col-sm-10">
                                                    <input type="date" class="form-control" name="leaseStartDate"
                                                           placeholder="Tenant ID" value="${tenant.leaseStartDate}"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">End Date</label>
                                                <div class="col-sm-10">
                                                    <input type="date" class="form-control" name="leaseEndDate"
                                                           placeholder="Tenant ID" value="${tenant.leaseEndDate}"
                                                           readonly="readonly">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Rent Amount</label>
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" name="rentAmount"
                                                           placeholder="Tenant ID" value="${tenant.rentAmount}"
                                                           readonly="readonly">
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default"
                                                        data-dismiss="modal">Close
                                                </button>
                                                <input type="submit" class="btn btn-primary" value="Update"></button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--    </c:forEach>--%>

                <!---------------- Modal ends here --------------->

            </div>
            <!---------------- Panel body Ends --------------->
        </div>
    </div>
</div>

<jsp:include page="./main_content_footer.jsp"/>
