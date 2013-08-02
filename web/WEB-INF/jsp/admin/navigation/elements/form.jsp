<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Navigation Form!</h1>
<h2>${js_lib}</h2>
<form:form method="post" commandName="navigation" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">
			ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />


	<label for="navigation">Navigation</label>

	<%--<form:select items="${all_navigation}" itemLabel="id" itemValue="id"  path="navigation"  id="navigation" >--%>
	<%--</form:select>--%>

	<br class="separator" /><br />

	<%-- LABEL --%>
	<label for="label">Label:</label>
	<form:input path="label" size="55" id="label" />
	<br class="separator" /><br />


	<%-- HREF--%>
	<label for="code">Code:</label>
	<form:input path="code" size="55" id="code" />
	<br class="separator" /><br />

	
	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;

</form:form>