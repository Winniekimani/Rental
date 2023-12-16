<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="com.winnie.app.model.entity.House" %>
<%@ page import="com.winnie.app.bean.HouseBean" %>
<%@ page import="com.winnie.common.CommonMethods" %>
<%@ page import="com.winnie.app.bean.TenantBean" %>
<%@ page import="com.winnie.app.model.entity.Tenant" %>
<%@ page import="com.winnie.app.model.entity.Booking" %>
<%@ page import="java.util.Objects" %>

<%
    if (CommonMethods.IsSessionExpired(request, response)) {
        return;
    }
    // Get the list of available houses
    List<House> availableHouses = new HouseBean().listAvailableHouses();

    // Get the current tenant
    Tenant tenant = (Tenant) session.getAttribute("loggedInTenant");
%>

<%@ include file="./main_content_header.jsp" %>

<div class="col-md-10 maincontent">
    <!-- Display available houses -->
    <div class="panel panel-default">
        <div class="panel-heading">Available Houses</div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>House ID</th>
                    <th>House Name</th>
                    <th>House Type</th>
                    <th>House Location</th>
                    <th>House Price</th>
                </tr>
                </thead>
                <tbody>
                <% for (House house : availableHouses) { %>
                <tr>
                    <td><%= house.getId() %></td>
                    <td><%= house.getHouseName() %></td>
                    <td><%= house.getHouseType() %></td>
                    <td><%= house.getHouseLocation() %></td>
                    <td><%= house.getHousePrice() %></td>

                    <td>
                        <button class="btn btn-primary" onclick="confirmBooking(<%= house.getId() %>, '<%= tenant.getEmail() %>')">Book</button>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- JavaScript to handle booking confirmation -->
<script>
    function confirmBooking(houseId, tenantEmail) {
        var confirmed = confirm("Are you sure you want to book this house?");
        if (confirmed) {
            // Perform the booking (you might want to use AJAX to send a request to the server)
            alert("Booking confirmed!");
            // Redirect or update the page as needed
        }
    }
</script>

<%@ include file="./main_content_footer.jsp" %>
