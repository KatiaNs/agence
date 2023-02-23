package ejb;

import javax.ejb.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.User;

@Stateless
public class LoginEJB {

	@PersistenceUnit(unitName = "webProject")
	private EntityManagerFactory emf;

	@PersistenceContext
	private EntityManager entityManager;

	public User login(String email, String password) {
		User user = null;
		try {
			String role = "";

			ArrayList<User> arrayUser = null;

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext
					.lookup("java:jboss/datasources/MaDSBanqueTest");

			Connection connection = dataSource.getConnection();
			Connection connection2 = dataSource.getConnection();

			java.sql.PreparedStatement st = connection
					.prepareStatement("SELECT * FROM user WHERE email =? AND password =?");

			st.setString(1, email);
			st.setString(2, password);

			java.sql.PreparedStatement st2 = connection2.prepareStatement(
					"SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email ='"
							+ email + "';");
			System.out.println("Query: " + st2.toString());

			ResultSet rs = st.executeQuery();

			ResultSet rs2 = st2.executeQuery();

			Integer id = 0;
			String lastName = "";
			String firstName = "";
			String phone = "";
			String address = "";

			Integer status = 0;
			String errorMessage = "";

			System.out.println("email: " + email);

			if (rs.next()) {
				System.out.println("in first if");
				while (rs2.next()) {
					role = rs2.getString("role");
					System.out.println("Role in while: " + role);

					if (role.equals("client")) {
						user = new User();
						arrayUser = new ArrayList<User>();

						id = rs.getInt("id");
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						phone = rs.getString("phoneNumber");
						address = rs.getString("address");
						password = rs.getString("password");

						status = 200;

						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setEmail(email);
						user.setAddress(address);
						user.setPhone(phone);
						user.setPassword(password);
						user.setRole("client");

						arrayUser.add(user);

						System.out.println("User is a client");
						System.out.println(st.toString());

						// request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
					}

					else if (role.equals("agent")) {
						user = new User();
						arrayUser = new ArrayList<User>();

						id = rs.getInt("id");
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						phone = rs.getString("phoneNumber");
						address = rs.getString("address");
						password = rs.getString("password");

						status = 200;

						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setEmail(email);
						user.setAddress(address);
						user.setPhone(phone);
						user.setPassword(password);
						user.setRole("agent");

						arrayUser.add(user);

						System.out.println("User is a an agent");
						System.out.println(st.toString());

					}

					else if (role.equals("admin")) {
						user = new User();
						arrayUser = new ArrayList<User>();

						id = rs.getInt("id");
						firstName = rs.getString("firstName");
						lastName = rs.getString("lastName");
						phone = rs.getString("phoneNumber");
						address = rs.getString("address");
						password = rs.getString("password");

						status = 200;

						user.setFirstName(firstName);
						user.setLastName(lastName);
						user.setEmail(email);
						user.setAddress(address);
						user.setPhone(phone);
						user.setPassword(password);
						user.setRole("admin");

						arrayUser.add(user);

						System.out.println("User is a an admin");
						System.out.println(st.toString());

					}

				}

			} else {

				System.out.println("in first else");
				errorMessage = "Nom identifiant ou mot de passe incorrect";
				System.out.println("STATUS: " + status);
				System.out.println("error, no user found");
			}

			connection.close();
			connection2.close();

		} catch (Exception e2) {

			System.out.println(e2.getMessage().toString());
		}
		return user;
	}

}