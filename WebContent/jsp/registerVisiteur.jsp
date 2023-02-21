<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/webProject/RegisterVisiteur" method="Post">
	<p>email</p><input type="text" id="email" name="email">
	<p>nom</p><input type="text" id="firstName" name="firstName">
	<p>prenom</p><input type="text" id="lastName" name="lastName">
	<p>telephone</p><input type="text" id="phone" name="phone">
	<p>adresse</p><input type="text" id="address" name="address">
	<p>mot de passe</p><input type="text" id="password" name="password">
	<p>confirmer mot de passe</p><input type="text" id="confPassword" name="confPassword">
	
	<input type="submit" value="Insert user">
	</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>YourHome - Agence immobilière</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;500&family=Roboto:wght@500;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="../lib/animate/animate.min.css" rel="stylesheet">
<link href="../lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

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
	<nav
		class="navbar navbar-expand-lg bg-white navbar-light sticky-top p-0 px-4 px-lg-5">
		<a href="index.html" class="navbar-brand d-flex align-items-center">
			<h2 class="m-0 text-primary">
				<img class="img-fluid me-2"
					src="https://cdn-icons-png.flaticon.com/512/720/720119.png" alt=""
					style="width: 45px;"><span class="hometitle"> YourHome</span>
			</h2>


		</a>
		<button type="button" class="navbar-toggler" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<div class="navbar-nav ms-auto py-4 py-lg-0">
				<div class="nav-item nav-link">
					<button type="button" class="btn btn-default">Accueil</button>
				</div>
				<div class="nav-item nav-link">
					<button type="button" class="btn btn-default">Acheter</button>
				</div>
				<div class="nav-item nav-link">
					<button type="button" class="btn btn-default">Louer</button>
				</div>
				<div class="nav-item nav-link">
					<button type="button" class="btn btn-default">Se connecter</button>
				</div>
			</div>
		</div>



		</div>

		</div>
		</div>
	</nav>
	<!-- FIN BARRE DE NAVIGATION -->


	<!-- Header Start -->
	<div class="container-fluid hero-header bg-light py-5 mb-5">
		<div class="container py-13">
			<div class="row g-5 align-items-center">

				<div class="container py-5 h-100">
					<div
						class="row d-flex justify-content-center align-items-center h-100">
						<div class="col">
							<div class="card card-registration my-4">
								<div class="row g-0">
									<div class="col-xl-6 card-body p-md-5"
										style="text-align: center; display: inline-block; vertical-align: top;">
										<img
											src="https://media.istockphoto.com/id/1282624945/fr/photo/concept-immobilier-choisissez-maison-%C3%A0-acheter.jpg?s=612x612&w=0&k=20&c=C9WqAYuy3YGXM1Ov0BMi5ES_2GsqKMiRyOnPq-azzVw="
											alt="Sample photo" class="img-fluid"
											style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
									</div>
									<div class="col-xl-6">
										<div class="card-body p-md-5 text-black">
											<h3 class="mb-5 text-uppercase">S'inscrire</h3>


											<form action="/webProject/RegisterVisiteur" method="Post">
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Adresse
														mail</label>
													<div class="col-sm-10">
														<input type="email" class="form-control" id="email"
															name="email">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Nom</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="firstName"
															name="firstName">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Prénom</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="lastName"
															name="lastName">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Téléphone</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="phone"
															name="phone">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Adresse</label>
													<div class="col-sm-10">
														<input type="text" class="form-control" id="address"
															name="address">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Mot
														de Passe</label>
													<div class="col-sm-10">
														<input type="password" class="form-control" id="password"
															name="password">
													</div>
												</div>
												<div class="row mb-3">
													<label class="form-label" for="form3Example1m">Confirmer
														le Mot de Passe</label>
													<div class="col-sm-10">
														<input type="password" class="form-control"
															id="confPassword" name="confPassword">
													</div>
												</div>

												<div class="d-flex justify-content-end pt-3">



													<button type="submit" class="btn btn-primary"
														value="Insert user">S'inscrire</button>
												</div>
											</form>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>



			</div>
		</div>
	</div>
	<!-- Header End -->





	<!-- Footer Start -->

	<div class="container py-5">
		<div class="row g-5">
			<div class="col-md-6">
				<h1 class="text-primary mb-4">
					<img class="img-fluid me-2"
						src="https://cdn-icons-png.flaticon.com/512/720/720119.png" alt=""
						style="width: 55px;">YourHome
				</h1>
				<p>
					YourHome, la meilleure agence immoblière d'Ile-de-France : <br>
				<ul>
					<li>273 823 projets réalisés</li>
					<li>98% de clients satisfaits</li>
					<li>32 agences en cours d'ouverture</li>
					<li>26 agents à votre service</li>
				</ul>

				</p>
			</div>

			<div class="col-lg-3 col-md-6">
				<h5 class="mb-4">Contactez-nous</h5>
				<p>
					<i class="fa fa-map-marker-alt me-3"></i>72 Rue du Moutier,
					Aubervilliers
				</p>
				<p>
					<i class="fa fa-phone-alt me-3"></i>+33 9 43 26 77 33
				</p>
				<p>
					<i class="fa fa-envelope me-3"></i>auber@yourhome.com
				</p>
			</div>

			<div class="col-lg-3 col-md-6">
				<h5 class="mb-4">Nos réseaux sociaux</h5>
				<div class="d-flex">
					<a class="btn btn-square rounded-circle me-1"
						href="https://twitter.com/" target="blank"><i
						class="fab fa-twitter"></i></a> <a
						class="btn btn-square rounded-circle me-1"
						href="https://www.facebook.com/" target="blank"><i
						class="fab fa-facebook-f"></i></a> <a
						class="btn btn-square rounded-circle me-1"
						href="https://www.youtube.com/" target="blank"><i
						class="fab fa-youtube"></i></a> <a
						class="btn btn-square rounded-circle me-1"
						href="https://www.linkedin.com/" target="blank"><i
						class="fab fa-linkedin-in"></i></a>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#"
		class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
		class="bi bi-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../lib/wow/wow.min.js"></script>
	<script src="../lib/easing/easing.min.js"></script>
	<script src="../lib/waypoints/waypoints.min.js"></script>
	<script src="../lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="../lib/counterup/counterup.min.js"></script>


	<script src="../js/main.js"></script>

</body>

</html>