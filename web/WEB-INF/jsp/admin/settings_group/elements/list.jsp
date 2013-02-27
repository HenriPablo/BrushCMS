<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <h1>List Content Pages!</h1>
<table class="grid">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Children</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
	<c:forEach items="${settingsGroupList}" var="p">
		<tr>
			<td>${p.id}</td>
			<td>${p.name}</td>
            <td>
                <ul>
                    <c:forEach items="${p.children}" var="c">
                        <li>ID: ${c.id}<br />NAME: ${c.name}</li>
                    </c:forEach>
                </ul>
            </td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/settings_group/edit/${p.id}.html" class="edit">edit</a></td>
			<td><a href="${pageContext.servletContext.contextPath}/admin/settings_group/delete/${p.id}.html" class="delete">delete</a></td>
		</tr>
	</c:forEach>
    </tbody>
</table>