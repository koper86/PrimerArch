<%--
  Created by IntelliJ IDEA.
  User: piotrk
  Date: 30.05.18
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>PrimerArch - Dodaj nowy primer</title>
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
    <div class="col-md-8 col-md-offset-2">
        <form class="form-signin" method="post" action="new">
            <h2 class="form-signin-heading">Dodaj nowy primer</h2>
            <input name="inputName" type="text" class="form-control" placeholder="nazwa primera"
                   required autofocus />
            <input name="inputUrl" type="url" class="form-control" placeholder="sekwencja 5'-3'"
                   required autofocus />
            <textarea name="inputDescription" rows="5" name="inputUsername"
                      class="form-control" placeholder="opis i powiązania" required autofocus></textarea>
            <input class="btn btn-lg btn-primary btn-block" type="submit"
                   value="Dodaj!" />
        </form>
    </div>
</div>

<footer class="footer">
    <div class="container">
        <p class="navbar-text">PrimerArch - developed by Koper</a></p>
    </div>
</footer>

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</body>
</html>
