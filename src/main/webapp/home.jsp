<!-- home.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.app.View.toolbar.TopToolBar" %>
<%@ page import="com.winnie.app.userbean.ActiveMenuBean" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <!-- Inline Styles -->
        <style>
            .homeParentContainer {
                display: flex;
                width: 83%;
                margin: 0px auto;
                align-items: center;
                height: 90vh;
            }

            .headingOne {
                font-size: 3rem;
            }

            .leftHomeSide {
                width: 50%;
                display: flex;
                flex-direction: column;
                gap: 40px;
            }

            .rightHomeSide {
                width: 50%;
                height: 100%;
            }

            .data {
                font-size: 1.5rem;
                font-weight: 600;
                margin-bottom: 10px;
            }

            .homeSummary {
                width: 70%;
            }

            img {
                height: 100%;
                width: 100%;
                object-fit: contain;
            }

            .stat {
                display: flex;
                width: 65%;
                justify-content: space-between;
            }
               <jsp:include page="./style/style.jsp"/>
        </style>
</head>
<body>
<jsp:useBean id="toolbar" class="com.winnie.app.View.toolbar.TopToolBar" />
<jsp:useBean id="activeMenuBean" class="com.winnie.app.userbean.ActiveMenuBean" />
<jsp:setProperty name="activeMenuBean" property="activeMenu" value="${requestScope.activeMenu}"/>
${toolbar.menu(activeMenuBean.activeMenu)}
    <div class="HomePage">
        <div class="homeParentContainer">
            <!-- left side -->
            <div class="leftHomeSide">
                <p class="headingOne">Invest your wealth <br> into your dream <br> property</p>
                <p class="homeSummary">We have the best property buildings for your future investments, efficient online platform connecting tenants with landlords for seamless and secure house rentals, streamlining the process.</p>
                <div class="stat">
                    <div>
                        <p class="data">500+ </p>
                        <p>Happy Clients</p>
                    </div>
                    <div>
                        <p class="data">600+ </p>
                        <p>Successful Trans</p>
                    </div>
                </div>
            </div>
            <!-- right side -->
            <div class="rightHomeSide">
                <img src="https://images.unsplash.com/photo-1560185007-5f0bb1866cab?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTA2fHxob3VzZXxlbnwwfHwwfHx8MA%3D%3D" alt="homeImage">
            </div>
        </div>
    </div>
</body>
</html>
