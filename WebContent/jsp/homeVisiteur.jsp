<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>YourHome - Agence immobilière</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

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
    <!--  <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet"> -->
    
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
        url: '/webProject/HomeOffres',
        
        success: function(data) {
        	
       		 var html = "";
				$.each (data.jsonArray, function(key, val) {
					html += '<div class="insurance-container">';
					 /*	html += '<img class="img-responsive img-insurance" src="' + val.image + '" alt="Picture 1">';  */
					 /* html += '<img class="img-responsive img-insurance" src="https://picsum.photos/200" alt="Picture 1">'; */
	                html += '<div class="insurance-caption">'
	                html += '<h4 class="insurance-caption-title">' + val.title + '</h4>';
	                console.log(val.title);
	                html += '<h3 class="insurance-caption-title">' + val.price + '</h3>';
	               /*  html += '<p class="insurance-caption-description">' + val.description + '</p>'; */
	              	html += '<a href="homeInscrit.jsp?idOffre=' + val.idOffre + '">' + "En savoir plus" + '</a>';
	                html += '</div>';
	                html += '</div>';
				});
				
			$("#offre-carousel").html(html);
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
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Accueil</button></div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Acheter</button></div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Louer</button></div>
                <div class="nav-item nav-link"><button type="button" class="btn btn-default">Se connecter</button></div>
                  


                </div>
               
                    </div>
                
    </nav>
    <!-- FIN BARRE DE NAVIGATION -->


    <!-- Header Start -->
    <div class="container-fluid hero-header bg-light py-5 mb-5">
        <div class="container py-5">
            <div class="row g-5 align-items-center">
                <div class="col-lg-6">
                    
                    <div class ="animated slideInDown">
                    <h1 class="display-4 mb-3">YourHome </h1> <h2 class=" ville animated slideInDown">Votre agence immobilière à Aubervilliers</h2>


                    <nav aria-label="breadcrumb animated slideInDown">
                        <div class="breadcrumb mb-0 ">
                            
                            <li class="breadcrumb-item active" aria-current="page"> <br>
                            Sur notre site, vous aurez la possibilité de consulter une multitude d’annonces immobilières qui saura répondre à vos besoins. <br>Maison, appartement, studio : un large choix vous est proposé. <br>Nos agents sont à votre disponibilité pour vous accompagner dans vos projets immobiliers en fonction de vos critères.
                            <br><BR>
                           Retrouvez-nous au : 72 Rue du Moutier - 93300 AUBERVILLIERS </li>
                        </div>
                    </nav>
                </div>
            </div>



                <div class="col-lg-6 animated fadeIn">
                    <img class="img-fluid animated pulse infinite" style="animation-duration: 3s;" src="https://www.journaldelagence.com/wp-content/uploads/2021/12/PRIX-IMMOBILIER--1024x643.jpeg"
                        alt="">
                </div>
            </div>
        </div>
    </div>
    <!-- Header End -->


    <!-- Début zone recherche pa critères -->
    <div class="container-xxl py-5">
        <div class="container">
            <div class="row g-5 align-items-center">
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                    <img class="img-fluid" src="https://cdn-user-icons.flaticon.com/89357/89357021/1672967740860.svg?token=exp=1672968673~hmac=73d5192465b6dc92a2d1a96c0950da1e" alt="">
                </div>
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s">
                    <div class="h-100">
                        <h1 class="display-6 text-center">Trouvez votre bien immobilier idéal</h1>


                       <form>


    <div class ="recherche_offres">
                            <p> Recherche des offres par : </p>
     <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Référence de l'offre</label>
</div>
</div>
    <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Critères de recherche</label>
</div>
    

</div>
</form>
<br>

<div class="row">
  <div class="col">
    <input type="text" class="form-control" placeholder="Département" aria-label="Département">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Ville" aria-label="Ville">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Code postal" aria-label="Code postal">
  </div>
</div>
<br>

<div class="row">
  <div class="col">
    <input type="text" class="form-control" placeholder="Budget min" aria-label="Budget min">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Budget max" aria-label="Budget max">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Nb. de pièces" aria-label="Nb. de pièces">
  </div>
</div>

<br>
<form class="row g-3">
  
  
  <div class="col-md-4">
    <label for="inputState" class="form-label">Type de bien</label>
    <select id="inputState" class="form-select">
      <option selected>Maison</option>
      <option>Appartement</option>
    </select>
  </div>
  
  <div class="col-12" style="margin-left: 250px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Rechercher</button>
  </div>
</form>




                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Fin zone recherche pa critères -->



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
  

  <!-- <div class="row pb-5 mb-4">
    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
      Card
      <div class="card rounded shadow-sm border-0">
        <div class="card-body p-4"><img src="https://prod-saint-gobain-fr.content.saint-gobain.io/sites/saint-gobain.fr/files/2020-06/amenagement-interieur-conseils-et-solutions-00.jpg" alt="" class="img-fluid d-block mx-auto mb-3">
          <h5> <a href="#" class="text-dark">Maison 3 pièces 85,6 m²</a></h5>
          <p class="small text-muted font-italic">  Référence : Ref_3945 <br>
                                                    Type d’offre : vente <br>
                                                    Prix du bien : 228 987 € <br>
                                                    Commune : Ris-Orangis<br>
                                                    Département : Essonne<br>
                                                    Code postal : 91130 <br>
                                                    <br>
                                                    </p>

        <div class="col-12" style="margin-left: 76px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Voir détails</button>
  </div>
          



        </div>
      </div>
    </div>

    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
      Card
      <div class="card rounded shadow-sm border-0">
        <div class="card-body p-4"><img src="https://www.createursdinterieur.com/static/f387d62c3581d3daf3a5900555bf105f/ddced/01-apres-architecture-interieur-appartement-4-pieces.jpg" alt="" class="img-fluid d-block mx-auto mb-3">
          <h5> <a href="#" class="text-dark">Appartement 2 pièces 35 m²</a></h5>
          <p class="small text-muted font-italic">Référence : Ref_3946 <br>
                                                    Type d’offre : location <br>
                                                    Montant du loyer : 559€/mois <br>
                                                    Commune : Bondy<br>
                                                    Département : Seine-Saint-Denis<br>
                                                    Code postal : 93140 <br>
                                                    <br></p>
          
          <div class="col-12" style="margin-left: 76px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Voir détails</button>
  </div>
        </div>
      </div>
    </div>

    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
      Card
      <div class="card rounded shadow-sm border-0">
        <div class="card-body p-4"><img src="https://www.maisonsclairlogis.fr/wp-content/uploads/2021/07/montcalm_maison-neuve_exterieur-zoom.png" alt="" class="img-fluid d-block mx-auto mb-3">
          <h5> <a href="#" class="text-dark">Maison 5 pièces 98,5 m²</a></h5>
          <p class="small text-muted font-italic">Référence : Ref_3947 <br>
                                                    Type d’offre : vente <br>
                                                    Prix du bien : 452 778 € <br>
                                                    Commune : Ablis<br>
                                                    Département : Yvelines<br>
                                                    Code postal : 78660 <br>
                                                    <br></p>
          
          <div class="col-12" style="margin-left: 76px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Voir détails</button>
  </div>
        </div>
      </div>
    </div>

    <div class="col-lg-3 col-md-6 mb-4 mb-lg-0">
      Card
      <div class="card rounded shadow-sm border-0">
        <div class="card-body p-4"><img src="https://www.maisonsclairlogis.fr/wp-content/uploads/maison-contemporaine_onyx-version-nuit.jpg" alt="" class="img-fluid d-block mx-auto mb-3">
          <h5> <a href="#" class="text-dark">Maison 8 pièces 170 m²</a></h5>
          <p class="small text-muted font-italic">Référence : Ref_3948 <br>
                                                    Type d’offre : vente <br>
                                                    Prix du bien : 662 772 € <br>
                                                    Commune : Nice <br>
                                                    Département : Alpes-Maritimes<br>
                                                    Code postal : 06300 <br>
                                                    <br></p>
        
         <div class="col-12" style="margin-left: 76px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Voir détails</button>
  </div>
        </div>
      </div>
    </div>
  </div> -->



<!-- Insurance carousel -->
<div class="container-fluid">
	<div class="insurance-content">
		<div class="owl-carousel owl-loaded" id="offre-carousel">
			
		</div> 
		
<div class="owl-loaded">
	<div class="owl-controls">
		<div class="custom-nav owl-nav"></div>
	</div>
</div>

	</div>

</div>
  

                
            </div>
        </div>
    </div>


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
   <!--  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script> -->
    <script src="../lib/wow/wow.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/waypoints/waypoints.min.js"></script>
   <!--  <script src="../lib/owlcarousel/owl.carousel.min.js"></script> -->
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
	
	
	</script>
	
</body>

</html>