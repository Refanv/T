package Demon;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.swing.*;

public class _02_T_navigate {
    private WebDriver webDriver;

    @Test
    public void navigate() {
//        WebDriver webDriver = SeleniumDriver.initialWebDriver("FF");局部变量同名，会覆盖成员变量
        webDriver = SeleniumDriver.initialWebDriver("FF");
        webDriver.manage().window().maximize();
        webDriver.get("https://www.bilibili.com");
        M.sp(1);
        String str = webDriver.getCurrentUrl();
        Assert.assertEquals(str, "https://www.bilibili.com/", "wrong url.");//校验失败，不在向下执行，不会执行关闭浏览器;在AfterTest中可以关闭

        webDriver.navigate().to("https://www.baidu.com/");
        webDriver.navigate().refresh();
        String title = webDriver.getTitle();
        Assert.assertEquals(title, "百度一下，你就知道", "wrong title");
        M.sp(1);
        webDriver.navigate().back();
        M.sp(1);
        webDriver.navigate().forward();
        M.sp(1);
    }

    @Test
    public void assertNotEquals()
    {
        String a = "expected";
        String b = "actual";

        Assert.assertNotEquals(b,a,"assertNotEquals");
    }

    @Test
    public void assertNotNull() {
        String a = "abc";//空值
        Assert.assertNotNull(a);
    }

    @AfterTest
    public void quit() {
        if (null != webDriver) {
            System.out.println("webDriver is Not Null");
            webDriver.quit();
        } else {
            System.out.println("webDriver is Null");
        }
    }
}
