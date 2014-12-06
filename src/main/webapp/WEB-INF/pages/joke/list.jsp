<table class="table table-striped">
    <tr align="center">
        <td><b>#</b></td>
        <td><b>Title</b></td>
        <td><b>Avg. assessment</b></td>
        <td><b>Comments</b></td>
        <td><b>Action</b></td>
    </tr>
    <c:forEach items="${jokes}" var="joke" varStatus="i">
        <tr align="center">
            <td align="center">${i.index + 1}</td>
            <td>${joke.title}</td>
            <td><fmt:formatNumber pattern="#0.00" value="${joke.averageAssessment}"/></td>
            <td>${joke.numberOfComments}</td>
            <td align="center"><a href="<c:url value="/jokes/${joke.id}"/>" class="btn primary-btm">Show</a></td>
        </tr>
    </c:forEach>
</table>