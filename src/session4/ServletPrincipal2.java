//package session4;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//
//import javax.ejb.EJB;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import beans.Compte;
//import beans.Operation;
//import ejb.ServicesCompte;
//import ejb.ServicesCompteBean;
//
//import java.util.ArrayList;
//import javax.servlet.http.HttpSession;
//
//
///**
// * Servlet implementation class ServletPrincipal
// */
//@WebServlet("/ServletPrincipal2")
//public class ServletPrincipal2 extends HttpServlet {
//	
//	private static final long serialVersionUID = 1L;
//    private DataSource dataSource = null;
//
//    //D claration de l'EJB directement via la no-interface-view
//    //@EJB
//    //ServicesCompteBean servicesCompteBean;
//
//    //D claration de l'EJB au traves d une interface
//    @EJB
//    ServicesCompte servicesCompte;
//   
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ServletPrincipal2() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//    @SuppressWarnings("deprecation")
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		goGetVersion1(request, response);
//		doGetVersion2(request, response);
//	}
//
//    @SuppressWarnings("deprecation")
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void goGetVersion1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().
//			append("Entr e dans la servlet   : ").append(new Date().toLocaleString()).
//			append("\nRequestURL : ").append(request.getRequestURI()).
//			append("\nContextPath : ").append(request.getContextPath()).
//			append("\nServletPath : ").append(request.getServletPath()).
//			append("\nMethod : ").append(request.getMethod()).
//			append("\nProtocol : ").append(request.getProtocol()).
//			append("\nRemoteHost : ").append(request.getRemoteHost()).
//			append("\nLocale country : ").append(request.getLocale().getCountry()).
//			append("\nLocale language : ").append(request.getLocale().getDisplayLanguage()).
//			append("\nParam tre pr nom = ").append(request.getParameter("pr nom")).
//			append("\nParam tre nom = ").append(request.getParameter("nom"));
//	}
//
//    @SuppressWarnings("deprecation")
//    protected void doGetVersion2(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            InitialContext initialContext = new InitialContext();
//            javax.sql.DataSource dataSource = (DataSource) initialContext.lookup("java:jboss/datasources/MaDSMySQL");
//            Connection connection = dataSource.getConnection();
//            connection.close();
//            response.getWriter().append("\nConnexion   la DB ok le ").append(new Date().toLocaleString());
//        } catch (Exception e2) {
//        	response.getWriter().append("\nProbl me de connexion   la DB : ").append(new Date().toLocaleString());
//            System.out.println(e2.getMessage().toString());
//        }
//    }
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//    /**
//     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
//     *      response)
//     */
//    protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//    	doPostVersion5(request, response);
//    }
//
//    protected void doPostVersion1(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            response.getWriter().append("<h2>Instanciation d'un compte avec n  de compte = ").
//            	append(unCompte.getNocompte()).append("</h2>");
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
///*
//    @SuppressWarnings("deprecation")
//    protected void doPostVersion2(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//
//            ArrayList<Operation> listeOperations = GestionCompte
//                    .rechercheOperations(getDataSource(), unCompte);
//            response.getWriter().append("<h2>Liste des op rations sur ce compte : </h2>");
//            Operation op = null;
//            for (int i = 0; i < listeOperations.size(); i++) {
//                op = (Operation) listeOperations.get(i);
//                response.getWriter().
//                		append("<h3>Op ration n  ").
//                		append(new Integer(op.getIdOperation()).toString()).
//                        append(" de type '" + op.getOperation()).
//                        append("' effectu e le ").
//                        append(op.getDateOperation()).
//                        append("   ").
//                        append(op.getHeureOperation()).
//                        append(" d'un montant de ").
//                        append(new Float(op.getValeur()).toString()).
//                        append(" euros</h3>");
//            }
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
//
//    protected void doPostVersion3(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            ArrayList<Operation> listeOperations = GestionCompte.rechercheOperations(getDataSource(), unCompte);
//            HttpSession session = request.getSession();
//            session.setAttribute(Compte._COMPTE_COURANT, unCompte);
//            session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
//            getServletContext().getRequestDispatcher("/listeOperations.jsp").forward(request, response);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
//
//    protected void doPostVersion4(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            ArrayList<Operation> listeOperations = servicesCompte.rechercheOperations(unCompte);
//            HttpSession session = request.getSession();
//            session.setAttribute(Compte._COMPTE_COURANT, unCompte);
//            session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
//            getServletContext().getRequestDispatcher("/listeOperations.jsp")
//                    .forward(request, response);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    } 
//*/
//
//    protected void doPostVersion5(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            ArrayList<Operation> listeOperations = servicesCompte.rechercheOperations(unCompte);
//            HttpSession session = request.getSession();
//            session.setAttribute(Compte._COMPTE_COURANT, unCompte);
//            session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
//            getServletContext().getRequestDispatcher("/listeOperations.jsp")
//                    .forward(request, response);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    } 
//
//    public DataSource getDataSource() {		
//        if (null == dataSource) {
//            try {			
//                InitialContext initialContext = new InitialContext();	
//                dataSource = (DataSource) initialContext.
//                    lookup("java:jboss/datasources/MaDSMySQL");	
//            } catch (Exception e) {	
//                System.err.println(e.getMessage());		
//            }
//        }
//        return dataSource;
//    }
//
//}