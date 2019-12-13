package com.autoframework.driver;

import okio.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumDriver {
    private static WebDriver driver;
    
    public static WebDriver driverFactory(String browser) {

        setDriver(browser);

        if (driver != null) defaultInit();

        return driver;
    }

    public static WebDriver driverFactory(String browser, int pageLoadTime, int implicitlyWait) {
        setDriver(browser);
        if (driver != null) Init(pageLoadTime, implicitlyWait);
        return driver;
    }

    private static void setDriver(String browser) {
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
            System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("JS")) {
            //todo
        } else {
            System.out.println("Wrong input:" + browser);
        }
    }

    public static void switchWindow(WebDriver driver) {
        Set<String> handlers = driver.getWindowHandles();
        System.out.println("handler Set size:" + handlers.size());//执行太快会拿到不新标签的handler
        String currentHandler = driver.getWindowHandle();
        for (String handler : handlers) {
            if (currentHandler.equals(handler)) continue;
            driver.switchTo().window(handler);
        }
    }

    private static void defaultInit() {
        driver.manage().window().maximize();
        /*
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        org.openqa.selenium.TimeoutException: Timeout loading page after 1000ms
         */
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //对所有的元素都有效
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void Init(int pageLoadTime, int wait) {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }
}
