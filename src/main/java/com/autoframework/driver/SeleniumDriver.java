package com.autoframework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDriver {
    private static WebDriver driver;
    
    public static WebDriver initialWebDriver(String browser) {
        //get path user.dir
        String path = System.getProperty("user.dir");
        System.out.println("path = " + path);
        if (browser.equalsIgnoreCase("ff") || browser.equalsIgnoreCase("FireFox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            //todo
        } else if (browser.equalsIgnoreCase("JS")) {
            //todo
        } else {
            System.out.println("Wrong input:" + browser);
        }

        return driver;
    }
}