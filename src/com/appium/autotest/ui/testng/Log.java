package com.appium.autotest.ui.testng;

import org.apache.log4j.*;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Log {
    private static Logger logger;
    private static String filePath = "src/log4j.properties";

    static {
        logger = Logger.getLogger("dev_log");
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }

    /**
     * 记录Info级别日志。
     *
     * @param message the message object.
     */
    public static void logInfo(Object message) {
        logger.info("[INFO] " + message);
        Reporter.log(getSimpleDateFormat() + " : " + "[INFO] " + message);
    }

    /**
     * 记录测试步骤信息。
     *
     * @param message the message object.
     */
    public static void logStep(Object message) {
        logger.info("[STEP] " + message);
        Reporter.log(getSimpleDateFormat() + " : " + "[STEP] " + message);
    }

    /**
     * 记录测试流日志。
     *
     * @param message the message object.
     */
    public static void logFlow(Object message) {
        logger.info("[FLOW] " + message);
        Reporter.log(getSimpleDateFormat() + " : " + "[FLOW] " + message);
    }

    /**
     * 记录Error级别日志。
     *
     * @param message the message object.
     */
    public static void logError(Object message) {
        logger.error("[ERROR]   " + message);
        Reporter.log(getSimpleDateFormat() + " : " + "[ERROR]   " + message);
    }

    /**
     * 记录Warn级别日志。
     *
     * @param message the message object.
     */
    public static void logWarn(Object message) {
        logger.warn("[WARN] " + message);
        Reporter.log(getSimpleDateFormat() + " : " + "[WARN] " + message);
    }
    /**
     * 返回当前时间，格式为：2014-12-18 15:11:50
     *
     * @return String
     */
    public static String getSimpleDateFormat() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }
}
