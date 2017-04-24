<%-- 
    Document   : nav
    Created on : Jun 28, 2010, 2:38:58 PM
    Author     : tomaszbrymora
--%>


<div class="admin-head">
    <!-- Mobile menu toggle button (hamburger/x icon) -->
    <input id="main-menu-state" type="checkbox" />
    <label class="main-menu-btn" for="main-menu-state">
        <span class="main-menu-btn-icon"></span> Toggle main menu visibility
    </label>
    <ul id="main-menu" class="sm sm-simple">
        <%-- NAV GROUP --%>
        <li><a href="#">navigation groups</a>
            <ul class="first-sub-menu">
                <li><a href="${pageContext.servletContext.contextPath}/admin/navigation/new.html">new</a></li>
                <li class="x"><a href="${pageContext.servletContext.contextPath}/admin/navigation/read/list.html">list all</a></li>
            </ul>
        </li>

        <%-- NAV SECTIONS --%>
        <li><a href="#">navigation sections</a>
            <ul class="first-sub-menu">
                <li><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/new.html">new</a></li>
                <li class="x"><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/read/list.html">list all</a></li>
            </ul>
        </li>

        <%-- TAGS --%>
        <li>
            <a href="#">tags</a>
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/tag/new.html">new tag</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/tag/read/list.html">view all</a></li>
            </ul>
        </li>

        <%-- CONTENT PAGES --%>
       <li>
           <a href="#">content pages</a>
            <ul>

                <li><a href="${pageContext.servletContext.contextPath}/admin/content_page/new.html">new</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/content_page/read/list.html">view all
                    pages</a></li>
            </ul>
        </li>


        <%-- ALBUM--%>
        <li>
            <a href="#">albums</a>
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/album/new.html">new album</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/album/read/list.html">view all</a></li>
            </ul>
        </li>


        <%-- IMAGES --%>
        <li>
            <a href="#">images</a>
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/image/upload.html">new mage</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/image/read/list.html">view all</a></li>
            </ul>
        </li>
        <li>
            <a href="#">settings &amp; groups</a>
            <ul>
                <li><a href="#">sessting group</a>
                    <ul>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}/admin/settings_group/read/list.html">list</a>
                        </li>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}/admin/settings_group/new.html">new</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">settings</a>
                    <ul>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}/admin/setting/read/list.html">list</a>
                        </li>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}/admin/setting/new.html">new</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </li>

        <%-- ADMIN HOME --%>
        <li><a href="${pageContext.servletContext.contextPath}/admin/index.html">admin-home</a></li>
        <%-- end ADMIN HOME --%>


        <%-- LOGOUT --%>
        <li><a href="${pageContext.servletContext.contextPath}/logout">log-out</a></li>
        <%-- end LOGOUT --%>

        <%-- HOME --%>
        <li><a href="${pageContext.servletContext.contextPath}/">home</a></li>

    </ul>
</div>
<script>
    $(document).ready( function () {
        $(function() {
            $('#main-menu').smartmenus();
        });
    })
</script>


