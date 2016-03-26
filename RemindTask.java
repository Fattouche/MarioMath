package helicopter;

import java.util.Timer;
import java.util.TimerTask;

//used to update the score and math question
public class RemindTask {
		public void start(){
	    int delay = 3000; // delay for 5 sec.
	    int period = 20000; // repeat every sec.
	    Timer timer = new Timer();

	    timer.scheduleAtFixedRate(new TimerTask() {
	      public void run() {
	        Board.timey++;
	      }
	    }, delay, period);
	  }
}