package ulitilities;


import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;


public class Log {
    private  static  final Logger _Log= LogManager.getLogger(Log.class);
    //Info Level Logs
    public static void info (String message) {
        _Log.info(message);
    }
    public static void info (Object object) {
        _Log.info(object);
    }

    //Warn Level Logs
    public static void warn (String message) {
        _Log.warn(message);
    }
    public static void warn (Object object) {
        _Log.warn(object);
    }

    //Error Level Logs
    public static void error (String message) {
        _Log.error(message);
    }
    public static void error (Object object) {
        _Log.error(object);
    }

    //Fatal Level Logs
    public static void fatal (String message) {
        _Log.fatal(message);
    }

    //Debug Level Logs
    public static void debug (String message) {
        _Log.debug(message);
    }
    public static void debug (Object object) {
        _Log.debug(object);
    }
}
