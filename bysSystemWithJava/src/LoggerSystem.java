import java.io.IOException;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerSystem {

    

    private final Logger logger = Logger.getLogger(Logger.class.getName());
    
    
    public Logger getLogger() {
        return logger;
    }

    public LoggerSystem() {
                
        Locale.setDefault(Locale.ENGLISH);

        try {
            FileHandler fileHandler = new FileHandler("logs/systemLog.log",true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "An unexpected error occurred", e);
        }

        Logger rootLogger = Logger.getLogger("");
        for (java.util.logging.Handler handler : rootLogger.getHandlers()) {
            rootLogger.removeHandler(handler);
        }
        logger.log(Level.INFO, "New logging system started.");
    }
 
}
