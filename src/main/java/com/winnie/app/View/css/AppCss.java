package com.winnie.app.View.css;

import java.io.Serializable;

public class AppCss  implements Serializable {

    private String style = "<style>" +


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
            "    ul.topnav li a.active { background-color: pink; }" +
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
