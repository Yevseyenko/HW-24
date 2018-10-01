package com.epam.driverConfig;

import org.openqa.selenium.WebDriver;


public class DriverPool {

    //  private static final ThreadLocal<WebDriver> localWebDriver = new ThreadLocal<WebDriver>();

    private DriverPool() {
    }
    private static final ThreadLocal<WebDriver> localDrivers= new ThreadLocal<WebDriver>(){
        protected WebDriver initialValue(){
            DriverConfiguration config = new DriverConfiguration();
            WebDriver webDriver;
            webDriver = config.configureDriver();
            return webDriver;
        }
    };

    public static WebDriver getDriver(){
        return localDrivers.get();
    }
    public static void quit() {
        try {
            localDrivers.get().quit();
        } finally {
            localDrivers.remove();
        }
    }
}

