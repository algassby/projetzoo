 
$(document).ready(function(){

	$("#dialog").css({"float": "right", "background-color":"grey"});
	
		 $("#dialog").dialog({
		     autoOpen: false,
		     modal: true
		   });

		  $("#bajouter").on("click", function(e) {
		      e.preventDefault();
		      $("#dialog").dialog("open");
		      
		  });
		  //button reset
		  
		  $('#reset').click(function() {
			   // window.location.href = '${pageContext.request.contextPath}/init';
			  window.location.replace("index.jsp");
			});
	
});


function check() {
		document.getElementById('mangeur').checked = true;
	}
	function unchcheck() {
		document.getElementById('mange').checked = true;
	}
	check();
	unchcheck();
	
	