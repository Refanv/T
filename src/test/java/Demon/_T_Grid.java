package Demon;

import com.autoframework.M;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class _T_Grid {

    @Test
    void testChrome() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        DesiredCapabilities dc = new ChromeOptions();

//        WebDriver driver = new RemoteWebDriver(new URL(" http://192.168.31.131:4444/wd/hub"), dc);//让hub自动分发
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.31.131:22906/wd/hub"), dc);
        driver.get("https://www.baidu.com/");
        M.sp(3);
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        driver.quit();
    }
}
