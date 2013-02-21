<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
$(window).load(function(){
	var disable_form_effects = true;

        var jcrop_api;
        initJcrop();
        function initJcrop()//{{{
        {
          jcrop_api = $.Jcrop('#cropbox',{ onChange: setCoords, onSelect: setCoords });
          jcrop_api.setSelect([10,10,300,300]);
          jcrop_api.setOptions({ allowSelect: true, allowMove: true, allowResize: true/*, aspectRatio: 1*/ });
        }
      });
      function setCoords(c)
      {
        jQuery('#x1').val(c.x);
        jQuery('#y1').val(c.y);
        jQuery('#x2').val(c.x2);
        jQuery('#y2').val(c.y2);
        jQuery('#w').val(c.w);
        jQuery('#h').val(c.h);
      };
</script>
<br  />


	<h6>Image: ${image.src} ID: ${image.id}</h6>
	<img alt="${image.alt}" src="${pageContext.servletContext.contextPath}/art/upload/${image.src}" <%--width="${image.width}" height="${image.height}" --%> id="cropbox" />

<sf:form commandName="image" action="${pageContext.servletContext.contextPath}${action}">
	<table>
		<tr>
			<td>Thumbnail:</td>
			<td><img alt="${image.alt} thymbnail" src="${pageContext.servletContext.contextPath}/art/upload/thm/${image.src}" /></td>
		</tr>



		<tr><td colspan="2">WIDTH: ${image.width} x HEIGTH: ${image.height} </td></tr>
		<tr>
			<td> Make Thumbnail Only: </td>
			<td> <input type="radio" name="crop_option" value="thumbnail_only" checked  /> </td>
		</tr>
		<tr>
			<td> Crop Only: </td>
			<td> <input type="radio" name="crop_option" value="crop_only" /> </td>
		</tr>
		<tr>
			<td> Crop AND Make Thumbnail: </td>
			<td> <input type="radio" name="crop_option" value="crop_and_thumbnail" /> </td>
		</tr>

		<tr>
			<td>Make thumb <input type="text" id="thm_px" name="thm_px" value="50" size="3" /> px </td>
			<td>wide <input type="radio" name="orientation" value="wide" /></td>
		</tr>

		<tr>
			<td></td>
			<td>tall  <input type="radio" name="orientation" value="tall" checked /> </td>
		</tr>
	</table>

	<jsp:include page="form_crop_data.jsp" />

	<jsp:include page="form_image_base_info.jsp" />

	<input type="submit" value="Crop" name="action" />

</sf:form>