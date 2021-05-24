<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>



<div id="elementNavBar"> Order By: <span>First</span><span>Last</span></div>


<div id="element-list-wrapper" class="row element-list-wrapper">

    <c:forEach items="${content_pages}" var="p">

        <div class="element-wrapper col-md-4">

            <div class="thumb-wrapper">
                <img src="${pageContext.servletContext.contextPath}/art/upload/thm/${p.mainPix.src}"
                     alt="${p.mainPix.alt}"/>
            </div>

            <div class="element-details">
                <div class="elementLabel">Title: ${p.title}</div>
            </div>

            <div class="actions row">
                <div><span class="elementId">ID: ${p.id}</span> Modified On:
                    <fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${ p.modified }" />
                </div>

                <div class="col">
                    <a href="${pageContext.servletContext.contextPath}/admin/content_page/edit/${p.id}.html" class="elementEdit brushFont">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                    </a>
                </div>
                <div class="col">
                    <a href="${pageContext.servletContext.contextPath}/admin/content_page/delete/${p.id}.html" class="elementDelete brushFont">
                        <i class="fa fa-trash" aria-hidden="true"></i>
                    </a>
                </div>
            </div>

        </div>

    </c:forEach>

</div>
