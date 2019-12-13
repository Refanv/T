package mail.test_cases;

import com.autoframework.M;
import com.autoframework.driver.CapScreen;
import com.autoframework.driver.SeleniumDriver;
import com.pages.mail.LogIn;
import com.pages.mail.Mail;
import com.pages.mail.Register;
import com.po.Home;
import com.po.Mail163;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class _Ex_2 {
    WebDriver driver = SeleniumDriver.driverFactory("FF");

    @BeforeTest
    void openUrl() {
        driver.navigate().to("https://mail.163.com/");
    }

    @AfterTest
    void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void regis() {
        driver.findElement(Home.div_lbNormal).click();//ElementNotInteractableException
        WebElement iframe = driver.findElement(Home.div_iframe).findElement(Home.iframe);
        driver.switchTo().frame(iframe);
//        driver.switchTo().frame(Home.elem_iframe);
        System.out.println(driver.findElement(Home.a_normal_register_new).isDisplayed());
        driver.findElement(Home.a_normal_register_new).click();
//        driver.switchTo().defaultContent();OK

        String handler = driver.getWindowHandle();
        Set<String> handlers = driver.getWindowHandles();
        for (String s : handlers) {
            if (handler.equals(s)) continue;
            driver.switchTo().window(s);
        }

        M.sp(2);
    }

    @Test
    void regis_err() {
        WebElement iframe = driver.findElement(Home.div_iframe).findElement(Home.iframe);
        driver.switchTo().frame(iframe);
        System.out.println(driver.findElement(Home.a_normal_register_new).isDisplayed());//False
        driver.findElement(Home.a_normal_register_new).click();

        String handler = driver.getWindowHandle();
        SeleniumDriver.switchWindow(driver);
    }

    @Test
    void regNew() {
        LogIn.register(driver);
        Register.regisgter(driver);
        CapScreen.screenShot(driver);
        SeleniumDriver.switchWindow(driver);
        CapScreen.screenShot(driver);
    }

    @Test
    void logIn(String account, String pwd) {
        LogIn.login(driver, account, pwd);
    }

    @Test
    void getTitles(String account, String pwd) {
        LogIn.login(driver, account, pwd);
        Mail.getTitles(driver);
        CapScreen.screenShot(driver);
    }

    @Test
    void sendEmail(String account, String pwd) {
        LogIn.login(driver, account, pwd);

        Mail.editEmail(driver);
        driver.findElement(Mail163.span_send).click();

        WebElement h1 = driver.findElement(Mail163.h1_assert);

        WebElement ok = h1.findElement(By.tagName("b"));
        System.out.println(ok.getLocation().toString() + ok.getAttribute("class"));//(784, 164)nui-ico se0 pv1

        WebElement ok_2 = h1.findElement(By.xpath("./b"));//nui-ico se0 pv1
        System.out.println(ok_2.getLocation().toString() + ok_2.getAttribute("class"));

//        WebElement ok_3 = h1.findElement(By.xpath("//b[starts-with(@class,'nui-ico')]"));//(415, 14)nui-ico
        WebElement ok_3 = h1.findElement(By.xpath("//b[starts-with(@class,'nui-ico') and not(@style)]"));//(415, 14)nui-ico
        System.out.println(ok_3.getLocation().toString() + ok_3.getAttribute("class"));
        System.out.println(ok.getSize().toString());
        System.out.println(ok_3.getSize().toString());
//        Assert.assertTrue(ok_3.isDisplayed(), "not OK");

//        String text = h1.getText();//送成功手机收发邮件更方便
//        System.out.println("text = " + text);
        /*
        Assert.assertEquals(text, "发送成功", "fail.");
        java.lang.AssertionError: fail. expected [发送成功] but found [发送成功手机收发邮件更方便]
        Expected :发送成功
        Actual   :发送成功手机收发邮件更方便
         */
//        Assert.assertEquals(text, "发送成功手机收发邮件更方便", "fail.");

        boolean asse = driver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
        Assert.assertTrue(asse, "fail");
    }
}
