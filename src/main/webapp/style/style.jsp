<style>
    /* add-house-css */
    .addHouseButton {
      padding: 12px;
      border-radius: 5px;
      border: none;
      background-color: rgb(10, 79, 182);
      color: white;
      cursor: pointer;
      width: 100px;
      display: flex;
      justify-content: center;
    }

    .addHouseButton a {
      text-decoration: none;
      color: white;
    }

    /* add-tenant-css */
    .addTenantButton {
      padding: 12px;
      border-radius: 5px;
      border: none;
      background-color: rgb(10, 79, 182);
      color: white;
      cursor: pointer;
      width: 100px;
      display: flex;
      justify-content: center;
    }

    .addTenantButton a {
      text-decoration: none;
      color: white;
    }
     /* add-payment-css */
        .addPaymentButton {
          padding: 12px;
          border-radius: 5px;
          border: none;
          background-color: rgb(10, 79, 182);
          color: white;
          cursor: pointer;
          width: 100px;
          display: flex;
          justify-content: center;
        }

        .addPaymentButton a {
          text-decoration: none;
          color: white;
        }

    ul.topnav {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
      background-color: #333;
    }

    ul.topnav li {
      float: left;
    }

    ul.topnav li a {
      display: block;
      color: white;
      text-align: center;
      padding: 14px 16px;
      text-decoration: none;
    }

    ul.topnav li a:hover {
      background-color: blue;
    }

    /* ul.topnav li a.active { background-color: pink; } */

    table {
      font-family: arial, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }

    td, th {
      border: 1px solid #dddddd;
      text-align: left;
      padding: 8px;
    }

    tr:nth-child(even) {
      background-color: #dddddd;
    }

    login css
     /* login-css(from webapp index.jsp) */
    body {
          font-family: Arial, sans-serif;
          text-align: center;
        }

        .login-container {
          background-color: #fff;
          width: 95%;
          margin: 50px auto;
          padding: 20px;
          border-radius: 5px;
          box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);

        }

        h2 {
          color: rgb(1, 69, 171);
          text-align: center;/*added this*/
        }

        form {
          text-align: left;
        }

        input[type="text"],
        input[type="password"] {
          width: 95%;
          padding: 10px;
          margin: 10px 0;
          border: 1px solid #ccc;
          border-radius: 5px;

        }

        input[type="text"]:focus,
        input[type="password"]:focus {
          border-color: rgb(238, 238, 238);
          outline: none;
        }

        input[type="submit"] {
          background-color: rgb(0, 53, 133);
          color: #fff;
          padding: 10px 20px;
          border: none;
          border-radius: 10px;
          cursor: pointer;
        }

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
        <%-- new css interface --%>
  </style>