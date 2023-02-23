package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import ejb.CreerAgentEJB;

/**
 * Servlet implementation class CreerAgent
 */
@WebServlet("/CreerAgent")
public class CreerAgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CreerAgentEJB creerAgent = new CreerAgentEJB();
	
    public CreerAgent() {
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

		User agent = new User();
		
		String email = request.getParameter("email");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		Integer idRole = 2;
		String role = "agent";
		
		agent.setEmail(email);
		agent.setFirstName(firstName);
		agent.setLastName(lastName);
		agent.setPhone(phone);
		agent.setAddress(address);
		agent.setPassword(password);
		agent.setRole(role);
		agent.setIdRole(idRole);
		
		 try {
			 boolean agentCreated = creerAgent.CreateAgent(agent);
			 
			if (agentCreated) {           	
            	response.sendRedirect("jsp/homeAgent.jsp");           	
			} else {
            	response.sendRedirect("jsp/creerAgent.jsp");
			}
			
		} catch (Exception e) {
        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
		}
	}

}
