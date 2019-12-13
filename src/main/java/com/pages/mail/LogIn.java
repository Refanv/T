package com.pages.mail;

import com.autoframework.driver.SeleniumDriver;
import com.po.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {

    public static void login(WebDriver driver, String email, String password) {
        driver.findElement(Home.a_switchAccountLogin).click();
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

        driver.findElement(Home.email).sendKeys(email);
        driver.findElement(Home.password).sendKeys(password);
        driver.findElement(Home.button_logOn).click();

        driver.switchTo().defaultContent();

    }

    public static void register(WebDriver driver) {
        driver.findElement(Home.a_app_register_new).click();
        String handler = driver.getWindowHandle();
        SeleniumDriver.switchWindow(driver);
    }
}
