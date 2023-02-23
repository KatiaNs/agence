package ejb;

import javax.ejb.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import beans.Offre;

@Stateless
public class AllOffresEJB {
	
	@PersistenceUnit(unitName = "webProject")
	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;
	
	public ArrayList<Offre> allOffres(String email){
		
		Offre offre = null;
		ArrayList<Offre> arrayOffre = null;

		try {

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/MaDSBanqueTest");

			Connection connection = dataSource.getConnection();

			Connection connection2 = dataSource.getConnection();

			System.out.println("EMAIL: " + email);
			String role = "";

			java.sql.PreparedStatement stGetUserRole = connection.prepareStatement(
					"SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email = '"
							+ email + "';");

			ResultSet rsSelectRole = stGetUserRole.executeQuery();

			if (!rsSelectRole.next()) {

				java.sql.PreparedStatement stGetVisiteur = connection2
						.prepareStatement("SELECT * FROM offres JOIN etat ON "
								+ "offres.idEtat = etat.id WHERE offres.idEtat = 1 OR offres.idEtat = 2");

				ResultSet rsSelect = stGetVisiteur.executeQuery();

				offre = new Offre();

				arrayOffre = new ArrayList<Offre>();

				Integer id = 0;
				Double price = 0.0;
				String typeBien = "";
				String typeOffre = "";
				String description = "";
				String adresse = "";
				Integer etage = 0;
				Double surfaceMaison = 0.0;
				Double surfaceTerrain = 0.0;
				String parking = "";
				Integer piece = 0;
				String photo = "";
				String etat = "";

				while (rsSelect.next()) {

					offre = new Offre();

					arrayOffre = new ArrayList<Offre>();

					id = rsSelect.getInt("id");
					
					price = rsSelect.getDouble("prix");
					typeBien = rsSelect.getString("typeBien");
					typeOffre = rsSelect.getString("typeOffre");
					description = rsSelect.getString("description");
					adresse = rsSelect.getString("addresse");
					etage = rsSelect.getInt("etage");
					surfaceMaison = rsSelect.getDouble("surfaceMaison");
					surfaceTerrain = rsSelect.getDouble("surfaceTerrain");
					parking = rsSelect.getString("presenceParking");
					piece = rsSelect.getInt("nombrePieces");
					photo = rsSelect.getString("photo");
					etat = rsSelect.getString("etat");

					offre.setId(id);
					offre.setPrice(price);
					offre.setTypeBien(typeBien);
					offre.setTypeOffre(typeOffre);
					offre.setDescription(description);
					offre.setAddress(adresse);
					offre.setEtage(etage);
					offre.setSurfaceMaison(surfaceMaison);
					offre.setSurfaceTerrain(surfaceTerrain);
					offre.setPresenceParking(parking);
					offre.setNombrePieces(piece);
					offre.setPhoto(photo);
					offre.setEtat(etat);
					
					arrayOffre.add(offre);

				}
			} else {

				role = rsSelectRole.getString("role");
				System.out.println("Role in while: " + role);

				if (role.equals("client")) {
					System.out.println("in if");
					java.sql.PreparedStatement stGetClient = connection2
							.prepareStatement("SELECT * FROM offres JOIN etat ON "
									+ "offres.idEtat = etat.id WHERE offres.idEtat = 1 OR offres.idEtat = 2");

					ResultSet rsSelect = stGetClient.executeQuery();

					Integer id = 0;
					Double price = 0.0;
					String typeBien = "";
					String typeOffre = "";
					String description = "";
					String adresse = "";
					Integer etage = 0;
					Double surfaceMaison = 0.0;
					Double surfaceTerrain = 0.0;
					String parking = "";
					Integer piece = 0;
					String photo = "";
					String etat = "";

					while (rsSelect.next()) {

						offre = new Offre();

						arrayOffre = new ArrayList<Offre>();

						id = rsSelect.getInt("id");
						System.out.println("id: " + id);
						price = rsSelect.getDouble("prix");
						System.out.println("prix: " + price);
						System.out.println("photo" + photo);
						typeBien = rsSelect.getString("typeBien");
						typeOffre = rsSelect.getString("typeOffre");
						description = rsSelect.getString("description");
						adresse = rsSelect.getString("addresse");
						etage = rsSelect.getInt("etage");
						surfaceMaison = rsSelect.getDouble("surfaceMaison");
						surfaceTerrain = rsSelect.getDouble("surfaceTerrain");
						parking = rsSelect.getString("presenceParking");
						piece = rsSelect.getInt("nombrePieces");
						photo = rsSelect.getString("photo");
						etat = rsSelect.getString("etat");
						System.out.println("ETAT:" + etat);

						offre.setId(id);
						offre.setPrice(price);
						offre.setTypeBien(typeBien);
						offre.setTypeOffre(typeOffre);
						offre.setDescription(description);
						offre.setAddress(adresse);
						offre.setEtage(etage);
						offre.setSurfaceMaison(surfaceMaison);
						offre.setSurfaceTerrain(surfaceTerrain);
						offre.setPresenceParking(parking);
						offre.setNombrePieces(piece);
						offre.setPhoto(photo);
						offre.setEtat(etat);
						
						arrayOffre.add(offre);

					}

				}

				else if (role.equals("agent") || role.equals("admin")) {
					java.sql.PreparedStatement stGetAgentAdmin = connection2
							.prepareStatement("SELECT * FROM offres JOIN etat ON offres.idEtat = etat.id");

					ResultSet rsSelect = stGetAgentAdmin.executeQuery();

					offre = new Offre();

					arrayOffre = new ArrayList<Offre>();

					Integer id = 0;
					Double price = 0.0;
					String typeBien = "";
					String typeOffre = "";
					String description = "";
					String adresse = "";
					Integer etage = 0;
					Double surfaceMaison = 0.0;
					Double surfaceTerrain = 0.0;
					String parking = "";
					Integer piece = 0;
					String photo = "";
					String etat = "";

					while (rsSelect.next()) {

						offre = new Offre();
						arrayOffre = new ArrayList<Offre>();

						id = rsSelect.getInt("id");
						System.out.println("id: " + id);
						price = rsSelect.getDouble("prix");
						System.out.println("prix: " + price);
						System.out.println("photo" + photo);
						typeBien = rsSelect.getString("typeBien");
						typeOffre = rsSelect.getString("typeOffre");
						description = rsSelect.getString("description");
						adresse = rsSelect.getString("addresse");
						etage = rsSelect.getInt("etage");
						surfaceMaison = rsSelect.getDouble("surfaceMaison");
						surfaceTerrain = rsSelect.getDouble("surfaceTerrain");
						parking = rsSelect.getString("presenceParking");
						piece = rsSelect.getInt("nombrePieces");
						photo = rsSelect.getString("photo");
						etat = rsSelect.getString("etat");

						offre.setId(id);
						offre.setPrice(price);
						offre.setTypeBien(typeBien);
						offre.setTypeOffre(typeOffre);
						offre.setDescription(description);
						offre.setAddress(adresse);
						offre.setEtage(etage);
						offre.setSurfaceMaison(surfaceMaison);
						offre.setSurfaceTerrain(surfaceTerrain);
						offre.setPresenceParking(parking);
						offre.setNombrePieces(piece);
						offre.setPhoto(photo);
						offre.setEtat(etat);

						arrayOffre.add(offre);
					}
				}
			}
			
			connection.close();
			connection2.close();
		} catch (

		Exception e2) {
			System.out.println(e2.getMessage().toString());
		}
		
		return arrayOffre;
	}

}
