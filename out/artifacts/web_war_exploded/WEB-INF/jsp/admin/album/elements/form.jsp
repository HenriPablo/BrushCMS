<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>






<style type="text/css">
    #elementNavBar{
        margin: 0 0 20px 0;
    }
    #name{
        width: 100%;
    }

    #description{
        clear: both;
        border: 1px solid #ccc;
        border-radius: 3px;
        width: 100%;
        display: block;
    }
    #btnSave{
        width: 100%;
        margin-left: 0;
    }
</style>


<div class="admin-col-left">


    <form:form method="post" commandName="album" htmlEscape="true"
               action="${pageContext.servletContext.contextPath}${action}">


        <form:hidden path="id" id="id" readonly="true" cssStyle="border:none; background:none;"/>

        <form:select items="${images}" itemLabel="id" itemValue="id" path="images" size="55" id="images"
                     title="select image"/>




        <label for="name">Name:</label>
        <form:input path="name" size="55" id="name"/>
        <br class="separator"/><br/>

        <label for="description">Description:</label>
        <form:textarea path="description" rows="5" cols="35" id="description"/>
        <br class="separator"/><br/>

        <input type="submit" value="Save &amp; Continue Editing" id="btnSave"/>

    </form:form>
</div>

<div class="admin-col-right">
    <div id="elementNavBar">All Available Images:   Not Assigned Albums</div>


    <div id="thums">
        <t:show_image_list images="${images}"/>
    </div>

</div>



<link href="${pageContext.servletContext.contextPath}/js/custom-scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.servletContext.contextPath}/js/custom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript">

    $(document).ready(function () {
        /** HIDE THE DROP DOWN MENU */
        $("#images").css({"visibility": "hidden", "height": "0"});

        /** color containting pix divs if they are on the list of images in the album */
        $('#images > option:selected').each(function () {
            $("#" + $(this).val()).parent().parent().addClass('selected_pix');
            // alert( $(this).text()  + ' ' + $(this).val());
        });


        $("#thums div img").click(function () {

            if (!$(this).parent().parent().hasClass('selected_pix')) {
                $("#images option:contains(" + $(this).attr('id') + ")").attr("selected", "selected");
                //alert( $(this).attr('id') )
                $(this).parent().parent().addClass('selected_pix');
            } else {
                $("#images option:contains(" + $(this).attr('id') + ")").removeAttr("selected");
                $(this).parent().parent().removeClass('selected_pix');

            } // else
            return false;
        });



        $( "#thums" ).mCustomScrollbar({
            autoDraggerLength: true,
            updateOnContentResize: true
        });

    });

</script>