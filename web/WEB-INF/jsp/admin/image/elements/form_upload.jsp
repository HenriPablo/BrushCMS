<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div id="form_container">

	<sf:form commandName="image" action="${pageContext.servletContext.contextPath}${action}"  enctype="multipart/form-data">
		<div class="lbl_input">

			<div class="lbl">

				<sf:label path="id" for="id" cssClass="id_lbl">id:</sf:label>
				<sf:input path="id" readonly="true" cssClass="id_field"  />
				<br class="divider" />

				<sf:select items="${albumy}" itemLabel="name" itemValue="id" path="albums" />

				<input name="pix" type="file" size="20" />

				<sf:label path="alt" for="alt">Alt:</sf:label>
				<sf:input path="alt"  id="alt" />
				<br class="divider" />

				<sf:label path="description" for="description">Image Description:</sf:label>
				<br class="divider" />
				<sf:textarea path="description" id="description" rows="3" cols="35" />
				<br class="divider" />

				<input type="submit" value="UPLOAD">
			</div>

		</div>
	</sf:form>

</div>

