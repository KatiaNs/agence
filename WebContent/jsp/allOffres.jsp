<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Toutes les offres</title>
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
        contentType: 'application/json',
        url: '/webProject/AllOffres',
        
        success: function(data) {
        	
       		 var html = "";
				$.each (data.jsonArray, function(key, val) {
					html += '<div class="pb-5 mb-4 container-fluid">';
					html += '<div class="insurance-container">';
					html += '<div class="col-lg-3 col-md-6 mb-4 mb-lg-0 insurance-content">';
					html += '<div class="card rounded shadow-sm border-0" >';
					 /*	html += '<img class="img-responsive img-insurance" src="' + val.image + '" alt="Picture 1">';  */
					 /* html += '<img class="img-responsive img-insurance" src="https://picsum.photos/200" alt="Picture 1">'; */
	                html += '<div class="insurance-caption">'
	                html += '<h4 class="insurance-caption-title">' + val.title + '</h4>';
	                console.log(val.title);
	                html += '<h3 class="insurance-caption-title">' + val.price + '</h3>';
	               /*  html += '<p class="insurance-caption-description">' + val.description + '</p>'; */
	              	html += '<a href="offreDetails.jsp?idOffre=' + val.idOffre + '">' + "En savoir plus" + '</a>';
	              	html += '</div>';
	              	html += '</div>';
	              	html += '</div>';
	                html += '</div>';
	                html += '</div>';
				});
				
			$("#offre-card").html(html);
			console.log("Success");
			
			console.log(data.jsonArray);
			
       	 },
       	 
	 	error : function(request, status, error) {
	        console.log("An error has occured: " + error);
	        
	    }

	 }); 

</script>
</head>
<body>
	<h1>Test</h1>
	
	<!-- <div class="row pb-5 mb-4 container-fluid">
    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0 insurance-content">
      Card
      <div class="card rounded shadow-sm border-0">
        <div class="card-body offre-card p-4" id="offre-card" >
          
   
  		</div>
          

        </div>
      </div>
    </div> -->
    
    <!-- <div class="row pb-5 mb-4 container-fluid"> -->
    
      Card
      <!-- <div class="card rounded shadow-sm border-0" > -->
        <div class="card-body offre-card" id="offre-card">

       
         

      <!--   </div>  -->
     <!--  </div> -->
    </div>
   
   
	
	
	<!-- <div class="container-fluid">
	<div class="insurance-content">
		<div class="offre-card owl-loaded" id="offre-card">
			
		</div> 
		
<div class="owl-loaded">
	<div class="owl-controls">
		<div class="custom-nav owl-nav"></div>
	</div>
</div>

	</div>

</div> -->


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