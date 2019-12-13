package com.pages.mail;

import com.po.Mail163;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class Mail {

    public static void assertWarning(WebDriver driver) {
        WebElement warning = driver.findElement(Mail163.div_warning);
        System.out.println(warning.isDisplayed());//false normally
        if (warning.isDisplayed()) {
            System.out.println("warning.");
            driver.findElement(Mail163.a_close).click();
        }
    }

    public static void getTitles(WebDriver driver) {
//        List<WebElement> list = driver.findElements(Mail163.span_sendAndrece);
//        list.get(0).click();
//        System.out.println(list.size());//2

//        driver.findElement(Mail163.li_receiveBox).click();No
        assertWarning(driver);

        driver.findElement(Mail163.div_receiveBox).click();

//        driver.findElement(Mail163.span_receiveBox).click();obscure

        List<WebElement> elements = driver.findElements(Mail163.span_mailsTitle);
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }

    public static void editEmail(WebDriver driver) {
        assertWarning(driver);

        driver.findElements(Mail163.span_sendAndrece).get(1).click();
        List<WebElement> inputs = driver.findElements(Mail163.input_s);
        inputs.get(0).sendKeys("refine_king@163.com");
        inputs.get(1).sendKeys("Test");
        driver.findElement(Mail163.input_attachUpload).sendKeys("C:\\Users\\R\\764.jpg");
//        driver.findElement(Mail163.input_attachUpload).sendKeys("C:/Users/R/764.jpg");//File not found: C:/Users/R/764.jpg
        driver.switchTo().frame(driver.findElement(Mail163.iframe_editor));
        WebElement editorBody = driver.findElement(Mail163.body_editor);
        editorBody.sendKeys("abcdefghijklmnop.");
        driver.switchTo().defaultContent();
    }

    public static void editEmail(WebDriver driver, String email, String topic, File upLoadFile) {
        Mail.assertWarning(driver);

        driver.findElements(Mail163.span_sendAndrece).get(1).click();
        List<WebElement> inputs = driver.findElements(Mail163.input_s);
        inputs.get(0).sendKeys(email);
        inputs.get(1).sendKeys(topic);
        driver.findElement(Mail163.input_attachUpload).sendKeys(upLoadFile.getAbsolutePath());

        driver.switchTo().frame(driver.findElement(Mail163.iframe_editor));
        WebElement editorBody = driver.findElement(Mail163.body_editor);
        editorBody.sendKeys("abcdefghijklmnop.");
        driver.switchTo().defaultContent();
    }
}
