package com.epam.util.driverConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class DriverConfiguration {

    private static final Logger log = LogManager.getLogger("log4j2");
    WebDriver driver;

    public WebDriver configureDriver() {
        DriverParameters driverParameters = new DriverParameters();

        try {
            System.setProperty(driverParameters.getProp(driverParameters.webdriver), driverParameters.getProp(driverParameters.driverPath));
            driver = new ChromeDriver();
            driver.get("http://www.google.com.ua");
            driver.manage().timeouts().implicitlyWait(parseInt(driverParameters.getProp(driverParameters.delay)), TimeUnit.SECONDS);

        } catch (IOException e) {
            log.info(e.getMessage());
        }
        return driver;

    }


}