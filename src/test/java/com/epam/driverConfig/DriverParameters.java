package com.epam.driverConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverParameters {
    private static final Logger log = LogManager.getLogger("log4j2");
    public String webdriver = "webdriver";
    public String delay = "delay";
    public String driverPath = "driverpath";
    private String result = "";
    private InputStream inputStream;

    public String getProp(String driver1) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "parameters.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            String driverPath = prop.getProperty(driver1);
            result = driverPath;
        } catch (Exception e) {
            log.info("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }

}
