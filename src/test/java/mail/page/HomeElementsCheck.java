package mail.page;

import com.autoframework.driver.SeleniumDriver;
import com.po.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomeElementsCheck {

    private WebDriver driver;
    boolean display;
    String text;

    @BeforeTest
    void openURL() {
        driver = SeleniumDriver.driverFactory("FF");
        driver.navigate().to("https://mail.163.com/");
    }

    @AfterTest
    void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void assertElement_head() {
        boolean display;
        WebElement head = driver.findElement(Home.div_header);

        display = head.isDisplayed();
        System.out.println("head is enabled:" + head.isEnabled());
        System.out.println(head.getText());
        Assert.assertTrue(display, "div 163网易邮箱");
    }

    @Test
    void assertElement_h2(){
        boolean display;
        String text;
        WebElement h2 = driver.findElement(Home.h_login_title_text);
        text = h2.getText();
        display = h2.isDisplayed();
        System.out.println("h2 display = " + display);
        Assert.assertEquals(text, "手机扫码 安全登录", "手机扫码 安全登录");
    }

    @Test
    void assertElement_label() {
        boolean display;
        WebElement label_normal = driver.findElement(Home.div_lbNormal);
        display = label_normal.isDisplayed();
        System.out.println("label_normal is enabled:" + label_normal.isEnabled());
        Assert.assertTrue(display, "Label Normal");
    }

    @Test
    void assertElement_mailmaster() {
        String text;
        WebElement mailmaster = driver.findElement(Home.a_appLogin_mailmaster);

        /*
        Assert.assertEquals(text, " 网易邮箱大师 ", "带空格的? 不带");
        java.lang.AssertionError: 带空格的 expected [ 网易邮箱大师 ] but found [网易邮箱大师]
        Expected : 网易邮箱大师
        Actual   :网易邮箱大师
         */
        text = mailmaster.getText();
        Assert.assertEquals(text, "网易邮箱大师", "带空格的? 不带");
    }

    @Test
    void assertElement_switchLogIn() {
        String text;
        WebElement switchLogIn = driver.findElement(Home.a_switchAccountLogin);
        text = switchLogIn.getText();
        Assert.assertEquals(text, "密码登录", "密码登录");
//        System.out.println(text);密码登录
    }

    @Test
    void assertElement_regNew() {
        String text;
        WebElement regNew = driver.findElement(Home.a_app_register_new);

        text = regNew.getText();
        Assert.assertEquals(text, "注册新帐号", "注册新帐号");
    }
}
