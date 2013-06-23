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

    <form:form method="post" commandName="setting" htmlEscape="true" action="${pageContext.servletContext.contextPath}${action}">

        <form:label path="id" for="id" title="id">id</form:label>
        <form:input path="id" id="id" size="5" readonly="true" />
        <br />

        <form:label path="label" for="label" title="name" >name</form:label>
        <form:input path="label" size="55" id="label" />
        <br />


        <form:label path="code" for="code" title="code" >code</form:label>
        <form:input path="code" size="55" id="code" />
        <br />

        <form:label path="hint" for="hint" title="hint" >hint</form:label>
        <form:input path="hint" size="55" id="label" />
        <br />

        <form:label path="value" for="value" title="value">value</form:label>
        <form:input path="value" size="55"  id="value" />
        <br />


        <form:label path="settingsGroup" for="settingsGroup" title="Settings Group">Settigns Group</form:label>
        <form:select path="settingsGroup" items="${settingsGroupList}" itemLabel="name" itemValue="id" multiple="false">

        </form:select>


        <input type="submit" value="Save &amp; Continue Editing" class="save"/>

    </form:form>
</div>