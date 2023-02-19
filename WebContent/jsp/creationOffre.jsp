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
    Olivier Martin
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Voir les détails de mon profil</a>
    <a class="dropdown-item" href="#">Modifier mon mot de passe</a>
    <a class="dropdown-item" href="#">Supprimer mon compte</a>
  </div>
</div>
                  


                </div>
                <div class="nav-item nav-link"><button type="submit" data-bs-toggle="modal" data-bs-target="#supp" class="btn btn-default">Se déconnecter</button>
</div>



                    </div>
                </div>
                
            
    </nav>
    <!-- FIN BARRE DE NAVIGATION -->


    <!-- Header Start -->
 

    <!-- Début zone recherche pa critères -->
    
                <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.5s" style = "margin-left: 410px";>
                    <div class="h-100"><br><br>
                        <h1 class="display-6 text-center">Création d'une nouvelle offre</h1><br>


    <form action="/webProject/CreationOffre" method="Post">

    <div class="col-md-4">
    <label for="inputState" class="form-label">Type d'offre</label>
    <select id="inputState" class="form-select" id="chooseOffre" name="offre">
      <option selected value="vente">Vente</option>
      <option value="location">Location</option>
    </select>
  </div>

<br>
<div class="col-md-4">
    <label for="inputState" class="form-label" >Type de bien</label>
    <select id="inputState" class="form-select" id="chooseBien" name="bien">
      <option selected value="maison">Maison</option>
      <option value="appartement">Appartement</option>
    </select>
  </div><br>
  
  <div class="col-md-4">
  <label for="inputState" class="form-label">Présence parking</label>
   <select id="inputState" class="form-select" id="chooseParking" name="parking">
      <option selected value="oui">Oui</option>
      <option value="non">Non</option>
    </select>
    </div> <br>

<div class="row">
  <div class="col">
    <input type="text" class="form-control" placeholder="Prix/Loyer" aria-label="Prix/Loyer" id="prix" name="prix">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Adresse" aria-label="Adresse" id="adresse" name="adresse">
  </div>
  <div class="col">
   <input type="text" class="form-control" placeholder="Numero etage" aria-label="etage" id="etage" name="etage">
  </div>
</div>
<br>

<div class="row">
  <div class="col">
    <input type="text" class="form-control" placeholder="Surface du bien" aria-label="Surface du bien" id="surfaceBien" name="surfaceBien">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Surface du terrain (si maison)" aria-label="Surface du terrain (si maison)" id="surfaceTerrain" name="surfaceTerrain">
  </div>
  <div class="col">
    <input type="text" class="form-control" placeholder="Nb. de pièces" aria-label="Nb. de pièces" id="nombrePiece" name="nombrePiece">
  </div>
  <div class="form-group">
    <br>
  <label for="exampleFormControlTextarea1">Description du bien </label>
  <textarea class="form-control rounded-0" id="exampleFormControlTextarea1" rows="3" id="description" name="description"></textarea>
</div>
</div>

<br>





  
  <div class="col-12" style="margin-left: 250px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Valider la création de l'offre</button>
  </div><br><br>
  
  </form>
<!-- </form> -->




                    </div>
                </div>
      
    <!-- Fin zone recherche pa critères -->



<!-- Début zone offres proposées -->

<!--      <div class="container-fluid hero-header bg-light py-5 mb-5">
        <div class="container">
            <div class="row g-5 align-items-center">

<header class="text-center mb-5">
    <h1 class="font-weight-bold">Retrouvez les dernières annonces mises en ligne</h1>
    <p class="font-italic text-muted mb-0">Offre(s) mise(s) en ligne il y a moins de 7 jours</p>
    
  </header> -->


  <!-- Les offres-->
  <!-- <h2 class="f"><br></h2>
  

  <div class="row pb-5 mb-4">
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

        <div class="col-12" style="margin-left: 5px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Détails</button>
    <button type="submit" class="btn btn-primary">Hist...</button>
    <button type="submit" class="btn btn-primary">Modifier</button>
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
          
          <div class="col-12" style="margin-left: 5px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Détails</button>
    <button type="submit" class="btn btn-primary">Hist...</button>
    <button type="submit" class="btn btn-primary">Modifier</button>
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
          
         <div class="col-12" style="margin-left: 5px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Détails</button>
    <button type="submit" class="btn btn-primary">Hist...</button>
    <button type="submit" class="btn btn-primary">Modifier</button>
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
        
         <div class="col-12" style="margin-left: 5px;" style="width: 100px;" >
    <button type="submit" class="btn btn-primary">Détails</button>
    <button type="submit" class="btn btn-primary">Hist...</button>
    <button type="submit" class="btn btn-primary">Modifier</button>
  </div>
        </div>
      </div>
    </div>
  </div>


  

                
            </div>
        </div>
    </div> -->


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
    
</body>
</html>