package com.winnie.app.View.css;

import java.io.Serializable;

public class AppCss  implements Serializable {

    private String style = "<style>" +


//           add-house-css
            ".addHouseButton{\n" +
            "        padding: 12px ;\n" +
            "        border-radius: 5px; \n" +
            "        border:none;\n" +
            "        background-color: rgb(10, 79, 182) ;\n" +
            "        color: white;\n" +
            "        cursor: pointer;      \n" +
            "        width: 100px;\n" +
            "        display: flex;\n" +
            "        justify-content: center;\n" +
            "    }\n" +
            "    .addHouseButton a{\n" +
            "        text-decoration: none;\n" +
            "        color: white;\n" +
            "        \n" +
            "    }"+

            //add-tenant-css
            ".addTenantButton{\n" +
                    "        padding: 12px ;\n" +
                    "        border-radius: 5px; \n" +
                    "        border:none;\n" +
                    "        background-color: rgb(10, 79, 182) ;\n" +
                    "        color: white;\n" +
                    "        cursor: pointer;      \n" +
                    "        width: 100px;\n" +
                    "        display: flex;\n" +
                    "        justify-content: center;\n" +
                    "    }\n" +
                    "    .addTenantButton a{\n" +
                    "        text-decoration: none;\n" +
                    "        color: white;\n" +
                    "        \n" +
                    "    }"+
            "  ul.topnav {\n" +
            "      list-style-type: none;\n" +
            "      margin: 0;\n" +
            "      padding: 0;\n" +
            "      overflow: hidden;\n" +
            "      background-color: #333;\n" +
            "    }\n" +
            "\n" +
            "    ul.topnav li { float: left; }\n" +
            "\n" +
            "    ul.topnav li a {\n" +
            "      display: block;\n" +
            "      color: white;\n" +
            "      text-align: center;\n" +
            "      padding: 14px 16px;\n" +
            "      text-decoration: none;\n" +
            "    }\n" +
            "\n" +
            "    ul.topnav li a:hover { background-color: blue; }\n" +
            "\n" +
           /* "    ul.topnav li a.active { background-color: pink; }" +*/
            "        table {\n" +
            "          font-family: arial, sans-serif;\n" +
            "          border-collapse: collapse;\n" +
            "          width: 100%;\n" +
            "        }\n" +
            "\n" +
            "        td, th {\n" +
            "          border: 1px solid #dddddd;\n" +
            "          text-align: left;\n" +
            "          padding: 8px;\n" +
            "        }\n" +
            "\n" +
            "        tr:nth-child(even) {\n" +
            "          background-color: #dddddd;\n" +
            "        }\n" +

            "</style>" ;



    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
