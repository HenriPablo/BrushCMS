<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List Navigation Sections</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Lable</th>
            <th>HREF</th>
            <th>NAV</th>
            <th></th>
            <th></th>
        </tr>
    </thead>
	<c:forEach items="${navigation_sections}" var="t">

		<tr>
			<td>${t.id}</td>
			<td>${t.label}</td>
			<td>${t.href}</td>
            <td>${t.navigation.id}</td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/edit/${t.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/delete/${t.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
</table>