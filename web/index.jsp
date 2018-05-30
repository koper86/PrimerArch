<%--
  Created by IntelliJ IDEA.
  User: piotrk
  Date: 30.05.18
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>PrimerArch</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">
  </head>
  <body>
    <nav class = "navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <a href="#" class="navbar-brand">PrimerArch</a>

        <button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse">
          <span class="glyphicon glyphicon-list"></span>
        </button>

        <div class="collapse navbar-collapse navHeaderCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="#">Główna</a></li>
            <li><a href="#">Dodaj</a></li>
            <li><a href="#">Zaloguj się</a></li>
          </ul>
        </div>

      </div>
    </nav>

    <div class="container">
        <!-- poczatek jednego wiersza -->
        <div class="row bs-callout bs-callout-primary">
            <div class="col col-md-1 col-sm-2">
                <!-- Kolumna głosowania -->
                <a href="#" class="btn btn-block btn-primary btn-success"><span class="glyphicon glyphicon-arrow-up"></span>  </a>
                <div class="well well-sm centered">12</div>
                <a href="#" class="btn btn-block btn-primary btn-warning"><span class="glyphicon glyphicon-arrow-down"></span>  </a>
            </div>
            <div class="col col-md-11 col-sm-10">
                <!-- Kolumna z treścią -->
                <h3 class="centered"><a href="#">Primer</a></h3>
                <h6><small>Dodane przez: Mietek, Dnia: 01 styczeń 2015</small></h6>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                <button class="btn btn-default btn-xs">Przejdź do strony</button>
            </div>
        </div>
        <!-- koniec jednegi wiersza-->
    </div>

    <footer class="footer">
      <div class="container">
        <p class="navbar-text">PrimerArch - developed by Koper></p>
      </div>
    </footer>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
  </body>

</html>