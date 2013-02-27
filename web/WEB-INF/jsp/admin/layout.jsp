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

        <link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/examples-offline.css" rel="stylesheet">
        <link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo.common.min.css" rel="stylesheet">
        <%--<link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo.default.min.css" rel="stylesheet">--%>
    <%--<link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo.metro.min.css" rel="stylesheet">--%>
    <link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/skin.css" rel="stylesheet">

        <script src="${pageContext.servletContext.contextPath}/js/Kendo-UI/jquery.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo.web.min.js"></script>
        <script src="${pageContext.servletContext.contextPath}/js/Kendo-UI/console.js"></script>
		<%--<script type="text/javascript" src="<c:url value="${js_lib}"/>" ></script>--%>


    <link href="${pageContext.servletContext.contextPath}/js/Kendo-UI/admin-layout.css" rel="stylesheet">
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/admin/elements/nav.jsp" %>

        <div class="admin-body">
		    <jsp:include page="/WEB-INF/jsp/admin/${section}/${page}.jsp"></jsp:include>
        </div>

        <script src="${pageContext.servletContext.contextPath}/js/Kendo-UI/kendo-ui-admin-menu.js"></script>
	</body>
</html>
