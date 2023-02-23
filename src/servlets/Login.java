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

import beans.User;
import ejb.LoginEJB;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginEJB loginUser;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPostVersion2(request, response);
	}

	protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String role = "";

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = loginUser.login(email, password);

		PrintWriter out = response.getWriter();
		JSONArray list = null;
		JSONObject obj = null;
		HttpSession session = request.getSession();
		JSONObject json = null;

		ArrayList<User> arrayUser = null;

		try {

			json = new JSONObject();
			list = new JSONArray();

			Integer status = 0;

			System.out.println("email: " + email);

			if (user != null) {
				System.out.println("in first if");
				role = user.getRole();
				System.out.println("Role in while: " + role);

				if (role.equals("client")) {
					user = new User();
					obj = new JSONObject();
					arrayUser = new ArrayList<User>();

					status = 200;

					session.setAttribute("email", user.getEmail());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("role", role);

					obj.put("status", status);
					obj.put("lastName", user.getLastName());
					obj.put("firstName", user.getFirstName());
					obj.put("password", user.getPassword());
					obj.put("address", user.getAddress());
					obj.put("phone", user.getPhone());
					obj.put("email", user.getEmail());
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

				}

				else if (role.equals("agent")) {
					user = new User();
					obj = new JSONObject();
					arrayUser = new ArrayList<User>();

					status = 200;

					session.setAttribute("email", user.getEmail());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("lastName", user.getLastName()a);
					session.setAttribute("role", role);

					obj.put("status", status);

					obj.put("lastName", user.getLastName());
					obj.put("firstName", user.getFirstName());
					obj.put("password", user.getPassword());
					obj.put("address", user.getAddress());
					obj.put("phone", user.getPhone());
					obj.put("email", user.getEmail());
					obj.put("role", role);

					arrayUser.add(user);

					list.add(obj);

					json.put("jsonLogin", list);

					response.sendRedirect("jsp/homeAgent.jsp");

					out.println(list.toJSONString());
					out.flush();

					out.close();

					System.out.println("User is a an agent");

				}

				else if (role.equals("admin")) {
					user = new User();
					obj = new JSONObject();
					arrayUser = new ArrayList<User>();

					status = 200;

					session.setAttribute("email", user.getEmail());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("lastName", user.getLastName());
					session.setAttribute("role", role);

					obj.put("status", status);

					obj.put("lastName", user.getLastName());
					obj.put("firstName", user.getFirstName());
					obj.put("password", user.getPassword());
					obj.put("address", user.getAddress());
					obj.put("phone", user.getPhone());
					obj.put("email", user.getEmail());
					obj.put("role", role);

					arrayUser.add(user);

					list.add(obj);

					json.put("jsonLogin", list);

					response.sendRedirect("jsp/homeAdmin.jsp");

					out.println(list.toJSONString());
					out.flush();

					out.close();

					System.out.println("User is a an admin");
				}
			} else {
				obj = new JSONObject();

				System.out.println("in first else");

				status = 404;

				String errorMessage = "Nom identifiant ou mot de passe incorrect";
				System.out.println("STATUS: " + status);

				obj.put("status", status);
				obj.put("errorMsg", errorMessage);

				list.add(obj);

				response.sendRedirect("jsp/login.jsp");

				json.put("jsonLogin", list);

				out.println(list);
				out.flush();

				System.out.println("error, no user found");

			}

			response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
		} catch (Exception e2) {
			response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
			System.out.println(e2.getMessage().toString());
		}
	}

}
