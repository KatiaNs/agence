//package ejb;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Date;
//
//import javax.annotation.Resource;
//import javax.ejb.Stateless;
//import javax.ejb.Timeout;
//import javax.ejb.Timer;
//import javax.ejb.TimerService;
//
//@Stateless
//public class ExempleEJBTimerBean implements ExempleEJBTimer {
//
//
//	  @Resource
//	  TimerService timerService;
//	  
//    /**
//     * Default constructor. 
//     */
//    public ExempleEJBTimerBean() {
//        // TODO Auto-generated constructor stub
//    }
//	
//    public void startTimer(Serializable info) {
//        Timer timer = timerService.createTimer(new Date(), 5000, info);
//    }
//
//    public void stopTimer(Serializable info) {
//        Timer timer;
//        Collection timers = timerService.getTimers();
//        for (Object object : timers) {
//            timer = ((Timer) object);
//            if (timer.getInfo().equals(info)) {
//                timer.cancel();
//                break;
//            }
//        }
//    }
//
//    @Timeout
//    public void logMessage(Timer timer) {
//    	System.out.println("Message produit par :" + timer.getInfo()
//                + " at " + System.currentTimeMillis());
//    }
//}