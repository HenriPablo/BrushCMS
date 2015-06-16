<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="admin-col-single">

    <div id="elementNavBar"> Order By:
    </div>


<div id="elementListWrapper">

    <c:forEach items="${settingsList}" var="p">
        <div class="elementWrapper">

            <div class="elementDetails">

                <span class="elementId">ID: ${p.id}</span>
                <span class="elementLabel">Label: ${p.label}</span>
                <br />
                <span>Settings Group ID: ${p.settingsGroup.id}</span>
            </div>



            <div class="actionLinks">
                <a href="${pageContext.servletContext.contextPath}/admin/setting/edit/${p.id}.html" class="elementEdit brushFont">&#x26;</a>
                <br />
                <a href="${pageContext.servletContext.contextPath}/admin/setting/delete/${p.id}.html" class="elementDelete brushFont">&#xe09f;</a>
            </div>

        </div>
    </c:forEach>
    <div id="paginationBar">First Last</div>
</div>




 <%--
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
    --%>
</div>