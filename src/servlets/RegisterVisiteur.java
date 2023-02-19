package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/RegisterVisiteur")
public class RegisterVisiteur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterVisiteur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPostVersion2(request, response);
	}
	
	protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		Integer idRole = 1;
		
		 try {
			 
			 
			 InitialContext initialContext = new InitialContext();
	            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
	            
	            Connection connection = dataSource.getConnection();
	            Connection connection2 = dataSource.getConnection();
	            
	            java.sql.PreparedStatement stInsertUser = connection.prepareStatement("INSERT INTO user (email, firstName, lastName, "
						+ "phoneNumber, address, password, idRole) VALUES (?, ?, ?, ?, ?, ?, ?)");
	            
	            
	            java.sql.PreparedStatement stCheckUser = connection2.prepareStatement("SELECT email FROM user WHERE email = ?");
	            System.out.println("Query: " + stCheckUser.toString());
	            
	            
	            
	            stCheckUser.setString(1, email);
	            
	            ResultSet rsSelect = stCheckUser.executeQuery();
	            
	            boolean more = rsSelect.next();
	            
	            //if user does not exists
	            if(!more) {
	            	stInsertUser.setString(1, email);
	            	stInsertUser.setString(2, firstName);
	            	stInsertUser.setString(3, lastName);
	            	stInsertUser.setString(4, phone);
	            	stInsertUser.setString(5, address);
	            	stInsertUser.setString(6, password);
	            	stInsertUser.setInt(7, idRole);
	            	
	            	session.setAttribute("email", email);
	            	
	            	int rsInsert = stInsertUser.executeUpdate();
	            	System.out.println("Registered: " + stInsertUser.toString());
	            	
	            	response.sendRedirect("jsp/homeInscrit.jsp");
	            	
	            }
	            // if user exists
	            else {
	            	response.sendRedirect("jsp/registerVisiteur.jsp");
	            	System.out.println("email already exists");
	            }	            
	           
	            stCheckUser.close();
	            stInsertUser.close();
	            rsSelect.close();
			 
			 
		 } catch (Exception e2) {
	        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
	            System.out.println(e2.getMessage().toString());
		 }
	}

}
