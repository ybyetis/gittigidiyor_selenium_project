package testing;

import org.apache.log4j.Logger;

public class LogHelper {
    
	private static Logger logger = Logger.getLogger(LogHelper.class.getName());

    //Info
    public static void info (String message) {
        logger.info(message);
    }

}
