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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPostVersion2(request, response);
	}
	
	protected void doPostVersion2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String role = "";
        try {
        	
        	String email = request.getParameter("email");
        	String password = request.getParameter("password");
        	
        	
            InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSBanqueTest");
            
            Connection connection = dataSource.getConnection();
            Connection connection2 = dataSource.getConnection();
            
            java.sql.PreparedStatement st = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            
            
            st.setString(1, email);
            st.setString(2, password);
            
          // role = getRole(username);
            
            java.sql.PreparedStatement st2 = connection2.prepareStatement("SELECT user.idRole, role.role FROM user JOIN role ON user.idRole = role.id WHERE user.email = '" + email + "';");
            System.out.println("Query: " + st2.toString());
            
            ResultSet rs = st.executeQuery();
            
            
              
            ResultSet rs2 = st2.executeQuery();
            
            
            if(rs.next()) {
            while(rs2.next()) {
            	role = rs2.getString("role");
            	System.out.println("Role in while: " + role);
            	
            	if(role.equals("client")) {
            		
                	response.sendRedirect("jsp/homeInscrit.jsp");
                	//request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
            	}
            	
            	else if(role.equals("agent")) {
            		response.sendRedirect("jsp/homeAgent.jsp");	
            	}
            	
            	else  {
            		response.sendRedirect("jsp/home.jsp");	
            	}
            	
            }
            } 
            
            else {
        	response.sendRedirect("jsp/login.jsp");
        	//request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);	
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
