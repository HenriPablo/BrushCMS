<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List categories!</h1>
<table>
	<c:forEach items="${albums}" var="a">
		<tr>
			<td>${a.id}</td>
			<td>${a.name}</td>
			<td>${a.description}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/album/edit/${a.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/album/delete/${a.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>