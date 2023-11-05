package com.winnie.app.View.css;

import java.io.Serializable;

public class AppCss  implements Serializable {

    private String style = "<style>" +

            /* Styles for the navigation bar */


    /* Top navigation bar */

//            ".topnav {\n" +
//            "  overflow: hidden;\n" +
//            "  background-color: #333;\n" +
//            "}\n" +
//            "\n" +
//            ".topnav a {\n" +
//            "  float: left;\n" +
//            "  display: block;\n" +
//            "  color: #f2f2f2;\n" +
//            "  text-align: center;\n" +
//            "  padding: 14px 16px;\n" +
//            "  text-decoration: none;\n" +
//            "}\n" +
//            "\n" +
//            ".topnav a:hover {\n" +
//            "  background-color: #ddd;\n" +
//            "  color: black;\n" +
//            "}\n" +
//            "\n" +
//            ".topnav a.active {\n" +
//            "  background-color: #04AA6D;\n" +
//            "  color: white;\n" +
//            "}\n" +
//            "\n" +
//            "/* Dropdown content */\n" +
//            ".dropdown {\n" +
//            "  float: left;\n" +
//            "  overflow: hidden;\n" +
//            "}\n" +
//            "\n" +
//            ".dropdown .dropbtn {\n" +
//            "  font-size: 16px;\n" +
//            "  border: none;\n" +
//            "  outline: none;\n" +
//            "  color: #f2f2f2;\n" +
//            "  padding: 14px 16px;\n" +
//            "  background-color: inherit;\n" +
//            "  font-family: inherit;\n" +
//            "  margin: 0;\n" +
//            "}\n" +
//            "\n" +
//            ".topnav a:hover, .dropdown:hover .dropbtn {\n" +
//            "  background-color: #ddd;\n" +
//            "  color: black;\n" +
//            "}\n" +
//            "\n" +
//            ".dropdown-content {\n" +
//            "  display: none;\n" +
//            "  position: absolute;\n" +
//            "  background-color: #f9f9f9;\n" +
//            "  min-width: 160px;\n" +
//            "  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
//            "  z-index: 1;\n" +
//            "}\n" +
//            "\n" +
//            ".dropdown-content a {\n" +
//            "  float: none;\n" +
//            "  color: black;\n" +
//            "  padding: 12px 16px;\n" +
//            "  text-decoration: none;\n" +
//            "  display: block;\n" +
//            "  text-align: left;\n" +
//            "}\n" +
//            "\n" +
//            ".dropdown-content a:hover {\n" +
//            "  background-color: #ddd;\n" +
//            "}\n" +
//            "\n" +
//            ".dropdown:hover .dropdown-content {\n" +
//            "  display: block;\n" +
//            "}\n" +

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
            "    ul.topnav li a:hover { background-color: #ddd; }\n" +
            "\n" +
            "    ul.topnav li a.active { background-color: #04AA6D; }" +
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
