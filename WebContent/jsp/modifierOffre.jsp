<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>YourHome - Modifier offre</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

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
    
    
    
    
<style>
	body {
		background-color: #ffffff;
		background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%);
	}
	
	.insurance-caption-title {
		font-size: 20px;
	}
	
	.insurance-content {
		position: relative;
		/*if i change padding i need to change the top in owl loaded  */
		padding: 50px;
	}
	
	.owl-loaded .custom-nav {
		position: absolute;
		top: 30%;
		left: 0;
		right: 0;
	}
	
	.owl-prev, .owl-next {
		position: absolute;
	/* 	height: 100px; */
		background: none;
		border: none;
		z-index: 100;
	}
	
	
	.owl-prev i, .owl-next i {
		color: #FFF;
	}
	
	.owl-prev i:hover, .owl-next i:hover {
		color: #8199A3;
	}
	
	.owl-prev {
		left: 0;
	}
	
	.owl-next {
		right: 0;
	}
	
	button:focus, button:active {
		outline: none;
	}
	
.owl-carousel .img-insurance {
		height:300px;
		width:100%; 
		
	} 
	
	
	
	.active {
		color: black !important;
	}
	
	.nav-link {
		font-size: 18px; 
	}
</style>    





<script>
	 $.ajax({
		 type: 'GET',
        dataType: 'JSON',
        contentType: 'application/json',
        url: '/webProject/ModifierOffre',
        
        success: function(data) {
        	
       		 var html = "";
       		//$.each (data.jsonArray, function(key, val) {
			//	html += '<div class="insurance-container card rounded shadow-sm border-0">';
            //    html += '<div class="insurance-caption card-body p-3">'
	               
          //      html += '<img src= "' + val.photo + '" width="150" height="150" class="image"/>';
          //      html += '<h5 class="insurance-caption-title" style="margin-top: 10px;">' + val.typeBien + " " + val.piece + " pièces " + val.surfaceMaison + " m²" + '</h5>';
              /*   html += '<p class="small text-muted">'; */
                
              /*   html += 'Référence: Ref_' + val.idOffre + '<br>'; */
            //    html += 'Type d’offre: ' + val.typeOffre + '<br>';
           //     html += 'Etat: ' + val.etat + '<br>';
            //    html += 'Prix du bien: ' +val.price + '€ ' + '<br>';
           //     html += 'Adresse: ' + val.adresse + '<br>';
                
             /*    html += '<p>'; */
              	 
               /* html += '<img src= "../images/img2.jpg" width="150" height="150" class="image"/>'; */
            //    console.log(val.photo);
               /*  html += '<p class="insurance-caption-description">' + val.description + '</p>'; */
              /* 	html += '<a href="modifierOffre.jsp?idOffre=' + val.idOffre + '">' + "Save" + '</a>'; */



              	
              //  html += '</div>';
             //   html += '</div>';
			//});
			
				
			/* $("#offre-carousel").html(html); */
		//	$("#offreDetails").html(html);
		//	console.log("Success");
		$.each (data.jsonArrayModify, function(key, val) {
					html += '<div class="pb-5 mb-4 container-fluid">';
					html += '<div class="insurance-container">';
					html += '<div class="col-lg-3 col-md-6 mb-4 mb-lg-0 insurance-content">';
					html += '<div class="card rounded shadow-sm border-0" >';
	                html += '<div class="insurance-caption">'
		                
	               	html += '<img src= "' + val.photo + '" width="150" height="150" class="image"/>';
	               
	                html += 'Nombre piece: <input type="text" value="' + val.piece + '">';
	                html += 'Surface maison: <input type="text" value="' + val.surfaceMaison + '">';
	                html += 'Surface terrain: <input type="text" value="' + val.surfaceTerrain + '">';
	             
	                
	                html += '<select id="inputState" id="chooseOffre" name="offre">'
	               	html += '<option value="vente" ';
	               	console.log("before if: " + val.typeOffre);
	               	
	               	if(val.typeOffre == "vente") {
	               		console.log("after if: " + val.typeOffre);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>Vente </option>';

	               	html += '<option value="location" ';
	               	if(val.typeOffre == "location") {
	               		console.log("after if2: " + val.typeOffre);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>Location </option>'
	              	html += '</select>';

	              	
	               /*  html += 'Etat: <input type="text" value="' + val.etat + '">'; */
	               
	                html += '<select id="inputState" id="chooseEtat" name="etat">'
	               	html += '<option value="EN_COURS" ';
	               	if(val.typeOffre == "EN_COURS") {
	               		console.log("after if1: " + val.etat);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>EN_COURS </option>';

	               	html += '<option value="RESERVE" ';
	               	if(val.typeOffre == "RESERVE") {
	               		console.log("after if2: " + val.etat);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>RESERVE </option>';

	               	html += '<option value="VENDU" ';
	               	if(val.typeOffre == "VENDU") {
	               		console.log("after if3: " + val.etat);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>VENDU </option>';

	               	html += '<option value="SUPPRIME" ';
	               	if(val.typeOffre == "SUPPRIME") {
	               		console.log("after if4: " + val.etat);
		               	html+= 'selected="selected"';
		               	}
	               	html += '>SUPPRIME </option>';
	               	
	              	html += '</select>';

	              	
	                html += 'Prix: <input type="text" value="' + val.price + '">';
	                html += 'Adresse: <input type="text" value="' + val.adresse + '">';
	                html+= '<button type="submit">Save</button>';
	                
	                        /*   html += '<p class="small text-muted">'; */
	                          
	                        /*   html += 'Référence: Ref_' + val.idOffre + '<br>'; */
	               // html += 'Type d’offre: ' + val.typeOffre + '<br>';
	               // html += 'Etat: ' + val.etat + '<br>';
	               // html += 'Prix du bien: ' +val.price + '€ ' + '<br>';
	              //  html += 'Adresse: ' + val.adresse + '<br>';
	              //  console.log(val.price);
	                       /*    html += '<p>'; */
	                        	 
	                    //html += '<img src= "../images/img2.jpg" width="150" height="150" class="image"/>'; */
	               //  console.log("photo: " + val.photo);
	                         /*  html += '<p class="insurance-caption-description">' + val.description + '</p>'; */
	                        /* 	html += '<a href="modifierOffre.jsp?idOffre=' + val.idOffre + '">' + "Save" + '</a>'; */
				});
				
			$("#offre-card").html(html);
			console.log("Success");
			
			console.log(data.jsonArrayModify);
			
       	 },
       	 
	 	error : function(request, status, error) {
	        console.log("An error has occured: " + error);
	        
	    }

	 }); 


		function getAllOffres() {
			document.getElementById("carouselOffres").action = "allOffres.jsp";
			document.getElementById("carouselOffres").method = "post";
			document.getElementById("carouselOffres").submit();
		}


</script> 


    
</head>

<body>
    <!-- Spinner Start -->
    <div id="spinner"
        class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->


    <!-- BARRE DE NAVIGATION -->
    <nav class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0 px-4 px-lg-5">
        <a href="index.html" class="navbar-brand d-flex align-items-center">
            <h2 class="m-0 text-primary"><img class="img-fluid me-2" src="https://cdn-icons-png.flaticon.com/512/720/720119.png" alt=""
                    style="width: 45px;"><span class="hometitle" > YourHome</span></h2>


        </a>
        <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
       <div class="collapse navbar-collapse" id="navbarCollapse">
            <div class="navbar-nav ms-auto py-4 py-lg-0">
              <div class="nav-item nav-link"><button type="button" class="btn btn-default">Nouvelle offre</button></div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Acheter</button></div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Louer</button></div>
                <div class="nav-item nav-link">


                  <div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    <%=session.getAttribute("firstName") %> <%=session.getAttribute("lastName") %>
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Voir les détails de mon profil</a>
    <a class="dropdown-item" href="#">Modifier mon mot de passe</a>
    <a class="dropdown-item" href="#">Supprimer mon compte</a>
  </div>
</div>
                  


                </div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Se déconnecter</button></div>



                    </div>
                </div>
                
     
    </nav>
    <!-- FIN BARRE DE NAVIGATION -->

<input type="text" value="<%=request.getParameter("idOffre")%>" name="idOffre">
<input type="text" value="<%=session.getAttribute("email")%>" name="email">
<%
String varIdOffre = request.getParameter("idOffre");
session.setAttribute("idOffre", varIdOffre); 
%>

    <h2>
		EMAIL:
		<%=session.getAttribute("email") %>
	</h2>

	


<!-- Début zone offres proposées -->

     <div class="container-fluid hero-header bg-light py-5 mb-5">
        <div class="container">
            <div class="row g-5 align-items-center">

<header class="text-center mb-5">
    <h1 class="font-weight-bold">Retrouvez les dernières annonces mises en ligne</h1>
    <p class="font-italic text-muted mb-0">Offre(s) mise(s) en ligne il y a moins de 7 jours</p>
    
  </header>


  <!-- Les offres-->
  <h2 class="f"><br></h2>
  <form id="carouselOffres" name="carouselOffres">
  <div class="col-12" style="margin-left: 250px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary" onclick="getAllOffres()">Toutes les offres</button>
  </div>
  </form>

<form action="/webProject/Test" method="Post"> 
<div class="card-body offre-card" id="offre-card">

       
        

      <!--   </div>  -->
     <!--  </div> -->
    </div>
</form>
   


<!-- Fin zone offres proposées -->



    <!-- Footer Start -->
    
        <div class="container py-5">
            <div class="row g-5">
                <div class="col-md-6">
                    <h1 class="text-primary mb-4"><img class="img-fluid me-2" src="https://cdn-icons-png.flaticon.com/512/720/720119.png" alt=""
                            style="width: 55px;">YourHome</h1>
                    <p>YourHome, la meilleure agence immoblière d'Ile-de-France : 
                        <br>
                        <ul>
                        <li>273 823 projets réalisés</li>
                        <li>98% de clients satisfaits</li>
                        <li>32 agences en cours d'ouverture</li>
                        <li> 26 agents à votre service</li>
                    </ul>

                    </p>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <h5 class="mb-4">Contactez-nous</h5>
                    <p><i class="fa fa-map-marker-alt me-3"></i>72 Rue du Moutier, Aubervilliers</p>
                    <p><i class="fa fa-phone-alt me-3"></i>+33 9 43 26 77 33</p>
                    <p><i class="fa fa-envelope me-3"></i>auber@yourhome.com</p>
                </div>
                
                <div class="col-lg-3 col-md-6">
                    <h5 class="mb-4">Nos réseaux sociaux</h5>
                    <div class="d-flex">
                        <a class="btn btn-square rounded-circle me-1" href="https://twitter.com/" target="blank"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-square rounded-circle me-1" href="https://www.facebook.com/" target="blank"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-square rounded-circle me-1" href="https://www.youtube.com/" target="blank"><i class="fab fa-youtube"></i></a>
                        <a class="btn btn-square rounded-circle me-1" href="https://www.linkedin.com/" target="blank"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <!-- Footer End -->


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
    
    
    
    
    
    
    	
<script>
	$(document).ready(function(){
	$('#offre-carousel').owlCarousel({
		loop: true,
		margin: 10,
		nav: true,
		navText: [
			'<i class="fa fa-chevron-left fa-2x" aria-hidden="true"></i>',
			'<i class="fa fa-chevron-right fa-2x" aria-hidden="true"></i>'
			],
			navContainer: '.insurance-content .custom-nav',
			responsive:{
				0:{
					items: 1
				},
				600:{
					items: 2
				},
				1000:{
					items: 3
				},
				1200:{
					items: 4
				},
			}
		})
	});


	$(document).ready(function() {
		$("input[name$='radioBtn']").click(function() {
			var test = $(this).val();

			$("div.desc").hide();
			$("#" + test + "Div").show();
		});
	});
	
	
	</script>
    
    
    
</body>

</html>