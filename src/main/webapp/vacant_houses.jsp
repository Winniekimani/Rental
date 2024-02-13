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
            <div class="panel-heading">vacant houses</div>
            <!---------------- Panel body Start --------------->
            <div class="panel-body">
                <ul class="nav nav-tabs panelBodyItem">
                    <li role="presentation"><a href="#panelBodyItemlist">Available houses List</a></li>
                </ul>

                <!---------------- Display Tenant Data List Start --------------->
                <div id="panelBodyItemlist" class="switchgroup">
                    <table class="table table-bordered table-hover">
                        <tr class="active">

                            <td>House Id</td>
                            <td>House Name</td>
                            <td>House Type</td>
                            <td>House Location</td>
                            <td>House Price</td>


                        </tr>

                        <c:set var="email" value="${sessionScope.email}"/>
                        <c:set var="tenant" value="${sessionScope.tenant}"/>
                        <c:set var="houses" value="${houseBean.listAvailableHouses()}"/>
                        <c:set var="tenantId" value="${sessionScope.tenantId}"/>

                        <c:forEach var="house" items="${houses}">

                            <tr>
                                <td>
                                        ${house.id}
                                </td>
                                <td>
                                        ${house.houseName}
                                </td>
                                <td>
                                        ${house.houseType}
                                </td>
                                <td>
                                        ${house.houseLocation}
                                </td>

                                <td>
                                        ${house.housePrice}
                                </td>

                                <td>
                                    <a href="./book-house?houseId=${house.id}"
                                       onclick="return confirmBooking()" class="btn btn-primary"><span
                                            class="glyphicon glyphicon-check" aria-hidden="true"> Book house</span></a>
                                </td>
                                <td>
                                    <a href="./mpesa-action?housePrice=${house.housePrice}"
                                    <%--    onclick="return confirmBooking()"--%>
                                       class="btn btn-primary"><span class="glyphicon glyphicon-usd" aria-hidden="true"> Pay for the House</span></a>
                                </td>
                            </tr>

                        </c:forEach>

                    </table>
                </div>

<!-- JavaScript to handle booking confirmation -->
<script>
    function confirmBooking() {
        return confirm("Are you sure you want to book?");
    }
</script>


<%@ include file="./main_content_footer.jsp" %>

