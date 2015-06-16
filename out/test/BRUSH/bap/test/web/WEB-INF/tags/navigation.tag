

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@tag description="render navigation: header or footer as required" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute  name="header_nav" required="true" %>
<%@attribute name="nav_elements" type="java.util.ArrayList"  required="true" %>
<%@attribute name="page_nav_elements" type="java.util.ArrayList"  required="true" %>


<div id="admin_nav" class="">

	<img src="${pageContext.servletContext.contextPath}/art/public_layout/BrushAndPixel_v1.gif" alt="Brush And Pixel" style="vertical-align: middle; float: left; padding-right: 1.5em;" />

	<ul id="menu">
		<li><span style="font-weight: bold; font-size: 38px; color: #ff6600">{</span></li>
		<%-- page nav elements --%>
		<c:forEach var="n" items="${nav_elements}">
			<%--  id is n[0], label is n[1], href is n[2] --%>
			<li class="round_4"><a href="${pageContext.servletContext.contextPath}/${n[2]}.html">${n[1]} </a>

				<%-- NAV SECTIONS --%>
				<ul>
					<c:forEach var="p" items="${page_nav_elements}">
						<c:if test="${n[0] == p[0]}">
							<%--  nav section ID is n[0], page LINK (href) LABEL is p[1], page HREF is p[2] --%>



                                <c:if test="${ n[2] != p[2]}">
                                    <li>
                                        <a href="${pageContext.servletContext.contextPath}/${n[2]}/${p[2]}.html" >${p[1]}</a>
                                    </li>
                                </c:if>



						</c:if>
					</c:forEach>
				</ul>
			</li>
			<%-- END NAV SECTIONS --%>
		</c:forEach>
			<li><a href="${pageContext.servletContext.contextPath}/">home</a></li>
			<li>
			<span style="font-weight: bold; font-size: 38px;  color: #ff6600">}</span>
			</li>
	</ul>
			<div class="separator" style="display: block; clear: both;"></div>
</div>