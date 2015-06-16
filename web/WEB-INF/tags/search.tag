<%--
    Document   : JQuery Created on :
    Nov 13, 2013, 9:51:07 PM
    Author     : tomaszbrymora
--%>

<%@tag description="Display simple search form" pageEncoding="UTF-8"%>

<form id="searForm" action="${pageContext.servletContext.contextPath}/search.html" method="post">
    <input type="text" name="q" id="q" /><input type="submit" value="search" id="search" />
</form>