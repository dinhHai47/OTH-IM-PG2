package uebung_9_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log4jTestMain
{

    // Logger init
    private static Logger logger = Logger.getLogger(Log4jTestMain.class);

    public static void main(String[] args)
    {

        // Option 1: Basic Configurator
        // BasicConfigurator.configure();

        // Option 2: log4JPropertyFile
        try
        {
            String log4JPropertyFile = "src/uebung_9_2/log4j.properties";
            Properties p = new Properties();
            p.load(new FileInputStream(log4JPropertyFile));

            PropertyConfigurator.configure(p);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // Setting the log level - DEBUG, INFO, WARN, ERROR, FATAL
        logger.setLevel(Level.DEBUG);

        logger.debug("Meine Debug-Meldung");
        logger.info("Meine Info-Meldung");
        logger.warn("Meine Warn-Meldung");
        logger.error("Meine Error-Meldung");
        logger.fatal("Meine Fatal-Meldung");

    }

}