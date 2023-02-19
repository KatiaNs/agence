//package session4;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//import java.util.concurrent.Future;
//
//import javax.ejb.EJB;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import beans.Compte;
//import beans.Operation;
//import beans.GestionCompte;
//import ejb.ServicesCompteBean;
//import ejb.StandaloneBean;
//import ejb.ExempleEJBScheduler;
//import ejb.ExempleEJBTimer;
//import ejb.ExempleEJBTimerBean;
//import ejb.ServicesCompte;
//
//import java.util.ArrayList;
//import javax.servlet.http.HttpSession;
//
//
///**
// * Servlet implementation class ServletPrincipal
// */
//@WebServlet("/ServletPrincipal6Scheduler")
//public class ServletPrincipal6Scheduler extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//    private DataSource dataSource = null;
//
//    //Déclaration d'un EJB via la no-interface-view
//    //@EJB
//    //ServicesCompteBean servicesCompteBean;
//
//    //Déclaration d'un EJB au traves de sa business interface
//    @EJB
//    ServicesCompte servicesCompte;
//   
//    //Déclaration d'un EJB StandaloneBean (de type asynchrone)
//    @EJB
//    StandaloneBean standaloneBean;
//
//    //Déclaration d'un EJB Timer
//    @EJB
//    ExempleEJBTimer exempleEJBTimer;
//
//    //Déclaration d'un EJB Sheduler
//    @EJB
//    ExempleEJBScheduler exempleEJBScheduler;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ServletPrincipal6Scheduler() {
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
//			append("Entrée dans la servlet à : ").append(new Date().toLocaleString()).
//			append("\nRequestURL : ").append(request.getRequestURI()).
//			append("\nContextPath : ").append(request.getContextPath()).
//			append("\nServletPath : ").append(request.getServletPath()).
//			append("\nMethod : ").append(request.getMethod()).
//			append("\nProtocol : ").append(request.getProtocol()).
//			append("\nRemoteHost : ").append(request.getRemoteHost()).
//			append("\nLocale country : ").append(request.getLocale().getCountry()).
//			append("\nLocale language : ").append(request.getLocale().getDisplayLanguage()).
//			append("\nParamètre prénom = ").append(request.getParameter("prénom")).
//			append("\nParamètre nom = ").append(request.getParameter("nom"));
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
//            response.getWriter().append("\nConnexion à la DB ok le ").append(new Date().toLocaleString());
//        } catch (Exception e2) {
//        	response.getWriter().append("\nProblème de connexion à la DB : ").append(new Date().toLocaleString());
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
//    	doPostVersion9(request, response);
//    }
//
//    protected void doPostVersion1(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            response.getWriter().append("<h2>Instanciation d'un compte avec n° de compte = ").
//            	append(unCompte.getNocompte()).append("</h2>");
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//    }
//
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
//            response.getWriter().append("<h2>Liste des opérations sur ce compte : </h2>");
//            Operation op = null;
//            for (int i = 0; i < listeOperations.size(); i++) {
//                op = (Operation) listeOperations.get(i);
//                response.getWriter().
//                		append("<h3>Opération n° ").
//                		append(new Integer(op.getIdOperation()).toString()).
//                        append(" de type '" + op.getOperation()).
//                        append("' effectuée le ").
//                        append(op.getDateOperation()).
//                        append(" à ").
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
///*    protected void doPostVersion4(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//            ArrayList<Operation> listeOperations = servicesCompteBean.rechercheOperations(unCompte);
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
//    protected void doPostVersion6(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//        	System.out.println("Méthode doPostVersion6");
//            response.setContentType("text/html");
//            String noDeCompte = request.getParameter("noDeCompte");
//            Compte unCompte = new Compte();
//            unCompte.setNocompte(noDeCompte);
//
//            InitialContext initialContext = new InitialContext();
//            ServicesCompte servicesCompte = (ServicesCompte) initialContext
//                    .lookup("java:global/BanqueTestWeb/ServicesCompteBean!fr.dauphine.mido.as.banquetest.ejb.ServicesCompte");
//
//            ArrayList<Operation> listeOperations = servicesCompte
//                    .rechercheOperations(unCompte);
//            HttpSession session = request.getSession();
//            session.setAttribute(Compte._COMPTE_COURANT, unCompte);
//            session.setAttribute(Compte._LISTE_OPERATIONS, listeOperations);
//            getServletContext().getRequestDispatcher("/listeOperations.jsp")
//                    .forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    protected void doPostVersion7(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        try {
//        	System.out.println("Méthode doPostVersion7");
//        	response.setContentType("text/html");
//            HttpSession session = request.getSession();
//            String noDeCompte = request.getParameter("noDeCompte");
//            // Standalone bean
//            Future<String>resultatAsync = standaloneBean.returnMessageAsync();
//            while (!resultatAsync.isDone()) {
//                try {
//                    System.out.println("On patiente... avec un traitement en //");
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    System.out.println("Erreur : " + e.getMessage());
//                }
//            }
//            System.out.println("le résultat est arrivé : "+ resultatAsync.get());
//            PrintWriter printWriter = response.getWriter();
//            printWriter.println("<h2>");
//            printWriter.println("C'est fait");
//            printWriter.println("</h2>");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//     }
//
//    protected void doPostVersion8(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        try {
//        	System.out.println("Méthode doPostVersion8");
//        	response.setContentType("text/html");
//            HttpSession session = request.getSession();
//            String noDeCompte = request.getParameter("noDeCompte");
//            // Timer bean
//            try {
//                System.out.println("Démarrage du timer 1...");
//                exempleEJBTimer.startTimer("Timer 1");
//                System.out.println("Attente pour 2 secondes...");
//                Thread.sleep(2000);
//                System.out.println("Démarrage du timer 2...");
//                exempleEJBTimer.startTimer("Timer 2");
//                System.out.println("Attente pour 30 secondes...");
//                Thread.sleep(30000);
//                System.out.println("Arrêt du timer 1...");
//                exempleEJBTimer.stopTimer("Timer 1");
//                System.out.println("Arrêt du timer 2...");
//                exempleEJBTimer.stopTimer("Timer 2");
//                System.out.println("Terminé...");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("C'est fait");
//            PrintWriter printWriter = response.getWriter();
//            printWriter.println("<h2>");
//            printWriter.println("C'est fait");
//            printWriter.println("</h2>");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//     }
//
//    protected void doPostVersion9(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
//        // TODO Auto-generated method stub
//        try {
//        	System.out.println("Méthode doPostVersion9");
//        	response.setContentType("text/html");
//            HttpSession session = request.getSession();
//            String noDeCompte = request.getParameter("noDeCompte");
//            if(noDeCompte != null && noDeCompte.equals("0000")) {
//            	System.out.println("Arrêt du Log planifié");
//            	exempleEJBScheduler.stopTimer("MyTimer");
//            }
//            PrintWriter printWriter = response.getWriter();
//            printWriter.println("<h2>");
//            printWriter.println("Arrêt du Log planifié");
//            printWriter.println("</h2>");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//     }
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