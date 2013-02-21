<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List categories!</h1>
<table>
	<c:forEach items="${tags}" var="t">
		<tr>
			<td>${t.id}</td>
			<td>${t.description}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/tag/edit/${t.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/tag/delete/${t.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>