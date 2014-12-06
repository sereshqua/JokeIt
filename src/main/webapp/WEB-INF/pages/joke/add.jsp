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
        <h1>Add joke</h1>
    </div>
    <form role="form" method="post" action="<c:url value="/admin/save"/>">
        <div class="form-group">
            <label for="title">Title</label>
            <input name="title" type="text" class="form-control" id="title" placeholder="Enter title">
        </div>
        <div class="form-group">
            <label for="text">Text</label>
            <textarea name="text" class="form-control" id="text" placeholder="Enter text"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>
</body>
</html>
