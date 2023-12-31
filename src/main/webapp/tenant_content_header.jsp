<%@ page isELIgnored="false" %>
<%@ page import="com.winnie.listeners.SessionListener" %>
<!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link href="images/logo.png" rel="icon" />
      <title>Rental Management System</title>
      <!-- Bootstrap -->
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/style.css" rel="stylesheet">
      <script src="js/jquery.js"></script>
      <script type="text/javascript">
          $(document).ready(function () {
              $('#panelBodyItemlist').show();
              $('.panelBodyItem li:first-child a').addClass('active');
              $('.panelBodyItem li a').click(function (e) {
                  var tabDiv = this.hash;
                  $('.panelBodyItem li a').removeClass('active');
                  $(this).addClass('.active');
                  $('.switchgroup').hide();
                  $(tabDiv).fadeIn();
                  e.preventDefault();
              });
          });
      </script>
    </head>
    <body>
      <div class="container-fluid">
          <!--- Header Start -------->
          <div class="row header">
              <div class="col-md-10">
                  <div class="navbar-header">
                      <a class="navbar-brand logo" href="#">
                          <img alt="Logo" src="images/logo.png">
                      </a>
                      <div class="navbar-text title">
                          <p>Rental Management System</p>
                      </div>
                  </div>
              </div>
              <div class="col-md-2 ">
                  <ul class="nav nav-pills ">
                      <li class="dropdown dmenu">
                          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                              aria-expanded="false">${sessionScope.username}<span class="caret"></span>
                          </a>
                          <ul class="dropdown-menu ">
                              <li><a href="./profile">Change Profile</a></li>
                              <li role="separator" class="divider"></li>
                              <li><a href="./logout">Logout</a></li>
                          </ul>
                      </li>
                  </ul>
              </div>
          </div>
          <!--- Header Ends --------->