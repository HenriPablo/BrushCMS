<%-- Document   : layout Created on : Jun 18, 2010, 9:14:47 PM Author     : tomekpilot --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="utils" tagdir="/WEB-INF/tags/" %>
<html lang="en">
<head>
    <meta charset="utf-8">

		<title></title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>


    <link href="${pageContext.servletContext.contextPath}/js/admin-utils/admin-layout.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/js/colorbox/colorbox.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/colorbox/jquery.colorbox-min.js" charset="utf-8"></script>



    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/te-editor/jquery-te-1.3.3.css" charset="utf-8" />
    <%-- WEB FONTS --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/admin-utils/brush_font_1/style.css" />




	</head>
	<body>
		<%@include file="/WEB-INF/jsp/admin/elements/nav.jsp" %>

        <div class="admin-body">
		    <jsp:include page="/WEB-INF/jsp/admin/${section}/${page}.jsp"></jsp:include>
        </div>

        <script src="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo-ui-admin-menu.js"></script>
        <script type="text/javascript">

            </script>
	</body>
</html>
