<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List Navigation</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Lable</th>
            <th>Code</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
	<c:forEach items="${navigation}" var="t">

		<tr>
			<td>${t.id}</td>
			<td>${t.label}</td>
			<td>${t.code}</td>

			<td><a href="${pageContext.servletContext.contextPath}/admin/navigation/edit/${t.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/navigation/delete/${t.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>