<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div id="elementNavBar"> Order By:</div>


<div id="elementListWrapper">

	<c:forEach items="${tags}" var="t">

        <div class="elementWrapper">

            <div class="elementDetails">
                <span class="elementId">ID: ${t.id}</span>
			     <span class="elementLabel">Description: ${t.description}</span>
            </div>

            <div class="actionLinks">
			<a href="${pageContext.servletContext.contextPath}/admin/tag/edit/${t.id}.html"
               class="elementEdit brushFont">&#x26;</a>
            <br />
			<a href="${pageContext.servletContext.contextPath}/admin/tag/delete/${t.id}.html"
               class="elementDelete brushFont">&#xe09f;</a>
            </div>

        </div>

	</c:forEach>

    <div id="paginationBar">First Last</div>

</div>