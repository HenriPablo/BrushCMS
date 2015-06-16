<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>




<%--<h2>${js_lib}</h2>--%>
<div class="admin-col-single-small">
    <form:form method="post" commandName="tag" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">





                 <form:hidden path="id" id="id" cssStyle="border:none; background:none;"  />

                <label for="tag">Tag:</label>




            <form:input path="description" size="55" id="description" />

            <input  type="submit" value="Save &amp; Continue Editing" />



    </form:form>
</div>