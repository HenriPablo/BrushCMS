<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List categories!</h1>
<table>
	<c:forEach items="${categories}" var="c">
		<tr>
			<td>${c.id}</td>
			<td>${c.category}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/category/edit/${c.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/category/delete/${c.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>