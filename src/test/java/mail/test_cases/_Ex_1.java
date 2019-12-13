package mail.test_cases;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import com.po.Home;
import com.po.Reg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;

public class _Ex_1 {
    private WebDriver driver = SeleniumDriver.driverFactory("FF", 8, 8);

    @BeforeClass
    void openURL() {
        driver.get("https://mail.163.com/");
    }

    @AfterClass
    void quitBrowser() {
        if (driver != null) {
            driver.quit();
        } else System.out.println("driver is Null.");
    }

    @Test
    void _01_check() {
        //校验Label Normal 是否展示
        WebElement lbNormal = driver.findElement(Home.div_lbNormal);
        boolean lbNormal_isDisplayed = lbNormal.isDisplayed();
        Assert.assertTrue(lbNormal_isDisplayed, "div_lbNormal is Displayed.");
    }

    @Test
    void _02_check() {
//        _01_check();OK
        //校验 a标签网易邮箱大师 是否展示 并 校验href地址
        WebElement b_appLogin_mailmaster_download_click =  driver.findElement(Home.a_appLogin_mailmaster);
        boolean mailmaster_download = b_appLogin_mailmaster_download_click.isDisplayed();
        Assert.assertTrue(mailmaster_download, "b_appLogin_mailmaster_download_click is Displayed.");
    }

    @Test
    void _03_check() {
        //校验网易邮箱大师href地址
        WebElement b_appLogin_mailmaster_download_click =  driver.findElement(Home.a_appLogin_mailmaster);
        String mailmaster = b_appLogin_mailmaster_download_click.getAttribute("href");
        Assert.assertEquals(mailmaster, "https://mail.163.com/dashi/dlpro.html?from=mail23", "href=\"https://mail.163.com/dashi/dlpro.html?from=mail23\"");
    }

    @Test
    void _04_check() {
        //校验a标签 密码登录
        WebElement switchAccountLogin = driver.findElement(Home.a_switchAccountLogin);
        boolean switchAccount = switchAccountLogin.isDisplayed();
        Assert.assertTrue(switchAccount, "账号密码登录");
    }

    @Test
    void _05_check() {
        //注册新账号
        WebElement u_reg_entry = driver.findElement(Home.a_app_register_new);
        boolean reg = u_reg_entry.isDisplayed();
        Assert.assertTrue(reg, "注册新账号");
    }

    @Test
    void _06_check() {
        String handler = driver.getWindowHandle();
        //点击注册 去新页面
        driver.findElement(Home.a_app_register_new).click();
        //执行速度太快，新页面还没load完，应该还没有handler值。交换页面时，Set里只有一个值
        M.sp(1);
        SeleniumDriver.switchWindow(driver);

        WebElement selectDomain = driver.findElement(Reg.mainDomain);
        Select select = new Select(selectDomain);
//        List<WebElement> elements = select.getAllSelectedOptions();
        List<WebElement> elements = select.getOptions();
        Iterator<WebElement> iterator = elements.iterator();
        while (iterator.hasNext()) {
            WebElement next = iterator.next();
            System.out.println(next.getText());
        }

        int size = elements.size();
        Assert.assertEquals(size, 3, "@域名数量不为3");

        driver.switchTo().window(handler);

        //sendkeys
//        driver.findElement(Reg.nameIpt).sendKeys("qwertry_pupu_ipip+io");
//        M.sp(2);
    }

    @Test
    void _07_check() {
        String handler = driver.getWindowHandle();//save conditons
        switchWin();

        //getText"@"
        String at = driver.findElement(Reg.at).getText();
        System.out.println("at = " + at);

        driver.switchTo().window(handler);
        Assert.assertEquals(at, "@", "@");
    }

    private void switchWin() {
        driver.findElement(Home.a_app_register_new).click();
        M.sp(1);
        SeleniumDriver.switchWindow(driver);
    }

    @Test
    void _08_check() {
        String handler = driver.getWindowHandle();
        switchWin();
        WebElement selectDomain = driver.findElement(Reg.mainDomain);
        Select select = new Select(selectDomain);
        select.selectByIndex(2);
        WebElement selected = select.getAllSelectedOptions().get(0);
        System.out.println(selected.getText());

        driver.switchTo().window(handler);
        M.sp(2);
    }

    @Test
    void _09_check_closeSecondWin() {
        String handler = driver.getWindowHandle();
        System.out.println("handler = " + handler);
        switchWin();
        System.out.println(driver.getWindowHandle());
        driver.close();
        driver.switchTo().window(handler);
        System.out.println(driver.getWindowHandle());
        driver.close();
    }

}
