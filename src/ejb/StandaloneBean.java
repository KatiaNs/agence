//package ejb;
//
//import java.util.concurrent.Future;
//
//import javax.ejb.AsyncResult;
//import javax.ejb.Asynchronous;
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//
///**
// * Session Bean implementation class StandaloneBean
// */
//@Stateless
//@LocalBean
//@Asynchronous
//public class StandaloneBean {
//
//    private static final String message = "Un message";
//    private int compteur = 0;
//
//    /**
//     * Default constructor. 
//     */
//
//    public StandaloneBean() {
//        // TODO Auto-generated constructor stub
//    }
//
//    @Asynchronous
//    public Future<String> returnMessageAsync() {
//        String status = message + " en mode async";
//        try {
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            System.err.println("Erreur : " + e.getMessage());
//        }
//        System.out.println("retour du résultat de la méthode appelée en mode async");
//        return new AsyncResult<String>(status);
//    }
//}