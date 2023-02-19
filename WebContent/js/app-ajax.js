$(document).ready(function() {
	$('#btnLogin').click(function() {
		$.ajax({
			 type: "POST",
             dataType: "json",
			url : 'GetUserServlet',
			data : {
				userName : $('#userName').val()
			},
			success : function(responseText) {
				location.replace('Home.jsp');
				$('#ajaxGetUserServletResponse').text(responseText);
			}
		});
	});
});