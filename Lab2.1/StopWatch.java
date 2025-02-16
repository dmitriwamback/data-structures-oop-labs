
import java.util.GregorianCalendar;

public class StopWatch {

    // variables
    private long startTime;
    private long endTime;

    // constructor
    public StopWatch() {
        // set the initial time
        GregorianCalendar calendar = new GregorianCalendar();
        startTime = calendar.getTimeInMillis();
    }

    public void start() {
        // start the time
        GregorianCalendar calendar = new GregorianCalendar();
        startTime = calendar.getTimeInMillis();
    }

    public void stop() {
        // end the time
        GregorianCalendar calendar = new GregorianCalendar();
        endTime = calendar.getTimeInMillis();
    }

    public long getElapsedTime() {
        // return the difference of the times
        // endTime will always be >= than startTime
        return endTime - startTime;
    }
}
