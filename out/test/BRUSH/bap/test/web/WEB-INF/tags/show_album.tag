<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%@attribute name="message" required="false"%>

<%@attribute  name="album" type="bap.domain.Album" required="false" %>


<div class="thumbs">
	<c:forEach items="${album.images}" var="i" >
		<div  class="pixThumbLinkWrapper">
			<a href="${pageContext.servletContext.contextPath}/art/upload/${i.src}" rel="album1" class="pixThumbLink">
			    <img alt="${i.alt}" src="${pageContext.servletContext.contextPath}/art/upload/thm/${i.src}" <%--width="${i.width}" height="${i.height}"--%> id="${i.id}" class="pixThumbImg" />
			</a>
		</div>
	</c:forEach>
</div>

