<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail de l'offre</title>
<!-- Favicon -->
   <!--  <link href="../img/favicon.ico" rel="icon"> -->

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Roboto:wght@500;700&display=swap"
        rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="../lib/animate/animate.min.css" rel="stylesheet">
    <!-- <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet"> -->
    
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-slider/11.0.2/bootstrap-slider.min.js"></script>



	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>



	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.js"></script>


	<link rel="stylesheet" href="../assets/owl.carousel.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="../assets/owl.theme.default.min.css">

	<script src="../assets/jquery.min.js" type="text/javascript"></script>

	<script src="../assets/owl.carousel.js" type="text/javascript"></script>

    <!-- Customized Bootstrap Stylesheet -->
    
    
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="../css/style.css" rel="stylesheet">
    
    
    
<script>
$.ajax({
	type: 'GET',
    dataType: 'JSON',
    url: '/webProject/OffreDetails',
       
   	success: function(data) {     	
    	var html = "";
		$.each (data.jsonArrayDetails, function(key, val) {
			html += '<div class="row">';
			html += '<div class="col-md-6">';
			/* html += '<img class="img-fluid img-insurance-details" src="' + val.image + '" width="500px">'; */
			html += '</div>';
			html += '<div class="col-md-6">';
			html += '<h4>' + val.title + '</h4>';
			/* html += '<p>' + val.description + '</p>'; */
			html += '<p>' + "Prix: "+ val.price + "$" +'</p>';
			/* html += '<button type="button" class="btn btn-buyInsurance" onclick="mBuyInsurance()" data-toggle="modal" data-target="#myModal">' + "Achter l'assurance" + '</button>'; */
			html += '</div>';
			html += '</div>';
			
	                
		});
				
		//$("#tableDetails").html(html);
		$("#offreDetails").html(html);
		console.log("Success");
		console.log(data.jsonArrayDetails);
			
	},
       	 
	error : function(request, status, error) {
		console.log("An error has occured: " + error);
		}
	
	}); 

</script>
    
</head>

<body>

<div class="container-fluid" style="padding: 20px;">
<form id="menuDetails">
<input type="hidden" value="<%=request.getParameter("idOffre")%>" name="idOffre">
<input type="hidden" value="<%=session.getAttribute("username")%>" name="username">
<%
String varIdOffre = request.getParameter("idOffre");
session.setAttribute("idOffre", varIdOffre); 
%>

<div class="container" id="offreDetails" style="margin-top:30px">

</div>


</form>
</div>










 <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
            class="bi bi-arrow-up"></i></a>


    <!-- JavaScript Libraries -->
    <!-- <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script> -->
    <!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script> -->
    <script src="../lib/wow/wow.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/waypoints/waypoints.min.js"></script>
    <!-- <script src="lib/owlcarousel/owl.carousel.min.js"></script> -->
    <script src="../lib/counterup/counterup.min.js"></script>

    <!-- Template Javascript -->
    <script src="../js/main.js"></script>



</body>
</html>