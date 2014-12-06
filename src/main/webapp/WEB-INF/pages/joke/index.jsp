<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <%@include file="../head.jsp" %>
</head>
<body>
<%@include file="../navbar.jsp" %>
<div class="container">
    <div class="main">
        <h1>List of jokes</h1>
    </div>
    <c:if test="${sessionScope.admin != null}">
        <p><a class="btn btn-default" href="<c:url value="/admin/add"/>">Add Joke</a></p>
    </c:if>
    <c:choose>
        <c:when test="${jokes == null || jokes.size() == 0}">
            <h3 align="center">No Jokes</h3>
        </c:when>
        <c:otherwise>
            <%@include file="list.jsp" %>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
