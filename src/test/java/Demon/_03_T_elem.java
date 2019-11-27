package Demon;

import com.autoframework.M;
import com.autoframework.driver.CapScreen;
import com.autoframework.driver.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class _03_T_elem {
    WebDriver driver;

    @BeforeTest
    public void baidu() {
        driver = SeleniumDriver.initialWebDriver("FF");
        driver.navigate().to("https:www.baidu.com/");
    }

    @AfterTest
    public void quit() {
        if (null != driver) {
            driver.quit();
        } else {
            System.out.println("driver is Null.");
        }
    }
/*
点击百度首页的新闻按钮，校验URL地址
 */
    @Test
    public void _T_click() {
        /*
        name
         */
//        WebElement news = driver.findElement(By.name("tj_trnews"));
        /*
        partialLinkText
         */
        WebElement news = driver.findElement(By.partialLinkText("新"));
        /*
        linkText
         */
//        WebElement news = driver.findElement(By.linkText("新闻"));
        news.click();
        String str = driver.getCurrentUrl();
        /*
        System.out.println("str = " + str);//str = 百度新闻——海量中文资讯平台
        System.out.println(driver.getCurrentUrl());//http://news.baidu.com/
        */
        Assert.assertEquals(str, "http://news.baidu.com/","Wrong URL.");
    }
/*
输入Selenium，点击搜索按钮。校验搜索结果是否大于1000，000条
输入搜索内容，点击搜索
获取搜索结果，用正则删除字符串中的所有非数字
String转换成int，校验是否大于一百万
 */
    @Test
    public void _T_sendkeys() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        element.sendKeys("Selenium");
        driver.findElement(By.id("su")).click();
        String Nums = driver.findElement(By.className("nums_text")).getText();
        String results = Nums.replaceAll("[^0-9]", "");
//        System.out.println("results = " + results);results = 50400000
        int nums = Integer.parseInt(results);
//       nums > 1000 ? true : false;
        boolean assert_million = nums > 1000000;
        Assert.assertTrue(assert_million, "the results low 1000,000");
    }
/*
搜索框输入内容
clear内容
似乎没有能获取用户输入在文本框中的内容的方法
在搜索框输入关键字之后的“回车” 操作， 就可以通过 submit()方法模拟.
 */
    @Test
    public void _T_clear_submit() {
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("abc");
        M.sp(1);
        element.clear();
        M.sp(1);
        element.sendKeys("99");
        element.submit();//valid
        M.sp(1);
    }
/*
搜索Selenium
获取所有a标签的文本
 */
    @Test
    public void _T_getText() {
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("Selenium");
        driver.findElement(By.id("su")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//h3/a"));

        for (WebElement webElement : elements) {
            System.out.println(webElement.getTagName());
/*
a
web自动化测试神器——selenium家族介绍
a
Selenium的使用详解_python_脚本之家
a
java selenium-中国互联网研发培训指定机构-官方首页
a
*/
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void _T_getTagname() {
//        WebElement news = driver.findElement(By.partialLinkText("新"));
//        System.out.println(news.getTagName());a
        WebElement element = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
        element.sendKeys("Selenium");
        element.submit();
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"1\"]/h3/a"));
        System.out.println(elem.getText());
        System.out.println(elem.getAttribute("href"));
        M.sp(2);
    }

    @Test
    public void _T_attribute() {
        driver.findElement(By.linkText("登录")).click();
        WebElement longon = driver.findElement(By.xpath("(//p[text()=\"扫码登录\"])[1]"));////*[@id="TANGRAM__PSP_10__qrcode"]/p[1]；(//*[@class="clearfix"]//p[1])[2];//(//p[text()="扫码登录"])[1]
        if (longon.isDisplayed()) {
            System.out.println("扫码登录 was displayed.");
            driver.findElement(By.xpath("//*[@id=\"TANGRAM__PSP_10__footerULoginBtn\"]")).click();
//            driver.findElement(By.xpath("//p[@title=\"用户名登录\"]")).click();
        }
        WebElement login = driver.findElement(By.name("userName"));
        String account = login.getAttribute("placeholder");
        System.out.println("account = " + account);
    }

    @Test
    public void _T_displayed() {
//        WebElement text = driver.findElement(By.xpath("(//*[@class=\"clearfix\"]//p[1])[2]"));找不到

        driver.findElement(By.linkText("登录")).click();
        WebElement text = driver.findElement(By.xpath("(//*[@class=\"clearfix\"]//p[1])[2]"));
        System.out.println("text.isDisplayed??" + text.isDisplayed());
        Assert.assertTrue(text.isDisplayed(), "扫码登录 was displayed.");

        driver.findElement(By.xpath("//p[@title=\"用户名登录\"]")).click();

        System.out.println("text.isDisplayed??" + text.isDisplayed());
        Assert.assertFalse(text.isDisplayed(), "扫码登录 was displayed.");
    }

    @Test
    public void _T_selected() {
        driver.findElement(By.linkText("登录")).click();
        WebElement scanLog = driver.findElement(By.xpath("(//p[text()=\"扫码登录\"])[1]"));
        Assert.assertTrue(scanLog.isDisplayed(), "扫码登录 wasn't displayed.");
        if (scanLog.isDisplayed()) {
            driver.findElement(By.xpath("//p[@title=\"用户名登录\"]")).click();
            Assert.assertFalse(scanLog.isDisplayed());
        }

        WebElement checkbox = driver.findElement(By.name("memberPass"));
        Assert.assertTrue(checkbox.isSelected(), "the checkbox is't Selected.");
        M.sp(2);
    }



    @Test
    public void _T_enabled() {
//        WebElement scanLog = driver.findElement(By.xpath("(//p[text()=\"扫码登录\"])[1]"));
//        org.openqa.selenium.NoSuchElementException: Unable to locate element: (//p[text()="扫码登录"])[1]
        driver.findElement(By.linkText("登录")).click();
        WebElement scanLog = driver.findElement(By.xpath("(//p[text()=\"扫码登录\"])[1]"));
        if (scanLog.isDisplayed()) {
            driver.findElement(By.xpath("//p[@title=\"用户名登录\"]")).click();
            Assert.assertFalse(scanLog.isDisplayed());
        }

        WebElement elm = driver.findElement(By.xpath("//input[@value=\"登录\"]"));
        System.out.println(elm.isEnabled());//true
//        CapScreen.screenShot(driver, System.getProperty("user.dir") + "//capscreen//" + "002" + ".jpg");OK
        CapScreen.screenShot(driver);
    }
/*TODO
如何获取p标签里的文本
 */
    @Test
    public void _T_p() {
        //org.openqa.selenium.WebDriverException: TypeError: Expected an element or WindowProxy, got: [object Text] {}
//        List<WebElement> elements = driver.findElements(By.xpath("//p/text()"));
//        for (int i = 0; i < elements.size(); i++) {
//            WebElement element = elements.get(i);
//            System.out.println(element.getText());
//            System.out.println();
//        }

//        WebElement elm = driver.findElement(By.xpath("//p/text()"));
        //org.openqa.selenium.WebDriverException: TypeError: Expected an element or WindowProxy, got: [object Text] {}

////        System.out.println(elm.getText());//OK-下载百度APP
//        WebElement elm = driver.findElement(By.xpath("//p[@class=\"title\"]"));

        System.out.println(By.xpath("//p/text()").toString());
        //By.xpath: //p/text()
    }
}
