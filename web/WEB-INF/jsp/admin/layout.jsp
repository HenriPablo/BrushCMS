<%-- Document   : layout Created on : Jun 18, 2010, 9:14:47 PM Author     : tomekpilot --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="utils" tagdir="/WEB-INF/tags/" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>

		<link rel="stylesheet" href="<c:url value="/css/css.css"/>" type="text/css" media="screen" />
		<link rel="stylesheet" href="<c:url value="/css/admin/css.css"/>" type="text/css" media="screen" />
		<link rel="stylesheet" href="<c:url value="${css}" />" type="text/css" media="screen" />

		<utils:JQuery />

		<script type="text/javascript" src="<c:url value="${js_lib}"/>" ></script>
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/admin/elements/nav.jsp" %>


		<jsp:include page="/WEB-INF/jsp/admin/${section}/${page}.jsp"></jsp:include>
		<script type="text/javascript">
			$(document).ready(function(){

				/* MAIN NAV MENU */

				$("ul.dropdown li").hover(function(){

					$(this).addClass("hover");
					$('ul:first',this).css('visibility', 'visible');

				}, function(){

					$(this).removeClass("hover");
					$('ul:first',this).css('visibility', 'hidden');

				});

				$("ul.dropdown li ul li:has(ul)").find("a:first").append(" &raquo; ");

				/*$("div.stuff").click(
					function(){
						alert('hi');
						//$(this).next(toggle());
						}
					)
				 */
				/* HIDE AND SHOW TEXT AREAS */
				if( disable_form_effects == false ) {
				$("label").next().hide();
				
				$("label", this ).bind( 'click', (function(){
					$(this).next( ).toggle();
				}));
				}



			});
		</script>
	</body>
</html>
