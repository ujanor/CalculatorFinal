$(document).ready(function() {	
	call();
	
});
var value=0;
function call(){
	 $.ajax({
         url: '/api/calculator/ping',
         //url: 'js/jsons/sidebar.json',
         type: 'GET',
         crossDomain: true,
         xhrFields: {
             withCredentials: true
         },
         success: function(response) {
             console.log(response);
         },
         error: function() {
             console.log('Error');
         }
     }); 
}
var v;
function calculate(s){
	var json={
			'data' : s
	}
	var url = "/api/calculator/calculate";
	 $.ajax({
       url: url,
       method: "POST",
       dataType: "JSON",
       contentType: "application/json",
       data: JSON.stringify(json),
       crossDomain: true,
       xhrFields: {
           withCredentials: true
       },
       success: function(response) {
    	   
    		   $(" input[name=answer]").val(response);
    	   
       	console.log(response);
       },
       error: function(error) {
    	   $(" input[name=answer]").val(error);
       }
   }); 
}
	
