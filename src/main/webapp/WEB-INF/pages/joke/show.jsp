<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../head.jsp" %>
</head>
<body>
<%@include file="../navbar.jsp" %>
<div class="container main">
    <center><h2>${joke.title}</h2></center>
    <center><p>${joke.text}</p></center>
    <center><h3>Feedback</h3></center>
    <form role="form" align="center" method="post" action="<c:url value="/${joke.id}/feedback"/>">
        <div class="form-group">
            <input name="comment" class="form-control" id="exampleInputEmail1" placeholder="Enter comment">
        </div>
        <div class="form-group">
            <select name="assessment" class="form-control">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
            </select>
        </div>
        <button class="btn btn-primary" type="submit">Add comment</button>
    </form>
    <table class="table table-bordered">
        <tr align="center">
            <td><b>Comment</b></td>
            <td><b>Assessment</b></td>
        </tr>
        <c:forEach items="${joke.feedbackList}" var="feedback">
            <tr>
                <td width="45%">${feedback.comment}</td>
                <td align="center">${feedback.assessment}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
