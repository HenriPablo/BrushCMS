<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<h2>${js_lib}</h2>
<div class="admin-col-single-small">
<form:form method="post" commandName="navigation_section" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">

    <label for="id">ID:</label>
    <form:input path="id" id="id" readonly="true"  />


	<label for="navigation">Navigation</label>
	<form:select items="${all_navigation}" itemLabel="id" itemValue="id"  path="navigation"  id="navigation" >
	</form:select>
	<br class="separator" /><br />

	<%-- LABEL --%>
	<label for="tag">Label:</label>
	<form:input path="label" size="55" id="label" />
	<br class="separator" /><br />


	<%-- HREF--%>
	<label for="tag">Href:</label>
	<form:input path="href" size="55" id="href" />
	<br class="separator" /><br />

	
	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;

</form:form>
    </div>