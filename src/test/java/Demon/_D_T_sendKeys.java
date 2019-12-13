package Demon;

import com.autoframework.M;
import com.autoframework.driver.CapScreen;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class _D_T_sendKeys {
    WebDriver driver = SeleniumDriver.driverFactory("FF");

    @BeforeTest
    void open() {
        driver.get("https://www.baidu.com/");
    }

    @AfterTest
    void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void _T_sendKeys() {
        WebElement input = driver.findElement(By.id("kw"));
        input.sendKeys("ABC");
//        input.sendKeys(Keys.CONTROL + "a");OK
        input.sendKeys(Keys.ENTER);
        M.sp(1);
        CapScreen.screenShot(driver);
    }
}
