package exam.rent.server.utility;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Utility {
    public static String getStringFromStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        String exception = sw.toString();

        return exception;
    }
}
