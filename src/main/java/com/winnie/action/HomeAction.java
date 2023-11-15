package com.winnie.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeAction extends BaseAction {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        renderPage(req, resp, 0,
                "<style>" +
                        " .homeParentContainer{\n" +
                        "        display: flex;\n" +
                        "        width: 83%;\n" +
                        "        margin: 0px auto;\n" +
                        "        align-items: center;\n" +
                        "        height: 90vh;\n" +
                        "       \n" +
                        "    }"+
                        " .headingOne{\n" +
                        "        font-size: 3rem;\n" +
                        "    }\n" +
                        "\n" +
                        "    .leftHomeSide{\n" +
                        "        width: 50%;\n" +
                        "        display: flex;\n" +
                        "        flex-direction: column;\n" +
                        "        gap: 40px;\n" +
                        "    }\n" +
                        "    .rightHomeSide{\n" +
                        "        width: 50%;\n" +
                        "        height: 100%;\n" +
                        "    }\n" +
                        "    .data{\n" +
                        "        font-size: 1.5rem;\n" +
                        "        font-weight: 600;\n" +
                        "        margin-bottom: 10px;\n" +
                        "    }\n" +
                        "\n" +
                        "    .homeSummary{\n" +
                        "        width: 70%;\n" +
                        "    }\n" +
                        "\n" +
                        "    img{\n" +
                        "        height: 100%;\n" +
                        "        width: 100%;\n" +
                        "        object-fit: contain;\n" +
                        "    }\n" +
                        "    .stat{\n" +
                        "        display: flex;\n" +
                        "        width: 65%;\n" +
                        "        justify-content: space-between;\n" +
                        "    }"+
                        "</style>"+


                        "<div class='HomePage'>" +
           "<div class=\"homeParentContainer\">\n" +
                        "        <!-- left side -->\n" +
                        "        <div class=\"leftHomeSide\" >\n" +
                        "            <p class=\"headingOne\">Invest your wealth <br> into your dream <br> property</p>\n" +
                        "            <p class=\"homeSummary\" >We the best property buildings for your future investments, Efficient online platform connecting tenants with landlords for seamless and secure house rentals, streamlining the process.</p>\n" +
                        "            <div class=\"stat\">\n" +
                        "            <div>\n" +
                        "                <p class=\"data\">500+ </p>\n" +
                        "                <p>Happy Clients</p>\n" +
                        "            </div>\n" +
                        "            <div>\n" +
                        "                <p class=\"data\">600+ </p>\n" +
                        "                <p>Successful Trans</p>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "        </div>\n" +
                        "        <!-- right side -->\n" +
                        "        <div class=\"rightHomeSide\" >\n" +
                        "            <img src=\"https://images.unsplash.com/photo-1560185007-5f0bb1866cab?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTA2fHxob3VzZXxlbnwwfHwwfHx8MA%3D%3D\" alt=\"homeImage\">\n" +
                        "        </div>\n" +
                        "    </div>"+

                "</div>");

    }
}
