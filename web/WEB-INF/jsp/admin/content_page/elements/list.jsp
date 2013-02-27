<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List Content Pages!</h1>
<table class="grid">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Edit</th>
        <th>Delete;</th>
    </tr>
    </thead>

    <tbody>
	<c:forEach items="${content_pages}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.title}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/content_page/edit/${p.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/content_page/delete/${p.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
    </tbody>

</table>