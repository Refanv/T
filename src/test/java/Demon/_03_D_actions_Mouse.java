package Demon;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class _03_D_actions_Mouse {
    WebDriver driver = SeleniumDriver.initialWebDriver("FF");;

    @BeforeTest
    public void baidu() {
        driver.navigate().to("https:www.baidu.com/");
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test
//    public void
    @Test
    public void moveToElement() {
        WebElement search_setting = driver.findElement(By.linkText("设置"));

        Actions action = new Actions(driver);
//        action.moveToElement(search_setting).moveByOffset(0, 5).click().perform();
        action.moveToElement(search_setting).perform();
        M.sp(2);

        WebElement setting = driver.findElement(By.xpath("//a[text()=\"搜索设置\"]"));
//        setting.click();//OK
        action.moveToElement(setting)
//                .pause(2000)
                .click()
                .perform();//OK

        M.sp(2);
    }

    @Test
    public void save() throws AWTException{
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);

        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_X);
        robot.keyRelease(KeyEvent.VK_X);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        M.sp(3);
    }

    @Test
    public void clickAndhold() {
        WebElement search_setting = driver.findElement(By.linkText("设置"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(search_setting)
                .perform();
//        M.sp(2);
        driver.findElement(By.xpath("//a[text()=\"搜索设置\"]")).click();

        actions.release()
                .perform();
    }
}
