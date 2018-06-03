<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <jsp:include page="fragment/navbar.jspf" />

    <c:if test="${not empty requestScope.primers}">
        <c:forEach var="primer" items="${requestScope.primers}">
            <div class="container">
                <div class="row bs-callout bs-callout-primary">
                    <div class="col col-md-1 col-sm-2">
                        <a href="${pageContext.request.contextPath}/vote?primer_id=${primer.id}&vote=VOTE_UP" class="btn btn-block btn-primary btn-success"><span class="glyphicon glyphicon-arrow-up"></span>  </a>
                        <div class="well well-sm centered"><c:out value="${primer.upVote - primer.downVote}" /></div>
                        <a href="${pageContext.request.contextPath}/vote?primer_id=${primer.id}&vote=VOTE_DOWN"" class="btn btn-block btn-primary btn-warning"><span class="glyphicon glyphicon-arrow-down"></span>  </a>
                    </div>
                    <div class="col col-md-11 col-sm-10">
                        <h3 class="centered"><c:out value="${primer.sequence}" /></h3>
                        <h6><small>Dodane przez: <c:out value="${primer.user.username}" />,
                            Dnia: <fmt:formatDate value="${primer.timestamp}" pattern="dd/MM/YYYY"/></small></h6>
                        <p><c:out value="${primer.description}" /></p>

                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>

  <jsp:include page="fragment/footer.jspf" />
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
  </body>

</html>
