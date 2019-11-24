package Demon;

import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class _02_T_Assert {
    WebDriver webDriver;

    @Test
    public void assertURL() {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.bilibili.com/");
        String str = webDriver.getCurrentUrl();
        Assert.assertEquals(str, "https://www.baidu.com/", "wrong url.");
    }

    @Test
    public void assertTitle() {
        System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.baidu.com/");
        String str = webDriver.getTitle();
        Assert.assertEquals(str, "百度一下，你就知道", "get wrong title");
    }

    @Test
    public void assertEquals_() {
        String a = "eu";
//        String b = "eu";
        String b = "edu";
        String c = null;

        Assert.assertEquals(a,b);
        System.out.println("------");
        Assert.assertEquals("ab","ab");
        System.out.println("======");
    }

    @Test
    public void assertEquals() {
        String a = "expected";
        String b = "actual";
        String c = null;
        //提示错误信息，用来解释失败的原因
        Assert.assertEquals(b,"actual","assertEquals");
        /*
            Asserts that two Strings are equal. If they are not,
         *  an AssertionError, with the given message, is thrown.
         */
        Assert.assertEquals(a, "expected");
        System.out.println("ex");
        System.out.println("ex");
        Assert.assertNull(c);
        System.out.println("null");
    }

    @Test
    public void assertNotEquals()
    {
        String a = "expected";
        String b = "actual";

        Assert.assertNotEquals(b,a,"assertNotEquals");
    }

    @Test
    public void assertNull_fail() {
        String a = "abc";//空值
        webDriver = SeleniumDriver.initialWebDriver("ff");
        Assert.assertNull(a);
        webDriver.quit();//校验失败，不会执行关闭浏览器;在AfterTest中可以关闭
    }

    @AfterTest
    public void close() {
        if (null != webDriver) {
            webDriver.quit();
        }
    }
}
