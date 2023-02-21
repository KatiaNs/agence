package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Offre;
import beans.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPostVersion2(request, response);
	}

	protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = "";

		User user = null;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		JSONArray list = null;
		JSONObject obj = null;
		HttpSession session = request.getSession();
		JSONObject json = null;
		
		ArrayList<User> arrayUser = null;

		try {

			InitialContext initialContext = new InitialContext();
			javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");

			Connection connection = dataSource.getConnection();
			Connection connection2 = dataSource.getConnection();

			java.sql.PreparedStatement st = connection.prepareStatement("SELECT * FROM user WHERE email =? AND password =?");


			st.setString(1, email);
			st.setString(2, password);


			java.sql.PreparedStatement st2 = connection2.prepareStatement("SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email ='" + email + "';");
			System.out.println("Query: " + st2.toString());

			ResultSet rs = st.executeQuery();


			ResultSet rs2 = st2.executeQuery();
			
			json = new JSONObject();
			list = new JSONArray();

			Integer id = 0;
			String lastName = "";
			String firstName = "";
			String phone = "";
			String address = "";


			Integer status = 0;
			String errorMessage = "";

			System.out.println("email: " + email);

			if(rs.next()) {
				System.out.println("in first if");
				while(rs2.next()) {
					role = rs2.getString("role");
					System.out.println("Role in while: " + role);

					if(role.equals("client")) {
						user = new User();
	        			obj = new JSONObject();
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
						//user.setStatus(status);

						session.setAttribute("email", email);
						session.setAttribute("firstName", firstName);
						session.setAttribute("lastName", lastName);
						session.setAttribute("role", role);

						obj.put("status", status);

						obj.put("lastName", lastName);
						obj.put("firstName", firstName);
						obj.put("password", password);
						obj.put("address", address);
						obj.put("phone", phone);
						obj.put("email", email);
						obj.put("role", role);


						
						arrayUser.add(user);
						
						list.add(obj);

						json.put("jsonLogin", list);

						response.sendRedirect("jsp/homeInscrit.jsp");
						out.println(list);
						out.flush();

						out.close();

						System.out.println(list.toString());


						System.out.println("User is a client");
						System.out.println(st.toString());

					
						//request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
					}

					else if(role.equals("agent")) {
						user = new User();
	        			obj = new JSONObject();
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
						//user.setStatus(status);

						session.setAttribute("email", email);
						session.setAttribute("firstName", firstName);
						session.setAttribute("lastName", lastName);
						session.setAttribute("role", role);

						obj.put("status", status);

						obj.put("lastName", lastName);
						obj.put("firstName", firstName);
						obj.put("password", password);
						obj.put("address", address);
						obj.put("phone", phone);
						obj.put("email", email);
						obj.put("role", role);



						arrayUser.add(user);
						
						list.add(obj);

						json.put("jsonLogin", list);
						
						response.sendRedirect("jsp/homeAgent.jsp");

						out.println(list.toJSONString());
						out.flush();

						out.close();


						System.out.println("User is a an agent");
						System.out.println(st.toString());


						
					}

					else if(role.equals("admin")) {
						user = new User();
	        			obj = new JSONObject();
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
						//user.setStatus(status);

						session.setAttribute("email", email);
						session.setAttribute("firstName", firstName);
						session.setAttribute("lastName", lastName);
						session.setAttribute("role", role);

						obj.put("status", status);

						obj.put("lastName", lastName);
						obj.put("firstName", firstName);
						obj.put("password", password);
						obj.put("address", address);
						obj.put("phone", phone);
						obj.put("email", email);
						obj.put("role", role);


						arrayUser.add(user);
						
						list.add(obj);

						json.put("jsonLogin", list);
						
						response.sendRedirect("jsp/homeAdmin.jsp");	

						out.println(list.toJSONString());
						out.flush();

						out.close();


						System.out.println("User is a an admin");
						System.out.println(st.toString());


						
					}

				}
			} 

			else {
			//	user = new User();
    			obj = new JSONObject();

				System.out.println("in first else");
				
				status = 404;
			//	user.setStatus(status);

				
				errorMessage = "Nom identifiant ou mot de passe incorrect";
				System.out.println("STATUS: " +status);

				obj.put("status", status);
				obj.put("errorMsg", errorMessage);
				
				//arrayUser.add(user);

				list.add(obj);
				
				response.sendRedirect("jsp/login.jsp");

				json.put("jsonLogin", list);

				out.println(list);
				out.flush();
				

				System.out.println("error, no user found");
				

			}


			connection.close();
			connection2.close();
			response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
		} catch (Exception e2) {
			response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
			System.out.println(e2.getMessage().toString());
		}
	}




}
