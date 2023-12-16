<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.common.CommonMethods" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<% if (CommonMethods.IsSessionExpired(request, response)) { return; } %>

<jsp:include page="./tenant_content_header.jsp" />


<div class="row">

    <%@ include file="./menu_tenant.jsp" %>

    <!---- Content Ares Start  -------->
    <div class="col-md-10 maincontent" >
        <!----------------   Menu Tab   --------------->
        <div class="panel panel-default contentinside">
            <div class="panel-heading">Manage Billing Information</div>
            <!----------------   Panel body Start   --------------->
            <div class="panel-body">
                <ul class="nav nav-tabs panelBodyItem">
                    <li role="presentation"><a href="#panelBodyItemlist">Billing List</a></li>
                </ul>

                <!----------------   Display Billing Data List Start  --------------->

                <div id="panelBodyItemlist" class="switchgroup">
                    <table class="table table-bordered table-hover">
                        <tr class="active">
                            <td>Tenant ID</td>
                            <td>Tenant Name</td>
                            <td>Bill No</td>
                            <td>House Charges(Ksh)</td>
                            <td>Other Charges(Ksh)</td>
                            <td>Payment Date</td>
                        </tr>
                        <c:set var="billingBean" value="${sessionScope.billingBean}"/>

                        <c:set var="tenantBean" value="${sessionScope.tenantBean}"/>
                        <c:set var="tenant" value="${tenantBean.tenantByEmail(email)}"/>

                        <c:forEach var="billing" items="${billingBean.getBillingByTenantId(tenant.id)}">
                            <tr>
                                <td>${billing.tenantId}</td>
                                <td>${billing.firstName}</td>
                                <td>${billing.billNo}</td>
                                <td>${billing.houseCharge}</td>
                                <td>${billing.otherCharges}</td>
                                <td>${billing.paymentDate}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <!----------------   Display Billing Data List Ends  --------------->

            </div>
            <!----------------   Panel body Ends   --------------->
        </div>
    </div>
</div>
<jsp:include page="./main_content_footer.jsp" />