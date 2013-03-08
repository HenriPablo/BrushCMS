<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="admin-col-single">
    <table class="grid">
        <thead>
        <tr>
            <th>ID</th>
            <th>Label</th>
            <th>settingGroup</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${settingsList}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.label}</td>
                <td>${p.settingsGroup.id}</td>
                <td><a href="${pageContext.servletContext.contextPath}/admin/setting/edit/${p.id}.html" class="edit">edit</a>
                </td>
                <td><a href="${pageContext.servletContext.contextPath}/admin/setting/delete/${p.id}.html"
                       class="delete">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>