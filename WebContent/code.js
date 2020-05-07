 
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
		  
	
});


function check() {
		document.getElementById('mangeur').checked = true;
	}
	function unchcheck() {
		document.getElementById('mange').checked = true;
	}
	check();
	unchcheck();
	
	