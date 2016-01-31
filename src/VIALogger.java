import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by codygulley on 1/29/16.
 */
public class VIALogger {


    public String logLevel = "INFO";
    private LogWriter logWriter;

    public VIALogger(String fileName) throws IOException {
        logWriter = new LogWriter(fileName);
    }

    //Implement logging level logic based on value. DEBUG should contain all levels, info all but debug level, etc.
//    DEBUG is the lowest restricted java logging level and we should write everything we need to debug an application, this java logging mode should only be used on Development and Testing environment and must not be used in production environment.
//    INFO is more restricted than DEBUG java logging level and we should log messages which are informative purpose like Server has been started, Incoming messages, outgoing messages etc in INFO level logging in java.
//    WARN is more restricted than INFO java logging level and used to log warning sort of messages e.g. Connection lost between client and server. Database connection lost, Socket reaching to its limit. These messages and java logging level are almost important because you can setup alert on these logging messages in java and let your support team monitor health of your java application and react on this warning messages. In Summary WARN level is used to log warning message for logging in Java.
//    ERROR is the more restricted java logging level than WARN and used to log Errors and Exception, you can also setup alert on this java logging level and alert monitoring team to react on this messages. ERROR is serious for logging in Java and you should always print it.
//    FATAL java logging level designates very severe error events that will presumably lead the application to abort. After this mostly your application crashes and stopped.
//    OFF java logging level has the highest possible rank and is intended to turn off logging in Java.


    public void setLogLevel(String level) {
        if (level.equals("DEBUG") || level.equals("WARN") || level.equals("ERROR") || level.equals("INFO")) {
            logWriter.output(level, "Changing log level from " + logLevel + " to " + level);
            logLevel = level;
        }
    }

    public void log(String level, String message) {
//        System.out.print("CURRENT LOG LEVEL: " +logLevel+"\n");
        if (logLevel.equals("DEBUG") && (level.equals("DEBUG") || level.equals("INFO") || level.equals("WARN") || level.equals("ERROR"))) {
            logWriter.output(level, message);
        } else if (logLevel.equals(("INFO")) && level.equals("INFO") || level.equals("WARN") || level.equals("ERROR")) {
            logWriter.output(level, message);
        } else if (logLevel.equals("WARN") && (level.equals("WARN") || level.equals("ERROR"))) {
            logWriter.output(level, message);
        } else if (logLevel.equals("ERROR") && level.equals("ERROR")) {
            logWriter.output(level, message);
        }
    }
}