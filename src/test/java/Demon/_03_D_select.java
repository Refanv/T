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

public class _03_D_select {
    WebDriver driver;

    @BeforeTest
    public void baidu() {
        driver = SeleniumDriver.driverFactory("FF");
        driver.navigate().to("https:www.baidu.com/");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    @Test
    public void select() {
        WebElement search_setting = driver.findElement(By.linkText("设置"));
//        search_setting.click();invalid
        String url = search_setting.getAttribute("href");
        driver.get(url);//不打开一个新的选项卡
        WebElement sel = driver.findElement(By.name("NR"));

        Select select = new Select(sel);
//        select.selectByValue("20");
//        select.selectByVisibleText("");
        select.selectByIndex(2);//index [0,len-1]

        driver.findElement(By.id("save")).click();
        M.sp(1);
        //控制权移交之前最好等待1s
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());//已经记录下您的使用偏好
        alert.accept();
//        driver.switchTo().defaultContent();不用
//        driver.navigate().back();保存设置后，自动跳回主页
        M.sp(5);

    }
}
