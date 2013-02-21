<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<%@attribute  name="images" type="java.util.ArrayList" required="false" %>


<div id="thums">
	<c:forEach items="${images}" var="i" >
		<div  class="def_pix">
			<a href="${pageContext.servletContext.contextPath}/art/upload/${i.src}" rel="album1">
			<img alt="${i.alt}" src="${pageContext.servletContext.contextPath}/art/upload/thm/${i.src}" <%--width="${i.width}" height="${i.height}"--%> id="${i.id}" />
			</a>
		</div>
	</c:forEach>
</div>