<%--
  Created by IntelliJ IDEA.
  User: tomekpilot
  Date: 2/17/13
  Time: 9:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>


<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/rte/rte.css" />

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

   <h2>Settings Group Form</h2>

    <form:form method="post" commandName="settingsGroup" htmlEscape="true" action="${pageContext.servletContext.contextPath}${action}">

        <form:label path="id" for="id" title="id">id</form:label>
        <form:input path="id" id="id" size="5" readonly="true" />

        <form:label path="name" for="name" title="name" >name</form:label>
        <form:input path="name" size="55" id="name" />

        <form:label path="code" for="code" title="code" >code</form:label>
        <form:input path="code" size="55" id="code" />

        <form:select path="children" items="${childrenList}" itemLabel="name" itemValue="id" multiple="false">

        </form:select>

        <br class="separator" /><br />
        <input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;
    </form:form>
