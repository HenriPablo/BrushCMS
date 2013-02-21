<%-- 
    Document   : nav
    Created on : Jun 28, 2010, 2:38:58 PM
    Author     : tomaszbrymora
--%>
		<div id="admin_nav" class="gr_dkBlu_dkBlue round_bottm">
			<ul class="dropdown">

				<%-- NAV SECTIONS --%>
				<li class="round_4"><a href="#">navigation sections</a>
					<ul class="sub_menu">
						<li><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/new.html">new</a></li>
						<li><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/read/list.html">list all</a></li>
					</ul>
				</li>
				<%-- end CATEGORIES --%>

				<%-- TAGS --%>
				<li class="round_4"><a href="#">tags</a>
					<ul class="sub_menu">
						<li><a href="${pageContext.servletContext.contextPath}/admin/tag/new.html">new tag</a></li>
						<li class="round_bottom" ><a href="${pageContext.servletContext.contextPath}/admin/tag/read/list.html">view all</a></li>
					</ul>
				</li>
				<%-- end TAGS --%>

				<%-- CONTENT PAGES --%>
				<li class="round_4"><a href="#" >content pages</a>
					<ul class="sub_menu">

						<li><a href="${pageContext.servletContext.contextPath}/admin/content_page/new.html">new</a></li>
						<li class="round_bottom"><a href="${pageContext.servletContext.contextPath}/admin/content_page/read/list.html">view all pages</a></li>
					</ul>
				</li>
				<%-- end CONTENT PAGES --%>

				<%-- ALBUM--%>
				<li class="round_top"><a href="#">albums</a>
					<ul class="sub_menu">
						<li><a href="${pageContext.servletContext.contextPath}/admin/album/new.html">new album</a></li>
						<li class="round_bottom"><a href="${pageContext.servletContext.contextPath}/admin/album/read/list.html">view all</a></li>
					</ul>
				</li>
				<%-- end ALBUM --%>

				<%-- IMAGES --%>
				<li class="round_top"><a href="#">images</a>
					<ul class="sub_menu">
						<li><a href="${pageContext.servletContext.contextPath}/admin/image/upload.html">new mage</a></li>
						<li class="round_bottom"><a href="${pageContext.servletContext.contextPath}/admin/image/read/list.html">view all</a></li>
					</ul>
				</li>
				<%-- end IMAGES --%>	

				<%-- ADMIN HOME --%>
				<li class="round_4"><a href="${pageContext.servletContext.contextPath}/admin/index.html">admin-home</a> </li>
				<%-- end ADMIN HOME --%>


				<%-- LOGOUT --%>
				<li class="round_4"><a href="${pageContext.servletContext.contextPath}/logout">log-out</a> </li>
				<%-- end LOGOUT --%>

				<%-- HOME --%>
				<li class="round_4"><a href="${pageContext.servletContext.contextPath}/">home</a> </li>
				<%-- end HOME --%>
			</ul>
			<div class="separator" style="display: block; clear: both;"></div>
		</div>