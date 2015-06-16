<%-- 
    Document   : public_content_page
    Created on : Feb 17, 2011, 4:07:20 PM
    Author     : tomaszbrymora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<div style="
    border: 1px solid #dd4800
    ;
">
    <h1>${ page_contents.title}</h1>

    <div class="content">
        ${page_contents.content}
    </div>
</div>

</body>
</html>
