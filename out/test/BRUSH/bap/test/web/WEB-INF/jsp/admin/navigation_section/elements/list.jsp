<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div id="elementNavBar"> Order By:</div>


<div id="elementListWrapper">

	<c:forEach items="${navigation_sections}" var="t">

        <div class="elementWrapper">

            <div class="elementDetails">

                <span class="elementId">ID: ${t.id}</span>
                <span class="elementLabel">Label: ${t.label}</span>
                <br />
                <span>Link: ${t.href}</span> &nbsp;&nbsp;&nbsp;&nbsp;
                <span>Nvigation ID: ${t.navigation.id}</span>

            </div>

            <div class="actionLinks">
                <a href="${pageContext.servletContext.contextPath}/admin/navigation_section/edit/${t.id}.html"
                   class="elementEdit brushFont">&#x26;</a>

                <br />

                <a href="${pageContext.servletContext.contextPath}/admin/navigation_section/delete/${t.id}.html"
                   class="elementDelete brushFont">&#xe09f;</a>
            </div>

        </div>

    </c:forEach>

    <div id="paginationBar">First Last</div>

</div>