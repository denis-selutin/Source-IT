import org.apache.log4j.Logger;

/**
 *
 */
public class Log4jClass {
    private static final Logger logger = Logger.getLogger(Log4jClass.class);
    private static final Logger dbLogger = Logger.getLogger("Log4jClass");

    public static void main(String[] args) {
        logger.info("Some info");
        logger.error("Some error");
        logger.debug("Some debug");
        logger.warn("Some warn");
        logger.fatal("some fatal!!");
    }

    public void doSmth() {
        System.out.println("dosmth in Log4jClass");
        dbLogger.info("dosmth in Log4jClass");
        dbLogger.warn("This is from dosmth in Log4jClass");
    }

}
