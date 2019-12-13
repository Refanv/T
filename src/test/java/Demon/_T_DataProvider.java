package Demon;

import com.autoframework.M;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class _T_DataProvider {

    @DataProvider
    public Object[][] gridData() {
        return new Object[][] {
                {"http://192.168.31.131:22906/wd/hub", "FireFox"},
                {"http://192.168.31.131:44982/wd/hub", "Chrome"}
        };
    }

    @Test(dataProvider="gridData")
    public void test(String url, String browser) throws MalformedURLException {
        DesiredCapabilities dc = null;
        if (browser.equals("FireFox")) {
            dc = DesiredCapabilities.firefox();
        } else if (browser.equals("Chrome")) {
            dc = DesiredCapabilities.chrome();
        } else {
            System.out.println("Wrong name of browser.");
        }

        WebDriver driver = new RemoteWebDriver(new URL(url), dc);
        driver.get("https://www.baidu.com/");
        M.sp(1);
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        driver.quit();
    }
}
