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


    <%--START Bootstrap--%>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <%--END Bootstrap--%>

    <link href="${pageContext.servletContext.contextPath}/js/admin-utils/admin-layout.css" rel="stylesheet">

    <link href="${pageContext.servletContext.contextPath}/js/colorbox/colorbox.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/colorbox/jquery.colorbox-min.js" charset="utf-8"></script>



    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/te-editor/jquery-te-1.3.3.css" charset="utf-8" />
    <%-- WEB FONTS --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/admin-utils/brush_font_1/style.css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin-utils/menu.js"></script>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin/breadcrumbs.js"></script>



	</head>
	<body>
		<%@include file="/WEB-INF/jsp/admin/elements/nav.jsp" %>

        <div class="admin-body">
            <div id="breadcrumbs">
                <%--<div class="crumb">--%>
                    <%--ID: <span id="pageId">${content_page.id}</span> &gt;--%>
                <%--</div>--%>
            </div>

		    <jsp:include page="/WEB-INF/jsp/admin/${section}/${page}.jsp"></jsp:include>


            <div class="clearFix"></div>
        </div>



	</body>
</html>
