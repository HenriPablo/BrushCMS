<%-- Document   : layout Created on : Jun 18, 2010, 9:14:47 PM Author     : tomekpilot --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="utils" tagdir="/WEB-INF/tags/" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="nav" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>${page_contents.title}</title>



		<link rel="stylesheet" href="<c:url value="/css/public/css.css"/>" type="text/css" media="screen" />
        <link rel="stylesheet" href="<c:url value="/css/public/nav.css"/>" type="text/css" media="screen" />


		<utils:JQuery />
	</head>
	<body>

<nav:navigation header_nav="true"  nav_elements="${nav_elements}" page_nav_elements="${page_nav_elements}" />

<h3>LAYOUT JSP</H3>
<hr/>

        <c:choose>

            <%-- we have a SECTION and PAGE--%>
            <c:when test="${ (not empty page) && (not empty layout) }">
                <h3>we have a LAYOUT ${layout } and PAGE: ${page}</h3>
                <%--<jsp:include page="/WEB-INF/jsp/public/${section}/${page}.jsp"></jsp:include>--%>
                <jsp:include page="/WEB-INF/jsp/public/layouts/${layout}/${page}.jsp"></jsp:include>
            </c:when>

            <c:when test="${not empty page_contents}">
                <h3>we have some page contents:</h3>
                <p>${page_contents.content}</p>
            </c:when>


            <%-- we have a page only--%>
            <c:when test="${ ( empty layout ) && ( not empty page ) }">
                <h3>we have a page: ${page} and no layout</h3>
            </c:when>

            <c:when test="${not empty layout && empty page}">
                <h3>we have a layout: ${layout}, NO page</h3>
            </c:when>

            <c:otherwise>
                <h3>no section and no page contents </h3>
            </c:otherwise>

        </c:choose>


		<%--<script type="text/javascript">--%>
			<%--$(document).ready(function(){--%>

				<%--/* MAIN NAV MENU */--%>

				<%--$("ul.dropdown li").hover(function(){--%>

					<%--$(this).addClass("hover");--%>
					<%--$('ul:first',this).css('visibility', 'visible');--%>

				<%--}, function(){--%>

					<%--$(this).removeClass("hover");--%>
					<%--$('ul:first',this).css('visibility', 'hidden');--%>

				<%--});--%>

				<%--$("ul.dropdown li ul li:has(ul)").find("a:first").append(" &raquo; ");--%>

				<%--/*$("div.stuff").click(--%>
					<%--function(){--%>
						<%--alert('hi');--%>
						<%--//$(this).next(toggle());--%>
						<%--}--%>
					<%--)--%>
				 <%--*/--%>
				<%--/* HIDE AND SHOW TEXT AREAS */--%>
				<%--if( disable_form_effects == false ) {--%>
				<%--$("label").next().hide();--%>

				<%--$("label", this ).bind( 'click', (function(){--%>
					<%--$(this).next( ).toggle();--%>
				<%--}));--%>
				<%--}--%>



			<%--});--%>
		<%--</script>--%>
	</body>
</html>
