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

            <ul id="panelBar">
                <li>
                    <span style="color: #fff!important;">Album Images:</span>

                    <c:forEach items="${content_page.albums}" var="a">
                        <ul>
                            <li>
                                <t:show_album album="${a}"/>
                            </li>
                        </ul>
                    </c:forEach>

                </li>
            </ul>


            <label for="content" class="admin-editor-area-label" >Content:</label>
            <form:textarea path="content" rows="8" cols="35" id="content" cssStyle="width: 100%"/>
            <br class="separator"/><br/>



            <div class="clarFix"></div>


        </div>
    </form:form>
    <div class="clarFix"></div>
