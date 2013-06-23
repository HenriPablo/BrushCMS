<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="t" %>

<%@ page import="java.net.URLDecoder"%>




    <form:form method="post" commandName="content_page" htmlEscape="true" id="layoutForm"
               action="${pageContext.servletContext.contextPath}${action}" cssClass="form">

        <div class="admin-col-left">
             <form:hidden  path="id" id="id" />

                <%--
                    <label for="positionOrder">Nav Menu Position:</label>
                    <form:input path="positionOrder" size="55" id="positionOrder" />
                    <br class="separator" /><br />

                itemValue="${navigation_sections.label}"
                    itemLabel="${navigation_sections.label}"

                --%>

            <label for="navigationSection">Nav Section:</label>


            <form:select items="${navigation_sections}" itemLabel="label" itemValue="id" path="navigationSection"
                         id="navigationSection">
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


            <input type="submit" value="Save &amp; Continue Editing" class="save articleSave"/>

            <div class="clearFix"></div>

        </div>

        <div class="admin-col-right">


            <div id="pixControlPanel">
                <p id="albumsTab"  class="controlTab show" data-show-or-hide="pixes">Albums: <span class="pixThumbAlbumCount">${content_page.albums.size() }</span></p>
                <p id="mainPixTab" class="controlTab show" data-show-or-hide="mainPix">Main Pix:${content_page.mainPix.id} <span>none</span></p>
                <span id="mainPixAjaxResponse"></span>
                <div class="clearFix"></div>
            </div>

            <div id="pixes" class="contentPanel closed">

                <c:forEach items="${content_page.albums}" var="a">
                        <div class="pixThumbsAlbumWrapper">
                            <p class="pixThumbsAlbumName">  ${a.name} </p>
                            <t:show_album album="${a}"/>
                        </div>

                 </c:forEach>
                <div class="clearFix"></div>
            </div>



            <div id="mainPix" class="contentPanel closed">

                <div id="thumbsToChooseFrom" style="float:left;">

                </div>

                <div id="draggableTargetWrapper" style="float: right; border-left:1px solid #ccc; padding: 10px; min-width: 150px;" >
                    <p>Drag main pix selection here.</p>
                    <div id="draggableTarget" style="min-height: 120px; border: 1px solid #006f1c; text-align: center; padding:10px; background-color: #fff;" >
                        <c:if test="${content_page.mainPix != null}">
                            <img src="<c:url value="/art/upload/thm/${content_page.mainPix.src}" />" />
                        </c:if>
                    </div>
                    <div id="removeMainPix">---x---</div>
                    <form:hidden path="mainPix.id" id="mainPixId" />
                </div>
                <div class="clearFix"></div>

            </div>


            <br class="separator"/><br/>



            <form:textarea path="content" rows="75" cols="35" id="content" cssStyle="width: 100%;" htmlEscape="false"  />
            <br class="separator"/><br/>



            <jsp:include page="aceEditPanel.jsp" />


            <jsp:include page="imageBrowserPanel.jsp" />


            <div class="clearFix"></div>


        </div>
    </form:form>




<script src="${pageContext.servletContext.contextPath}/js/ace/vendor/modernizr-2.6.2.min.js"></script>


<script src="${pageContext.servletContext.contextPath}/js/ace/plugins.js"></script>

<%--<script src="http://d1n0x3qji82z53.cloudfront.net/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>--%>
<script src="${pageContext.servletContext.contextPath}/js/ace/src-min-noconflict/ace.js" type="text/javascript" charset="utf-8"></script>


<%-- JQUERY UI --%>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>


<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/te-editor/jquery-te-1.3.3.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/admin-utils/content_page.js" charset="utf-8"></script>