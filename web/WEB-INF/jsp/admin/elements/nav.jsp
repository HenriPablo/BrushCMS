<%-- 
    Document   : nav
    Created on : Jun 28, 2010, 2:38:58 PM
    Author     : tomaszbrymora
--%>
 <style>
     #menu{
         height: 45px;
     }

     ul#menu li{
         font-weight: bold;
         letter-spacing: 1px;
         height: 35px; 
         padding-top:10px;
     }

     ul#menu li ul{
         height: auto;
     }

     ul#menu li ul li{
         font-weight: normal;
         letter-spacing: normal;
         height: auto;
         padding-top: 0;
     }
 </style>

<div class="admin-head">
    <ul id="menu">
        <li > <%-- NAV SECTIONS --%>
            navigation sections
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/new.html">new</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/navigation_section/read/list.html">list
                    all</a></li>
            </ul>
        </li>

        <%-- TAGS --%>
        <li>
            tags
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/tag/new.html">new tag</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/tag/read/list.html">view all</a></li>
            </ul>
        </li>

        <%-- CONTENT PAGES --%>
       <li>
            content pages
            <ul>

                <li><a href="${pageContext.servletContext.contextPath}/admin/content_page/new.html">new</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/content_page/read/list.html">view all
                    pages</a></li>
            </ul>
        </li>


        <%-- ALBUM--%>
        <li>
            albums
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/album/new.html">new album</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/album/read/list.html">view all</a></li>
            </ul>
        </li>


        <%-- IMAGES --%>
        <li>
            images
            <ul>
                <li><a href="${pageContext.servletContext.contextPath}/admin/image/upload.html">new mage</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/admin/image/read/list.html">view all</a></li>
            </ul>
        </li>
        <li>
            settings &amp; groups
            <ul>
                <li>sessting group
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
                    settings
                    <ul>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}">list</a>
                        </li>
                        <li>
                            <a href="${pageContext.servletContext.contextPath}">new</a>
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


