<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib  tagdir="/WEB-INF/tags/" prefix="t" %>

<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/selectList/css/selectlist.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/admin/css.css" />
<style type="text/css">
body, textarea {
    font-family:sans-serif;
    font-size:12px;
}
</style>

<h1>Album Form!</h1>


<div id="thums" style="border: 1px solid #666; padding: 8px 8px 8px 8px; background-color: #666;
     border-radius: 8px; -moz-border-radius: 8px;
     ">
	<t:show_image_list images="${images}" />
</div>

<form:form method="post" commandName="album" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">


    ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />

	<form:select items="${images}" itemLabel="id" itemValue="id"  path="images" size="55" id="images" title="select image" />
	<br class="separator" /><br />
	

	<label for="name">Name:</label>
	<form:input path="name" size="55" id="name" />
	<br class="separator" /><br />

	<label for="description">Description:</label>
	<form:input path="description" size="55" id="description" />
	<br class="separator" /><br />

	<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;

</form:form>



	<script type="text/javascript">

		$(document).ready(function(){
			/** HIDE THE DROP DOWN MENU */
			$("#images").css({"visibility": "hidden", "height":"0"});

			/** color containting pix divs if they are on the list of images in the album */
				 $('#images > option:selected' ).each(function(){
					 $("#" + $(this).val()  ).parent().parent().addClass('selected_pix')
					// alert( $(this).text()  + ' ' + $(this).val());
				 });


			$("#thums div img").click(function(){

				if( !$(this).parent().parent().hasClass('selected_pix') ) {
					$("#images option:contains("+ $(this).attr('id') + ")").attr("selected", "selected")
					  //alert( $(this).attr('id') )
					  $(this).parent().parent().addClass( 'selected_pix' );
				} else {
					$("#images option:contains("+ $(this).attr('id') + ")").removeAttr("selected")
					  $(this).parent().parent().removeClass( 'selected_pix' );

				} // else
				return false;
			})

		})

	</script>