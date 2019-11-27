package com.autoframework.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private static WebDriver driver;
    
    public static WebDriver initialWebDriver(String browser) {
        /*get path user.dir
        String path = System.getProperty("user.dir");path = D:\projects\IdeaProjects\Se
        System.out.println("path = " + path);
         */
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

        if (driver != null) {
            init();
        }
        return driver;
    }

    private static void init() {
        driver.manage().window().maximize();
        /*
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        org.openqa.selenium.TimeoutException: Timeout loading page after 1000ms
         */
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //对所有的元素都有效
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
