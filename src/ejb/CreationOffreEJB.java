package ejb;

import javax.ejb.*;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import beans.Offre;

@Stateless
public class CreationOffreEJB {
	
	@PersistenceUnit(unitName = "webProject")
	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;
	

	public String createOffre(Offre offre) {
		String email = "katia.nseir@gmail.co";
		Integer idEtat = 1;
		String photoUrl = "";
		
		try { 
			 InitialContext initialContext = new InitialContext();
	            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
	            
	            Connection connection = dataSource.getConnection();
	            
	            photoUrl = "../images/" + offre.getPhoto();
	            
	            java.sql.PreparedStatement stInsertOffre = connection.prepareStatement("INSERT INTO offres (prix, idEtat, mail, "
						+ "typeBien, typeOffre, description, addresse, etage, surfaceMaison, surfaceTerrain, presenceParking, nombrePieces, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	            
	            System.out.println("test after query");
				
	            stInsertOffre.setDouble(1, offre.getPrice());
	            
	            System.out.println(offre.getPrice());
	            
	            stInsertOffre.setInt(2, idEtat);
	            
	            System.out.println(idEtat);
	            
	            stInsertOffre.setString(3, email);
	            stInsertOffre.setString(4, offre.getTypeBien());
	            stInsertOffre.setString(5, offre.getTypeOffre());
	            stInsertOffre.setString(6, offre.getDescription());
	            stInsertOffre.setString(7, offre.getAddress());
	            stInsertOffre.setInt(8, offre.getEtage());
	            stInsertOffre.setDouble(9, offre.getSurfaceMaison());
	            stInsertOffre.setDouble(10, offre.getSurfaceTerrain());
	            stInsertOffre.setString(11, offre.getPresenceParking());
	            stInsertOffre.setInt(12, offre.getNombrePieces());
	            stInsertOffre.setString(13, photoUrl);
	            
	            System.out.println("before execute");
	            stInsertOffre.executeUpdate();
	            System.out.println("Inserted");
				stInsertOffre.close();

		 } catch (Exception e2) {
	            System.out.println(e2.getMessage().toString());
		 }
		return photoUrl;
	}
}
