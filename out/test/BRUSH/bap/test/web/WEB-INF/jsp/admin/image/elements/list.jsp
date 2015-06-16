<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style type="text/css">
    #elementNavBar{
        margin-bottom: 20px;
    }

    #paginationBar{
        margin: 20px 0;
    }

    #pixContainer{
        margin-left: 20px;
        margin-right: 20px;
    }

    .pixWrapper{
        float: left;
        width: 100px;
        height: 200px;
        overflow: hidden;

        margin: 0 10px 10px 0;
        border:1px solid #222;
        background-color: #efefef;
        border-radius: 0px;
        position: relative;
        font-size: 10px;
    }
    .img{
        width: 100px;
        height: 100px;
        overflow: hidden;
        margin: 0 auto;
    }
    .img img{
        display: block;
        margin: 0 auto;
        border:1px solid #000;
    }

    .pixInfo{
        position: relative;
        padding: 5px;
    }

    div.id, div.alt, div.description{
        position: relative;
        clear: both;
    }

    .editBar{
        position: absolute;
        clear:both;
        width: 100%;
        height: 30px;
        clear:both;
        bottom: 0;
        background-color: #c8c8c8;
        border-top:1px solid #222;
    }
    .edit, .delete{
        display: block;
        position: absolute;
        bottom: 0;
        width: 48%;
        text-align: center;
        padding: 5px;
        line-height: 2em;
        vertical-align: middle;
        height: 18px;
        font-weight: bold;
        padding-top:5px;
        text-decoration: none;
    }
    .edit{
        left: 0;
        color: green;
    }
    .delete{
        right: 0;
        color:red;
    }

    #paginationBar{
        margin-left: 20px;
        margin-right:20px;
    }

</style>

<link href="${pageContext.servletContext.contextPath}/js/custom-scrollbar/jquery.mCustomScrollbar.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.servletContext.contextPath}/js/custom-scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>

<div id="elementNavBar"> Order By:</div>


<div id="pixContainer">
	<c:forEach items="${images}" var="i">

		<div class="pixWrapper">

            <div class="img">
                <img alt="${i.alt}"  src="${pageContext.servletContext.contextPath}/art/upload/thm/${i.src}" />
            </div>

            <div class="pixInfo">

                <div class="id">ID: ${i.id}</div>

                <div class="alt">Alt: ${i.alt}</div>

                <div class="description">Des.: ${i.description}</div>

                <%--${i.src}--%>

            </div>

            <div class="editBar">

                <a href="${pageContext.servletContext.contextPath}/admin/image/edit/${i.id}.html" class="edit brushFont">&#x26;</a>
                <a href="${pageContext.servletContext.contextPath}/admin/image/delete/${i.id}.html" class="delete brushFont">&#xe09f;</a>

            </div>

        </div>

	</c:forEach>
</div>

<div id="paginationBar">First Last</div>

<script type="text/javascript">
    $(document).ready( function(){
        $("#pixContainer").mCustomScrollbar();
    });
</script>