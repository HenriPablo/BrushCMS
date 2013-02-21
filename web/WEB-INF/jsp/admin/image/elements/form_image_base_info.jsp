
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	<sf:hidden path="id" />
	<br class="divider" />


	<sf:label path="alt" for="alt">Alt:</sf:label>
	<sf:input path="alt"  id="alt" />

	<sf:hidden path="src"  id="src" />

	<sf:hidden path="width"  id="width" />

	<sf:hidden path="height"  id="height" />

	<sf:label path="description" for="description">Image Description:</sf:label>
	<sf:textarea path="description" id="description" rows="3" cols="35" />
	<br class="divider" />