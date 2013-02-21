<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<h1>Comment Form!</h1>
<h2>${js_lib}</h2>
<form:form method="post" commandName="comment" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">
			ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />


	<label for="commenter">Name:</label>
	<form:input path="commenter" id="commenter" />
	<br class="separator" /><br />


	<label for="email">Email:</label>
	<form:input path="email" id="email" />
	<br class="separator" /><br />

	<label for="website" >Website:</label>
	<form:input path="website" id="website" />
	<br class="separator" /><br />


	<label for="body">Comment:</label>
	<form:input path="body" size="55" id="body" />
	<br class="separator" /><br />

	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;
	<!--End of each accordion item-->
</form:form>