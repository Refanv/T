package Demon;

import com.autoframework.M;
import com.autoframework.driver.CapScreen;
import com.autoframework.driver.SeleniumDriver;
import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _D_iframe_LogIn {
    WebDriver driver;

    @BeforeTest
    public void baidu() {
        driver = SeleniumDriver.initialWebDriver("FF");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.126.com/");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
/*
元素displayed校验
 */
    @Test
    public void assert_App_Normal() {
        WebElement lbNormal = driver.findElement(By.id("lbNormal"));
        Assert.assertTrue(lbNormal.isDisplayed(), "lbNormal is'n displayed.");
        lbNormal.click();

        WebElement lbApp = driver.findElement(By.id("lbApp"));
        Assert.assertTrue(lbApp.isDisplayed(), "lbApp is'n displayed.");
        Assert.assertFalse(lbNormal.isDisplayed(), "lbNormal is displayed.");
        M.sp(3);
    }

    @Test
    public void iframe() {
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.findElement(By.id("lbNormal")).click();

        driver.switchTo().frame(iframe);
        WebElement account = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        account.clear();
        account.sendKeys("abcdefg");
        M.sp(1);
        account.clear();
        account.sendKeys("909090909");
        password.clear();
        password.sendKeys("123456");
/*
1.iframe是层层转交的，回来的也一样
2.frame(NameorId) 当传入一个String时
3.不推荐用index int
4.在iframe中截图是不一样的
5.获取当前方法的className And MethodName
 */
        CapScreen.screenShot(driver);
//        System.out.println("_D_iframe_LogIn.iframe");//solm
        M.sp(1);
        /**
         * Selects either the first frame on the page, or the main document when a page contains
         * iframes.
         *
         * @return This driver focused on the top window/first frame.
         */
//        driver.switchTo().defaultContent();
        /**
         * Change focus to the parent context. If the current context is the top level browsing context,
         * the context remains unchanged.
         *
         * @return This driver focused on the parent frame
         */
        driver.switchTo().parentFrame();
//        CapScreen.screenShot(driver, getClass().getName());//_D_iframe_LogIn.iframe
        CapScreen.screenShot(driver, "_D_iframe_LogIn.iframe");
        M.sp(3);
    }

}
