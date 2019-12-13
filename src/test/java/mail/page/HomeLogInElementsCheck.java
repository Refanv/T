package mail.page;

import com.autoframework.driver.SeleniumDriver;
import com.po.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class HomeLogInElementsCheck {
    WebDriver driver;

    @BeforeClass
    void openURL() {
        driver = SeleniumDriver.driverFactory("FF");
        driver.navigate().to("https://mail.163.com/");

        //switch to iframe
//        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//        System.out.println("iframes amounts: " + iframes.size());
//        driver.switchTo().frame(iframes.get(0));OK

//        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));OK

//        driver.switchTo().frame(2); Exception

//        driver.switchTo().frame(elem_iframe);
        if (driver.findElement(Home.div_lbNormal).isDisplayed()) {
            driver.findElement(Home.div_lbNormal).click();
        }
        WebElement iframe = driver.findElement(Home.div_iframe).findElement(Home.iframe);
        driver.switchTo().frame(iframe);

        System.out.println("Button isEnabled" + driver.findElement(Home.button_logOn).isEnabled());
        System.out.println("Button isDisplayed" + driver.findElement(Home.button_logOn).isDisplayed());
        System.out.println("Button isSelected" + driver.findElement(Home.button_logOn).isSelected());
    }

    @AfterClass
    void quitBrowser() {
        if (driver != null) {
            driver.switchTo().defaultContent();
            driver.quit();
        }
    }

//    @Test todo如何指定test测试先后
    void assertElement_lbApp() {
        driver.switchTo().defaultContent();
        boolean display;
        driver.findElement(Home.div_lbNormal).click();

        display = driver.findElement(Home.div_lbNormal).isDisplayed();
        Assert.assertFalse(display, "Label Normal is Displayed.");

        display = driver.findElement(Home.lbApp).isDisplayed();
        Assert.assertTrue(display, "Label App is't Displayed.");

    }

    @Test
    void assertElement_loginform() {
        boolean display;
        WebElement form = driver.findElement(Home.loginform);
        display = form.isDisplayed();
        Assert.assertTrue(display, "can't find form.");
        List<WebElement> form_divs = form.findElements(By.tagName("div"));
        System.out.println("div size:" + form_divs.size());
    }

    @Test
    void assertElement_domain() {
        String text;
        text = driver.findElement(Home.at163_text).getText();
        Assert.assertEquals(text, "@163.com", "Not \"@163.com\"");
    }

    @Test
    void assertElement_Emailplaceholder() {
        String text;
        text = driver.findElement(Home.email).getAttribute("placeholder");
        Assert.assertEquals(text, "邮箱帐号或手机号码", "email用户名提示信息出错");
    }

    @Test
    void assertElement_Passwordplaceholder() {
        String text;
        text = driver.findElement(Home.password).getAttribute("placeholder");
        Assert.assertEquals(text, "输入密码", "输入密码提示信息出错");
    }

    @Test
    void assertElement_checkbox() {
        boolean selected;
        selected = driver.findElement(Home.checkbox).isSelected();
        Assert.assertFalse(selected, "ckeckbox is selected");
    }

    @Test
    void assertElement_checkbox_label(){
        String text;
        text = driver.findElement(Home.checkbox_label).getText();
        Assert.assertEquals(text, "十天内免登录", "校验 十天内免登录 内容是否正常");
    }

    @Test
    void assertElement_forgetPassword() {
        String text;
        text = driver.findElement(Home.forgetPassword).getText();
        Assert.assertEquals(text, "忘记密码？", "校验 忘记密码？ 内容是否正常失败");
    }

    @Test
    void assertElement_register_new() {
        String text;
        WebElement reg = driver.findElement(Home.a_normal_register_new);
        text = reg.getText();
        Assert.assertEquals(text, "注册新帐号", "校验 注册新帐号 内容是否正常显示 失败");
        text = reg.getAttribute("href");
        Assert.assertEquals(text, "https://mail.163.com/register/index.htm?from=163mail", "校验“注册新账号的链接是否正确”");
    }
}
