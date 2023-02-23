package ejb;

import javax.ejb.*;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import beans.User;

@Stateless
public class CreerAgentEJB {

	@PersistenceUnit(unitName = "webProject")
	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;

	public boolean CreateAgent(User agent) {
		boolean agentCreated = false;

		try {

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/MaDSBanqueTest");

			Connection connection = dataSource.getConnection();
			Connection connection2 = dataSource.getConnection();

			java.sql.PreparedStatement stInsertUser = connection
					.prepareStatement("INSERT INTO user (email, firstName, lastName, "
							+ "phoneNumber, address, password, idRole) VALUES (?, ?, ?, ?, ?, ?, ?)");

			java.sql.PreparedStatement stCheckUser = connection2
					.prepareStatement("SELECT email FROM user WHERE email = ?");
			System.out.println("Query: " + stCheckUser.toString());

			stCheckUser.setString(1, agent.getEmail());

			ResultSet rsSelect = stCheckUser.executeQuery();

			boolean more = rsSelect.next();

			// if user does not exists
			if (!more) {
				stInsertUser.setString(1, agent.getEmail());
				stInsertUser.setString(2, agent.getFirstName());
				stInsertUser.setString(3, agent.getLastName());
				stInsertUser.setString(4, agent.getPhone());
				stInsertUser.setString(5, agent.getAddress());
				stInsertUser.setString(6, agent.getPassword());
				stInsertUser.setInt(7, agent.getIdRole());

				int rsInsert = stInsertUser.executeUpdate();
				System.out.println("Registered: " + stInsertUser.toString());
				agentCreated = true;
			}

			// if user exists
			else {
				System.out.println("email already exists");
				agentCreated = false;
			}

			stCheckUser.close();
			stInsertUser.close();
			rsSelect.close();

		} catch (Exception e2) {
			System.out.println(e2.getMessage().toString());
		}
		return agentCreated;

	}

}
