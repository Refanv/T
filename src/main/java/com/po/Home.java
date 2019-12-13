package com.po;

import org.openqa.selenium.By;

public class Home {
    /*
    @Deprecated
    static { 刷新页面后，element不可用
        driver.get("https://mail.163.com/");
        driver.findElement(div_lbNormal).click();
        elem_iframe = driver.findElement(div_iframe).findElement(iframe);
        driver.findElement(lbApp).click();
//    driver.switchTo().defaultContent();
    }
     */

    public static By div_header = By.className("header");
    
    public static By div_lbNormal = By.id("lbNormal");

    public static By h_login_title_text = By.className("loginbox-title");

    //    public static By a_appLogin_mailmaster = By.partialLinkText("网易邮箱大师");
    public static By a_appLogin_mailmaster = By.linkText("网易邮箱大师");
    
    public static By a_switchAccountLogin = By.id("switchAccountLogin");

//    public static By register = By.xpath("//*[text()=\"注册新帐号\"]");两个

    public static By a_app_register_new = By.linkText("注册新帐号");

/*
log on page
 */
    /**
     *通过div定位iframe，有多个iframe
     */
    public static By div_iframe = By.id("loginDiv");
    public static By iframe = By.tagName("iframe");//(//iframe)[1]
//    public static WebElement elem_iframe = driver.findElement(div_iframe).findElement(iframe);//不行，类变量不能用driver findelement初始化
    public static By loginform = By.id("login-form");

    public static By lbApp = By.id("lbApp");


    public static By email = By.name("email");

//    public static By at163_text = By.xpath("(//form[@id=\"login-form\"]//span)[1]");

    public static By at163_text = By.xpath("//input[@name=\"email\"]/following-sibling::span");
    public static By password = By.name("password");

    public static By checkbox = By.id("un-login");

    public static By checkbox_label = By.xpath("//*[@for=\"un-login\"]");

    //assert URL
    public static By forgetPassword = By.xpath("//*[text()=\"忘记密码？\"]");
    public static By button_logOn = By.id("dologin");

    public static By a_normal_register_new = By.id("changepage");


}
