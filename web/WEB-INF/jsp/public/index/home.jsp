<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  tagdir="/WEB-INF/tags/" prefix="t" %>

<h1>${latest_article.title}</h1>
<div class="content">
	${latest_article.content}
</div>

<%-- <c:forEach items="${latest_article.albums}" var="a"> <t:show_album album="${a}" /> </c:forEach> --%>

<link media="screen" rel="stylesheet" href="js/colorbox/colorbox.css" />

<script src="js/colorbox/jquery.colorbox.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("div.content img").wrap('<a href="' + $("div.content img").attr("src").replace("thm/", "") +'" class="cb">')
		$(".cb").bind('click',  function(){
			$.fn.colorbox({href:$(this).attr('href'), open:true,  width:"80%", height:"90%"  });
			return false;
		})
	})
</script>