<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>



    <form:form method="post" commandName="content_page" htmlEscape="true"
               action="${pageContext.servletContext.contextPath}${action}" cssClass="form">

        <div class="admin-col-left">
            ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"/>

                <%--
                    <label for="positionOrder">Nav Menu Position:</label>
                    <form:input path="positionOrder" size="55" id="positionOrder" />
                    <br class="separator" /><br />

                itemValue="${navigation_sections.label}"
                    itemLabel="${navigation_sections.label}"

                --%>

            <label for="navigationSection">Nav Section:</label>


            <form:select items="${navigation_sections}" itemLabel="label" itemValue="id" path="navigationSection"
                         id="navigationSection" cssStyle="width:70%">
            </form:select>

            <br class="separator"/><br/>


            <label for="albums">Albums:</label>
            <form:select items="${available_albums}" itemLabel="name" itemValue="id" path="albums" id="albums">
            </form:select>
            <br class="separator"/><br/>


            <label for="tags">Tags:</label>
            <form:select items="${available_tags}" itemLabel="description" itemValue="id" path="tags"
                         id="tags"></form:select>
            <br class="separator"/><br/>

            <label for="title">Title:</label>
            <form:input path="title" size="55" id="title" cssClass="k-input"/>
            <br class="separator"/><br/>

            <label for="subTitle">Sub Title:</label>
            <form:input path="subTitle" size="55" id="subTitle" cssClass="k-input"/>
            <br class="separator"/><br/>

            <label for="metaDescription">Meta Description:</label>
            <form:input path="metaDescription" size="55" id="metaDescription"/>
            <br class="separator"/><br/>

            <label for="metaKeywords">Meta Keywords:</label>
            <form:input path="metaKeywords" size="55" id="metaKeywords"/>
            <br class="separator"/><br/>
            <label for="linkHref">Article Link:</label>
            <form:input path="linkHref" size="55" id="linkHref"/>
            <br class="separator"/><br/>

            <label for="linkLabel">Link Label:</label>
            <form:input path="linkLabel" size="55" id="linkLabel"/>


            <input type="submit" value="Save &amp; Continue Editing" class="save"/>

            <div class="clarFix"></div>

        </div>

        <div class="admin-col-right">



            <div id="pixThumbs" style="display: none;">
                <c:forEach items="${content_page.albums}" var="a">
                <h2>album</h2>
                        <div>
                            <h3>  ${a.name} </h3>
                            <t:show_album album="${a}"/>
                        </div>

                 </c:forEach>
            </div>




            <form:textarea path="content" rows="75" cols="35" id="content" cssStyle="width: 100%;" htmlEscape="false" />
            <br class="separator"/><br/>

            <%--<div id="editorDiv">${content_page.content}</div>--%>
            <div id="aceEditHideAway" style="display: none;">
                <div id="aceEditWrapper" style="
                    width: 90%;
                    height:90%;
                    padding:2%;
                    /*border: 1px solid red;*/
                    position:relative;
                ">
                   <div id="aceEditControlPanel"
                           style="
                           position: absolute;
                           left: 0;


                           width: 25%;
                           /*border: 1px solid green;*/
                           ">
                       <a href="#" id="clsoeAceEdit">close</a>
                   </div>
                    <div id="aceEditor" style="
                    position: absolute;
                    right: 0;
                    left: 30%;
                    top: 0;
                    bottom: 0;
                    width: 70%;
                    height: 100%;
                    /*border: 1px solid #ffff00;*/

                    ">
                        <h1>some headline</h1>
                    </div>
                </div>
            </div>

            <div id="imageBrowserHideaway" style="display: none;">
                <div id="imageBrowser" style="
                    width: 90%;
                    height: 90%;
                    border: 1px solid #ff8000;
                "></div>
            </div>


            <div class="clarFix"></div>


        </div>
    </form:form>
    <div class="clarFix"></div>
<style type="text/css" media="screen">
    #aceEditor {
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
    }
</style>


<script src="${pageContext.servletContext.contextPath}/js/ace/vendor/modernizr-2.6.2.min.js"></script>


<script src="${pageContext.servletContext.contextPath}/js/ace/plugins.js"></script>

<%--<script src="http://d1n0x3qji82z53.cloudfront.net/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>--%>
<script src="${pageContext.servletContext.contextPath}/js/ace/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/te-editor/jquery-te-1.3.3.js" charset="utf-8"></script>

<%-- JQUERY UI --%>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>

<script>
    var brushAce = ace.edit("aceEditor");
    ace.config.set( "workerPath", "${pageContext.servletContext.contextPath}/js/ace/src-min-noconflict");
    brushAce.setTheme("ace/theme/cobalt");
    brushAce.getSession().setMode("ace/mode/html");


    $('#content').jqte();
</script>


<script type="text/javascript">

    $(document).ready( function(){
 // simple accordion for pix albums


        //$('#pixThumbs').accordion();

    })
</script>

