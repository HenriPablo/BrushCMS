<style>
.button {
   border: 1px solid #999;
   background: #9e9e9e;
   background: -webkit-gradient(linear, left top, left bottom, from(#fff), to(#ccc));
   background: -moz-linear-gradient(top, #fff, #ccc);
   color: #000;
   font-weight: bold;
   text-decoration: none;
   vertical-align: middle;
   }
.button:hover {
/* DARK BLUE BLEND
   color: #fff;
   background: #2f3d4a;
   background: -webkit-gradient(linear, left top, left bottom, from(#ccc), to(#2f3d4a));
   background: -moz-linear-gradient(top, #ccc, #2f3d4a);
   */

   /* ORANGE BLEND */
	background: #f30;
	background: -webkit-gradient(linear, left top, left bottom, from(#f90), to(#f30));
	background: -moz-linear-gradient(top, #f90, #f30);

   text-shadow: rgba(255,255,255,.4) 255 1px 255;
   border-color: #777;
   }
.button:active {
	color: #ff9;
   background: #900;
   }

.grad_org{
	color: #300;
	background: #f30;
	background: -webkit-gradient(linear, left top, left bottom, from(#f90), to(#f30));
	background: -moz-linear-gradient(top, #f90, #f30);

}

dl{
	border: 1px solid #666;
	background-color: #d1d1d1;
	padding: 1em;
   }
dt{
	background-color: #666;
	color:#fff;
	padding: 5px;
	margin: 6px auto 6px auto;
	cursor: pointer;
	text-align: center;
}
dd{
	border:1px solid #666;
	padding: 5px;
	background-color: #ffc;
}

</style>


<dl class="round_6">

	<dt class="round_6"> Prospects: </dt>
	<dd class="round_6"> Latest: </dd>


	<dt class="round_6"> FAQs: </dt>
	<dd class="round_6">
		Pending:<br />
		Latest:<br />
		List All:<br />


	</dd>


	<dt class="round_6"> Tradeshows: </dt>
	<dd class="round_6">
		List All:<br />
		Add:<br />
	</dd>


	<dt class="round_6"> Training Class: </dt>
	<dd class="round_6">
		Show:<br />
			Training Class Page Blocks:<a href="${pageContext.servletContext.contextPath}/admin/training_class/edit.html">EDIT</a><br />
			Training Days:
			<a href="${pageContext.servletContext.contextPath}/admin/training_class_day/new.html">Add New Day</a> ::
			<a href="${pageContext.servletContext.contextPath}/admin/training_class_day/list.html">List Days</a><br />
			Training Day Segments:<br />
	</dd>


	<dt class="round_6"> Preowned Roasters: </dt>
	<dd class="round_6">
		Latest:<br />
		List All:<br />
		Add New:<br />
	</dd>


	<dt class="round_6"> Setting &amp; Preferences: </dt>
	<dd class="round_6">
		Admin:<br />
		Twitter:<br />
		Blogger:<br />
		Facebook:<br />
	</dd>

</dl>






<script>
	$(document).ready( function(){

		/* UNCOMMENT BELOW FOR PRODUCTION */
		$("dd").hide();
		$("dt").click( function(){
			if( $(this).hasClass('grad_org') ) {
				$(this).removeClass('grad_org');
			} else {
				$(this).addClass('grad_org');
			}
			$(this).next("dd").toggle();
		})

		$("dt").addClass('button');

		$("dt").hover(
			function(){
				$(this).addClass('button:hover');
		},
			function(){
				//$(this).removeClass('button');
		})
	})
</script>