package Demon;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;

public class _02_T_window_path {
    WebDriver driver;

//    @Test
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

//    @Test
    public void openFF() {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void path() {
        File file = new File("./");
        System.out.println(file.getAbsolutePath());//D:\projects\IdeaProjects\Se\.
        System.out.println(file.getParent());//null
        System.out.println(file.getName());//.
        System.out.println(file.length());//4096
    }

    @Test
    public void window() {
        driver = SeleniumDriver.initialWebDriver("chrome");
        //print handler
        String handler = driver.getWindowHandle();
        System.out.println("handler = " + handler);
        //set window maximize
        driver.manage().window().maximize();
        System.out.println("maximize");
        M.sp(1);
        //set size
        driver.manage().window().setSize(new Dimension(500, 500));
        M.sp(1);
        //get position & set position
        Point pos = driver.manage().window().getPosition();
        System.out.println("getPosition:" + pos);
        driver.manage().window().setPosition(new Point(550, 300));
        M.sp(1);
        //get fullscreen size
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().maximize();
        System.out.println(driver.manage().window().getSize());
        driver.manage().window().fullscreen();
        System.out.println(driver.manage().window().getSize());

    }

    @AfterTest
    public void closeAll() {
        if (null != driver) {
            driver.quit();
        }
    }
}
