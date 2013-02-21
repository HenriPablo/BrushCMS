<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List Comments!</h1>
<table>
	<c:forEach items="${comments}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.body}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/comment/edit/${c.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/comment/delete/${c.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>