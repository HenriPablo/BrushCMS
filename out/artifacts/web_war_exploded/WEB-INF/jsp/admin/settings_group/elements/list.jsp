<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="elementNavBar"> Order By:</div>


<div id="elementListWrapper">

    <c:forEach items="${settingsGroupList}" var="p">

        <div class="elementWrapper">

            <div class="elementDetails">
                <span class="elementId">ID: ${p.id}</span>
                <span class="elementLabel">Name: ${p.name}</span>


                <ul style="width: 150px;">
                    <c:forEach items="${p.children}" var="c">
                        <li>ID: ${c.id}<br/>NAME: ${c.name}</li>
                    </c:forEach>
                </ul>

            </div>

            <div class="actionLinks">
                <a href="${pageContext.servletContext.contextPath}/admin/settings_group/edit/${p.id}.html"
                       class="elementEdit brushFont">&#x26;</a>
                <br />
                <a href="${pageContext.servletContext.contextPath}/admin/settings_group/delete/${p.id}.html"
                       class="elementDelete brushFont">&#xe09f;</a>
            </div>
        </div>
    </c:forEach>

    <div id="paginationBar">First Last</div>
</div>