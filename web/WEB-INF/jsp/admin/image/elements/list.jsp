<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
	<c:forEach items="${images}" var="i">
		<tr>
			<td>${i.id}</td>
			<td><img alt="${i.alt}"  src="${pageContext.servletContext.contextPath}/art/upload/thm/${i.src}" /> </td>
			<td>${i.description}</td>
			<td>${i.src}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/image/edit/${i.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/image/delete/${i.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>