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

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

    <%--START Bootstrap Main Nav --%>
    <!-- Latest compiled and minified CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


    <link href="${pageContext.servletContext.contextPath}/css/admin/admin-layout.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="${pageContext.servletContext.contextPath}/js/smartmenus/css/sm-core-css.css" rel="stylesheet" />
    <link href="${pageContext.servletContext.contextPath}/js/smartmenus/css/sm-simple/sm-simple.css" rel="stylesheet"/>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/smartmenus/jquery.smartmenus.min.js"></script>

    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/smartmenus/addons/bootstrap-4/jquery.smartmenus.bootstrap-4.min.js"></script>
    <link href="${pageContext.servletContext.contextPath}/js/smartmenus/addons/bootstrap-4/jquery.smartmenus.bootstrap-4.css" rel="stylesheet"/>

    <%--END Bootstrap Main Nav --%>



    <link href="${pageContext.servletContext.contextPath}/js/colorbox/colorbox.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/colorbox/jquery.colorbox-min.js" charset="utf-8"></script>



    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/te-editor/jquery-te-1.3.3.css" charset="utf-8" />
    <%-- WEB FONTS --%>
    <link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/admin-utils/brush_font_1/style.css" />
<%--    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin-utils/menu.js"></script>--%>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin/breadcrumbs.js"></script>



	</head>
	<body>

        <div class="admin-body container">
            <%@include file="/WEB-INF/jsp/admin/elements/nav.jsp" %>
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
