<%-- Document   : form_article Created on : Jun 10, 2010, 12:36:04 AM Author     : tomekpilot --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="form-group">
		<form:form method="post" commandName="article" htmlEscape="true"  action="${pageContext.servletContext.contextPath}${action}">

			ID: <form:input path="id" id="id" readonly="true" cssStyle="border:none; background:none;"  />

			<spring:hasBindErrors name="article" >
				<ol>
					<c:forEach items="${errors.allErrors }"var="error">
						<li style="color:#ff3300;">
							<spring:message message="${error}" />
						</li>
					</c:forEach>
				</ol>
				<hr size="1" noshade="noshade" />
			</spring:hasBindErrors>



			<div id="fragment-1" class="form_fragment">
				<label for="Description" class="label">Meta Tag Description:</label>
					<form:textarea path="metaDescription" cols="35" rows="2" id="Description" cssClass="synopsis form-control" />
					<br class="separator" />
					<label for="Keywords">Meta Tag Keywords:</label>
					<form:textarea path="metaKeywords" cols="55" rows="5" id="Keywords" cssClass="sysnopsis form-control" />
			</div>


			<div id="fragment-2" class="form_fragment">

					<label for="Article_Title">Title:</label>
					<form:input path="title" size="55" id="Article_Title" cssClass="form-control"/>


					<br class="separator" />

					<label for="SUBTITLE">Subtitle:</label>
					<form:input path="subTitle" size="55" id="SUBTITLE" cssClass="form-control" />

			</div>



			<div id="fragment-3" class="form_fragment">
					<label for="BODY">Body:</label>
					<form:textarea cols="80" rows="30" path="body" id="body" cssClass="body form-control" />

					<br class="separator" />
					<label for="VIEW_LINK">Link name:</label>
					<form:input path="viewLink" size="30" id="VIEW_LINK" />

					<br class="separator" /><br />
					<form:checkbox path="completion" id="completion" label="Completed" />

					<br class="separator" /><br />
					<form:checkbox path="homePage" id="homePage" label="Show on home page" />

					<br class="separator" /><br />

					<form:checkbox path="allowComments" id="allowComments" label="Allow Comments" />

					<br class="separator" /><br />


					<span style="float: left; margin-bottom: 10px;">Category:</span>
					<form:select path="category"  multiple="false" id="category" cssStyle="float:left; display: inline-block;" >

						<c:forEach  items="${categories}" var="list">
							<option value="<c:out value='${list.id}'/>"
								<c:if test="${list.id eq article.category}">selected="selected"</c:if> >
								<c:out value='${list.category}' /> </option>
						</c:forEach>

					</form:select>


					<br class="separator" /><br />
					<br /><br />
						<hr size="1"/>
					
					<c:if test="${article.tags != null }">
						<h5>tags:</h5>
						<form:checkboxes items="${article.tags}"  itemValue="id" itemLabel="description" path="tags" />
					</c:if>
						<hr size="1"/>
						
					<br class="separator" /><br />


						<h5>ALL tags:</h5>
					<c:forEach items="${all_tags}" var="t">
						<hr size="1"/>
						<form:checkbox path="tags" label="${t.description}" value="${t.id}" />
						<%--
						<c:forEach items="${article.tags}" var="tt">
							<c:if test="${t.id != tt.id }">
								<form:checkbox path="tags" label="${t.description}" value="${t.id}" />
								<h6>not in bound tags</h6>
							</c:if>
						</c:forEach>--%>

						 <%-- <c:out value="${t}" /> --%>
					</c:forEach>
				

					<br class="separator" /><br />
					<input  type="submit" value="Save &amp; Continue Editing" />&nbsp;&nbsp;
					<!--End of each accordion item-->
			</div>
		</form:form>
</div>