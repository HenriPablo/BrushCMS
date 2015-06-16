<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Category Form!</h1>
<h2>${js_lib}</h2>
<form:form method="post" commandName="category" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">
			ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />

	<label for="category">Category:</label>
	<form:input path="category" size="55" id="category" />
	<br class="separator" /><br />
	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;
	<!--End of each accordion item-->
</form:form>