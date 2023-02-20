package servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.sun.xml.internal.bind.api.impl.NameConverter.Standard;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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
		
		PrintWriter out = response.getWriter();
		JSONArray list = new JSONArray();
		JSONObject obj = new JSONObject();
		HttpSession session = request.getSession();
		JSONObject json = new JSONObject();
		
        try {
        	
        	String email = request.getParameter("email");
        //	String decode = URLDecoder.decode(email);
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
            
           
			String lastName = "";
			String firstName = "";
			String phone = "";
			String address = "";
            
            Integer status = 0;
            String errorMessage = "";
            
            
            if(rs.next()) {
            while(rs2.next()) {
            	role = rs2.getString("role");
            	System.out.println("Role in while: " + role);
            	
            	if(role.equals("client")) {
            		user = new User();
            		
            		
            		firstName = rs.getString("firstName");
            		lastName = rs.getString("lastName");
            		status = 200;
            		
            		
            		user.setFirstName(firstName);
            		user.setLastName(lastName);
            		user.setEmail(email);
            		user.setPassword(password);
            		//user.setStatus(status);
            		
            		session.setAttribute("email", email);
            		
            		//obj.put("status", status);
    				
    				obj.put("lastName", lastName);
    				obj.put("firstName", firstName);
    				obj.put("email", email);
    				

    				list.add(obj);
    				
    				json.put("jsonLogin", list);
    				
    					
    			//	out.println(list.toJSONString());
    			//	out.flush();


    				System.out.println("User is a client");
    				System.out.println(st.toString());
            		
                	response.sendRedirect("jsp/homeInscrit.jsp");
                	//request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
            	}
            	
            	else if(role.equals("agent")) {
            		user = new User();
            		
            		
            		firstName = rs.getString("firstName");
            		lastName = rs.getString("lastName");
            		status = 200;
            		
            		
            		user.setFirstName(firstName);
            		user.setLastName(lastName);
            		user.setEmail(email);
            		user.setPassword(password);
            	//	user.setStatus(status);
            		
            		session.setAttribute("email", email);
            		
            	//	obj.put("status", status);
    				
    				obj.put("lastName", lastName);
    				obj.put("firstName", firstName);
    				obj.put("email", email);
    				

    				list.add(obj);
    				
    				json.put("jsonLogin", list);
    				
    					
    			//	out.println(list.toJSONString());
    			//	out.flush();


    				System.out.println("User is a an agent");
    				System.out.println(st.toString());
            		
            		
            		response.sendRedirect("jsp/homeAgent.jsp");	
            	}
            	
            	else if(role.equals("admin")) {
            		user = new User();
            		
            		
            		firstName = rs.getString("firstName");
            		lastName = rs.getString("lastName");
            		status = 200;
            		
            		
            		user.setFirstName(firstName);
            		user.setLastName(lastName);
            		user.setEmail(email);
            		user.setPassword(password);
            	//	user.setStatus(status);
            		
            		session.setAttribute("email", email);
            		
            	//	obj.put("status", status);
    				
    				obj.put("lastName", lastName);
    				obj.put("firstName", firstName);
    				obj.put("email", email);
    				

    				list.add(obj);
    				
    				json.put("jsonLogin", list);
    				
    					
    			//	out.println(list.toJSONString());
    				//out.flush();


    				System.out.println("User is a an admin");
    				System.out.println(st.toString());
            		
            		
            		response.sendRedirect("jsp/homeAgent.jsp");	
            	}
            	
            	else  {
            		status = 404;
    				errorMessage = "Nom identifiant ou mot de passe incorrect";

    				//obj.put("status", status);
    			//	obj.put("errorMsg", errorMessage);

    				list.add(obj);
    			//	out.println(list.toJSONString());
    			//	out.flush();


    				System.out.println("error, no user found");
    				
            		response.sendRedirect("jsp/home.jsp");	
            	}
            	
            }
            } 
            
            else {
				/*
				 * status = 404; errorMessage = "Nom identifiant ou mot de passe incorrect";
				 * 
				 * obj.put("status", status); obj.put("errorMsg", errorMessage);
				 * 
				 * list.add(obj); out.println(list.toJSONString()); out.flush();
				 */
            	 status = 404;
            //	 obj.put("status", status); 
            //	 obj.put("errorMsg", errorMessage);
            	 list.add(obj); 
            	// out.println(list.toJSONString()); 
            //	 out.flush();

            	 response.sendRedirect("jsp/login.jsp");
				System.out.println("error, no user found");
				/* response.sendRedirect("jsp/login.jsp"); */
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
