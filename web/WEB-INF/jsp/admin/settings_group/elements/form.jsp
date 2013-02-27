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



<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="admin-col-single">

    <form:form method="post" commandName="settingsGroup" htmlEscape="true" action="${pageContext.servletContext.contextPath}${action}">

        <form:label path="id" for="id" title="id">id</form:label>
        <form:input path="id" id="id" size="5" readonly="true" />
        <br />

        <form:label path="name" for="name" title="name" >name</form:label>
        <form:input path="name" size="55" id="name" />
        <br />

        <form:label path="code" for="code" title="code" >code</form:label>
        <form:input path="code" size="55" id="code" />
        <br />
        <form:select path="children" items="${childrenList}" itemLabel="name" itemValue="id" multiple="true">

        </form:select>


        <input type="submit" value="Save &amp; Continue Editing" class="save"/>

    </form:form>
</div>