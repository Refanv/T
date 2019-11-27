package Demon;

import com.autoframework.M;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class _03_T_handlers {
    WebDriver driver;

    @BeforeTest
    public void baidu() {
        driver = SeleniumDriver.initialWebDriver("FF");
        driver.navigate().to("https://www.baidu.com/");
    }

    @AfterTest
    public void quit() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void switchWindow() {
        driver.findElement(By.linkText("新闻")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"pane-news\"]//a"));
        List<String> handlers = new ArrayList<>();
        handlers.add(driver.getWindowHandle());
        System.out.println(elements.size());

        elements.get(0).click();
        elements.get(1).click();
        elements.get(2).click();
        Set<String> handlerSet = driver.getWindowHandles();
        Iterator<String> iterator = handlerSet.iterator();
        while (iterator.hasNext()) {
            if (1 == handlerSet.size()) break;//修正NoSuchSessionException 保留了最后一个窗口
            String next = iterator.next();
            iterator.remove();
            driver.switchTo().window(next);
            M.sp(1);
            driver.close();
        }//org.openqa.selenium.NoSuchSessionException: Tried to run command without establishing a connection

//        for (Iterator<String> iterator = handlerSet.iterator(); iterator.hasNext(); ) {
//            String next = iterator.next();
//            driver.switchTo().window(next);
//            M.sp(1);
//            driver.close();
//        }
//        for (String s : handlerSet) {
////            if (handlers.get(0) != s) {
//            if (handlers.get(0).equals(s)) {
//                continue;
//            } else {
//                handlers.add(s);
//            }
//        }

//        for (int i = 1; i < handlers.size(); i++) {
//            driver.close();
//            String s = handlers.get(i);
//            driver.switchTo().window(s);
//            M.sp(1);
//        }
    }
}
