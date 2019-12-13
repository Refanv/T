package Demon;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
Alert
Confirm
Prompt
只处理JS的警告弹窗
div的弹窗（例如:登录框）是处理不了的
 */
public class _03_T_alert {

    WebDriver driver;

    @BeforeTest
    public void baidu() {
        driver = SeleniumDriver.driverFactory("FF");
        driver.navigate().to("https://www.baidu.com/gaoji/preferences.html");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    @Test
    public void accpet() {
        WebElement sel = driver.findElement(By.name("NR"));
        Select select = new Select(sel);
        select.selectByIndex(1);
        M.sp(1);
        driver.findElement(By.id("save")).click();
        M.sp(1);

        driver.switchTo().alert().accept();
        M.sp(2);
    }
/*
dismiss
getText
 */
    @Test
    public void getText() {
        WebElement sel = driver.findElement(By.name("NR"));
        Select select = new Select(sel);
        select.selectByIndex(1);
        driver.findElement(By.id("restore")).click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        M.sp(1);
        alert.dismiss();
        M.sp(2);
    }
}
