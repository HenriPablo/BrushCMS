<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Tag Form!</h1>
<h2>${js_lib}</h2>
<form:form method="post" commandName="tag" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">
			ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />

	<label for="tag">Tag:</label>
	<form:input path="description" size="55" id="description" />
	<br class="separator" /><br />
	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;
	<!--End of each accordion item-->
</form:form>