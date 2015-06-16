<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<style type="text/css">

    #pix{ display:none; }

    #uploadTrigger{
        cursor:pointer;
        margin:20px auto;
        text-align: center;
        padding-left: 0;
        padding-right: 0;
    }

    #console{
        font-weight: bold;
        text-align: center;
        margin-bottom: 20px;
    }



    #uploadTrigger, #alt, #description, #slcAlbums{
        display: block;
        float: none;
        clear: both;

    }

</style>

<div class="admin-col-single-small">

	<sf:form commandName="image" action="${pageContext.servletContext.contextPath}${action}"  enctype="multipart/form-data">
		<div class="lbl_input">

            <h5 id="uploadTrigger" class="upload">Select File to Upload</h5>
            <div id="console">No File Selected</div>


                <input name="pix" id="pix" type="file" size="20" />

                <sf:label path="alt" for="alt">Alt:</sf:label>
                <br />
                <sf:input path="alt"  id="alt" />



                <br class="divider" />

				<sf:hidden path="id" readonly="true" cssClass="id_field"  />


				<sf:label path="description" for="description" >Image Description:</sf:label>
				<br class="divider" />
				<sf:textarea path="description" id="description" rows="3" cols="35" />
				<br class="divider" />
                <sf:label path="albums" for="lbums" id="lblAlbums">Assign to Album(s):</sf:label>

                <sf:select items="${albumy}" itemLabel="name" itemValue="id" path="albums" id="slcAlbums" />

                <br class="divider" />

				<input type="submit" value="UPLOAD" id="btnUpload">
			</div>

	</sf:form>

</div>

<script type="text/javascript">
    $(document).ready( function(){

        $("#uploadTrigger").on('click', function(){

            $("#pix").trigger('click' );
            $( "#pix" ).change( function(){
                $("#console").text("File to upload: " + $(this).val() );
            });

        });

    });

</script>