package com.winnie.action;

import com.winnie.app.View.dropdown.HouseTypeDropDown;
import com.winnie.app.View.html.AppPage;
import com.winnie.app.View.html.HtmlComponent;
import com.winnie.app.bean.HouseBean;
import com.winnie.app.bean.HouseBeanI;
import com.winnie.app.bean.TenantBean;
import com.winnie.app.bean.TenantBeanI;
import com.winnie.app.model.entity.House;
import com.winnie.database.Database;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/houses")
public class Houses extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        HttpSession httpSession= req.getSession();

            HouseBeanI housebean = new HouseBean();
            String addHouseButton =
                   "<div class=\"addHouseButton\" >\n" +
                    "            <a href=\"./add\">Add House</a>\n" +
                    "        </div>";

            String availableHouses = "<h2>List of Available Houses</h2>\n" + housebean.listOfHousesAvailable();
            new AppPage().renderHtml(req, resp, 1, addHouseButton + "<br/>"
                    + "<br/>" + availableHouses);

        /*new AppPage().renderHtml(req, resp, 1, availableHouses + "<br/>" + "<br/>" + addHouseButton);
*/

    }




}
