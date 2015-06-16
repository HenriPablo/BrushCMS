<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">

    .thumbWrapper {
        float: left;
        height: 50px;
        width: 100px;
        overflow: hidden;
    }

</style>

<div id="elementNavBar"> Order By:
</div>


<div id="elementListWrapper">

    <c:forEach items="${content_pages}" var="p">

        <div class="elementWrapper">

            <div class="thumbWrapper">
                <img src="${pageContext.servletContext.contextPath}/art/upload/thm/${p.mainPix.src}"
                     alt="${p.mainPix.alt}"/>
            </div>

            <div class="elementDetails">

                <span class="elementId">ID: ${p.id}</span>
                <span class="elementLabel">Title: ${p.title}</span>
                <br/>

                <span>Modified On: ${ p.modified }</span>
            </div>

            <div class="actionLinks">
                <a href="${pageContext.servletContext.contextPath}/admin/content_page/edit/${p.id}.html" class="elementEdit brushFont">&#x26;</a>
                <br/>
                <a href="${pageContext.servletContext.contextPath}/admin/content_page/delete/${p.id}.html" class="elementDelete brushFont">&#xe09f;</a>
            </div>

        </div>

    </c:forEach>
    <div id="paginationBar">First Last</div>
</div>
