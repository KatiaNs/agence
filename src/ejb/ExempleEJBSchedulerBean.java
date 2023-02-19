//package ejb;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Date;
//
//import javax.annotation.Resource;
//import javax.ejb.Schedule;
//import javax.ejb.Stateless;
//import javax.ejb.Timer;
//import javax.ejb.TimerService;
//
//@Stateless
//public class ExempleEJBSchedulerBean implements ExempleEJBScheduler {
//
//
//	  @Resource
//	  TimerService timerService;
//	  
//    /**
//     * Default constructor. 
//     */
//    public ExempleEJBSchedulerBean() {
//        // TODO Auto-generated constructor stub
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
//	@Schedule(second="*/5", minute="54-58", hour="0-23", dayOfWeek="Mon-Fri",
//      dayOfMonth="*", month="*", year="*", info="MyTimer")
//    public void logMessagePlanifie() {
//        System.out.println("@Schedule called at: " + new Date());
//    }
//}