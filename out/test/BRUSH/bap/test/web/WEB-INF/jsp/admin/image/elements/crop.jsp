<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" import="java.util.*" %>

<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/Jcrop/css/jquery.Jcrop.css">
<script src="${pageContext.servletContext.contextPath}/js/Jcrop/js/jquery.Jcrop.min.js"></script>
<script type="text/javascript">
    $(window).load(function () {
        var disable_form_effects = true;

        var jcrop_api;
        initJcrop();
        function initJcrop()//{{{
        {
            jcrop_api = $.Jcrop('#cropbox', { onChange: setCoords, onSelect: setCoords });
            jcrop_api.setSelect([10, 10, 300, 300]);
            jcrop_api.setOptions({ allowSelect: true, allowMove: true, allowResize: true/*, aspectRatio: 1*/ });
        }
    });
    function setCoords(c) {
        jQuery('#x1').val(c.x);
        jQuery('#y1').val(c.y);
        jQuery('#x2').val(c.x2);
        jQuery('#y2').val(c.y2);
        jQuery('#w').val(c.w);
        jQuery('#h').val(c.h);
    }
    ;
</script>


<style type="text/css">
    #imageEditWrapper {
        color: #fff!important;
        background-color: #000;
        position: relative;
        font-size: 10px!important;
    }

    #imageControls {
        float: left;
        width: 8%;
        padding: 20px;
        border-right: 1px solid #666;
        position: absolute;
        top: 0;
        bottom: 0;
    }

    .btnImageMetaData{
        color: #fff;
        border:none;
        border-radius: 4px;
        cursor: pointer;
        padding: 5px 10px;

        background: #7d7e7d; /* Old browsers */
        background: -moz-linear-gradient(top,  #7d7e7d 0%, #0e0e0e 100%); /* FF3.6+ */
        background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#7d7e7d), color-stop(100%,#0e0e0e)); /* Chrome,Safari4+ */
        background: -webkit-linear-gradient(top,  #7d7e7d 0%,#0e0e0e 100%); /* Chrome10+,Safari5.1+ */
        background: -o-linear-gradient(top,  #7d7e7d 0%,#0e0e0e 100%); /* Opera 11.10+ */
        background: -ms-linear-gradient(top,  #7d7e7d 0%,#0e0e0e 100%); /* IE10+ */
        background: linear-gradient(to bottom,  #7d7e7d 0%,#0e0e0e 100%); /* W3C */
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#7d7e7d', endColorstr='#0e0e0e',GradientType=0 ); /* IE6-9 */


    }

    .imageControlSet{
        padding: 0 0 15px 0;
        vertical-align: middle;
    }

    #thmPix {
        width: 20px;
        height: 20px;
        padding: 0;
        vertical-align: middle;
        text-align: center;
        color: #000;
        font-weight: bold;
    }
    #alt, #description{
        width: 88px;
        border: 1px solid #666;
        background-color: #222222;
        padding: 5px;

       color: #fff;
    }

    #btnSave{
        width: 75px;
        margin-left: 0;
        margin-right: 20px;
    }

    .jcrop-holder{
        margin: 0 auto;
    }
    #imageMain {

        float: right;
        width: 88%;
        text-align: center;
        padding: 20px 0 20px 0;

    }
</style>


<div id="imageEditWrapper">
    <sf:form commandName="image" action="${pageContext.servletContext.contextPath}${action}" method="post">


        <div id="imageControls">
            <%--<h6>Image: ${image.src} ID: ${image.id}</h6>--%>

            <div class="imageControlSet">
                <img alt="${image.alt} thymbnail"
                 src="${pageContext.servletContext.contextPath}/art/upload/thm/${image.src}"/>
             </div>


            <div class="imageControlSet">
                <input type="radio" name="cropOption" value="thumbnail_only" checked/>
            Thumb Only
            </div>

            <div class="imageControlSet">
                <input type="radio" name="cropOption" value="crop_only"/>
            Crop Only
            </div>

            <div class="imageControlSet">
                <input type="radio" name="cropOption" value="crop_and_thumbnail"/>
            Crop &amp; Thumb
            </div>

            <%--WIDTH: ${image.width} x HEIGTH: ${image.height}--%>


            <div class="imageControlSet">
                Thumb <input type="text" id="thmPix" name="thmPix" value="50" size="3"/> px
            </div>

            <div class="imageControlSet">
            <input type="radio" name="orientation" value="wide"/>   wide
            </div>

            <div class="imageControlSet">
                <input type="radio" name="orientation" value="tall" checked/>  tall
            </div>

                <div class="imageControlSet">
                     Alt txt:<br />
                    <textarea path="alt" placeholder="Alt Text" name="alt" id="alt" >${image.alt}</textarea>

                </div>

                <div class="imageControlSet">
                    Description:<br />
                    <textarea path="description" rows="3" cols="35"  placeholder="Description" name="description" id="description" >${image.description}</textarea>

                </div>


            <div class="imageControlSet">
                <input type="submit" value="SAVE" name="action" id="btnSave"/>
            </div>

        </div>



        <div id="imageMain">
                <%--We need to prevent caching of the image at all cost, othewise we MIGHT get an error--%>
            <img alt="${image.alt}"
                 src="${pageContext.servletContext.contextPath}/art/upload/${image.src}?<%= new java.util.Date() %>" <%--width="${image.width}" height="${image.height}" --%>
                 id="cropbox"/>

        </div>



        <input type="hidden" name="x1" id="x1"/>
        <input type="hidden" name="y1" id="y1"/>
        <input type="hidden" name="x2" id="x2"/>
        <input type="hidden" name="y2" id="y2"/>
        <input type="hidden" name="w" id="w"/>
        <input type="hidden" name="h" id="h"/>


        <sf:hidden path="id" />

        <sf:hidden path="src"  id="src" />

        <sf:hidden path="width"  id="width" />

        <sf:hidden path="height"  id="height" />



    </sf:form>
    <div class="clearFix"></div>
</div>