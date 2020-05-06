 
$(document).ready(function(){
//	$( "#dialog" ).position({
//		  my: "right center",
//		  at: "right bottom",
//		  of: "#modal"
//		});
	$("#dialog").css({"float": "right", "background-color":"grey", "width": "300%","height": "300%"});
	
		 $("#dialog").dialog({
		     autoOpen: false,
		     modal: true
		   });

		  $("#bajouter").on("click", function(e) {
		      e.preventDefault();
		      $("#dialog").dialog("open");
		      
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
	
	