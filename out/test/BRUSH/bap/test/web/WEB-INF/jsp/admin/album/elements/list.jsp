<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id="elementNavBar"> Order By:
</div>


<div id="elementListWrapper">

	<c:forEach items="${albums}" var="a">

        <div class="elementWrapper">

            <div class="elementDetails">

                <span class="elementId">ID: ${a.id}</span>
                <span class="elementLabel">Name: ${a.name}</span>
                <br />
                <span>
                        ${a.description}
                </span>


            </div>

            <div class="actionLinks">
                <a href="${pageContext.servletContext.contextPath}/admin/album/edit/${a.id}.html"
                   class="elementEdit brushFont">&#x26;</a>

                <br />

                <a href="${pageContext.servletContext.contextPath}/admin/album/delete/${a.id}.html"
                   class="elementDelete brushFont">&#xe09f;</a>
            </div>


        </div>

	</c:forEach>

    <div id="paginationBar">First Last</div>

</div>







<%--
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
--%>