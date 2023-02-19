package session4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.Date;
import java.net.URLDecoder;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import beans.Compte;
import beans.Operation;
import beans.GestionCompte;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class ServletPrincipal
 */
@WebServlet("/ServletPrincipal")
public class ServletPrincipal extends HttpServlet {
    private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("deprecation")
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		goGetVersion1(request, response);
		doGetVersion2(request, response);
	}

    @SuppressWarnings("deprecation")
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void goGetVersion1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().
			append("Entrée dans la servlet à : ").append(DateFormat.getDateTimeInstance().format(new Date())).
			append("\nRequestURL : ").append(request.getRequestURL()).
			append("\nRequestURI : ").append(request.getRequestURI()).
			append("\nScheme : ").append(request.getScheme()).
			append("\nContextPath : ").append(request.getContextPath()).
			append("\nServletPath : ").append(request.getServletPath()).
			append("\nRemoteAddr : ").append(request.getRemoteAddr()).
			append("\nRemoteHost : ").append(request.getRemoteHost()).
			append("\nLocalAddr : ").append(request.getLocalAddr()).
			append("\nQueryString : ").append(URLDecoder.decode(request.getQueryString(), "UTF-8")).
			append("\nProtocol : ").append(request.getProtocol()).
			append("\nMethod : ").append(request.getMethod()).
			append("\nLocale country : ").append(request.getLocale().getCountry()).
			append("\nLocale language : ").append(request.getLocale().getDisplayLanguage()).
			append("\nParamètre prénom = ").append(URLDecoder.decode(request.getParameter("prénom"), "UTF-8")).
			append("\nParamètre nom = ").append(URLDecoder.decode(request.getParameter("nom"), "UTF-8"));
	}

    @SuppressWarnings("deprecation")
    protected void doGetVersion2(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            InitialContext initialContext = new InitialContext();
            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSMySQL");
            Connection connection = dataSource.getConnection();
            connection.close();
            response.getWriter().append("\nConnexion à la DB ok le ").append(new Date().toLocaleString());
        } catch (Exception e2) {
        	response.getWriter().append("\nProblème de connexion à la DB : ").append(new Date().toLocaleString());
            System.out.println(e2.getMessage());
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPostVersion3(request, response);
    }

    protected void doPostVersion1(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            String noDeCompte = request.getParameter("noDeCompte");
            Compte unCompte = new Compte();
            unCompte.setNocompte(noDeCompte);
            response.getWriter().append("<h2>Instanciation d'un compte avec n° de compte = ").
            	append(unCompte.getNocompte()).append("</h2>");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    protected void doPostVersion2(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            String noDeCompte = request.getParameter("noDeCompte");
            Compte unCompte = new Compte();
            unCompte.setNocompte(noDeCompte);

            ArrayList<Operation> listeOperations = GestionCompte
                    .rechercheOperations(getDataSource(), unCompte);
            response.getWriter().append("<h2>Liste des opérations sur ce compte : </h2>");
            Operation op = null;
            for (int i = 0; i < listeOperations.size(); i++) {
                op = (Operation) listeOperations.get(i);
                response.getWriter().
                		append("<h3>Opération n° ").
                		append(new Integer(op.getIdOperation()).toString()).
                        append(" de type '" + op.getOperation()).
                        append("' effectuée le ").
                        append(op.getDateOperation()).
                        append(" à ").
                        append(op.getHeureOperation()).
                        append(" d'un montant de ").
                        append(new Float(op.getValeur()).toString()).
                        append(" euros</h3>");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    protected void doPostVersion3(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            String noDeCompte = request.getParameter("noDeCompte");
            Compte unCompte = new Compte();
            unCompte.setNocompte(noDeCompte);
            ArrayList<Operation> listeOperations = GestionCompte.rechercheOperations(getDataSource(), unCompte);
            HttpSession session = request.getSession();
            session.setAttribute(Compte._COMPTE_COURANT, unCompte);
            session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
            getServletContext().getRequestDispatcher("/listeOperations.jsp").forward(request, response);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public DataSource getDataSource() {	
    	DataSource dataSource = null;
        try {			
            InitialContext initialContext = new InitialContext();	
            dataSource = (DataSource) initialContext.
                lookup("java:jboss/datasources/MaDSMySQL");	
        } catch (Exception e) {	
            System.err.println(e.getMessage());		
        }
        return dataSource;
    }

}