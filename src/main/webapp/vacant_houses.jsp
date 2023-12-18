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
                        <%--   <c:set var="tenant" value="${requestScope.tenant}"/>--%>
                        <c:set var="houses" value="${houseBean.listAvailableHouses()}"/>

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
                                <ul class="nav nav-tabs panelBodyItem">

                                    <li role="presentation">
                                        <a href="javascript:void(0);" onclick="confirmBooking(${house.id})">Book House</a>
                                    </li>
                                    <li role="presentation"><a href="#addpanelBodyItem">Pay for the House</a></li>

                                  <%--  <li role="presentation">
                                        <a href="<c:url value='/booking/?houseId=${house.id}'/>">Book House</a>
                                    </li>--%>
<%--

                                    <li role="presentation"><a href="#addpanelBodyItem">Book House</a></li>

                                    <li role="presentation"><a href="#addpanelBodyItem">Pay for the House</a></li>--%>
                                </ul>



                            </td>
                        </tr>

                        </c:forEach>

                    </table>
                </div>

                <!-- JavaScript to handle booking confirmation -->
                <script>
                    function confirmBooking(houseId) {
                        var confirmed = confirm("Are you sure you want to book this house?");
                        if (confirmed) {
                            // Update the link text to "Booked"
                            var link = document.querySelector(`a[data-house-id="${houseId}"]`);
                            if (link) {
                                link.innerHTML = "Booked";

                                // Display the confirmation message directly
                                link.parentNode.innerHTML += '<p style="color: green;">Booking confirmed. Thank you!</p>';

                                window.location.href = "<c:url value='/booking/'/>?houseId=" + houseId;
                            }

                            // Perform AJAX request to update the status in the database
                            // You can use JavaScript frameworks like jQuery or fetch API for this
                            // Example using fetch API:
                          /*  fetch(`/updateHouseStatus?id=${houseId}&status=booked`, { method: 'POST' })
                                .then(response => response.json())
                                .then(data => console.log(data))
                                .catch(error => console.error(error));*/
                        }
                    }
                </script>


<%@ include file="./main_content_footer.jsp" %>
