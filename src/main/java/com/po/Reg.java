package com.po;

import org.openqa.selenium.By;

public class Reg {
    
    /**
     *注册免费邮箱
     */
    public static By reg = By.linkText("注册免费邮箱");
    //用户名
    public static By nameIpt = By.id("nameIpt");
    //@
    public static By at = By.className("txt-14");
    /**
     *mainDomainSelect域名选择
     */
    public static By mainDomain = By.name("mainDomain");
    /**
     *密码
     */
    public static By mainPwdIpt = By.id("mainPwdIpt");

    /**
     *确认密码
     */
    public static By mainConfirmPassword = By.name("mainConfirmPassword");

    /**
     *vcodeIpt验证码
     */
    public static By vcodeIpt = By.id("vcodeIpt");

    /**
     *mainMobileIpt手机号
     */
    public static By mainMobileIpt = By.id("mainMobileIpt");

    /**
     *mainAcceptIpt
     */
    public static By mainAcceptIpt = By.id("mainAcceptIpt");

    /**
     *mainRegA
     */
    public static By mainRegA = By.id("mainRegA");

    //注册VIP邮箱
    /**
     *注册VIP邮箱
     */
    public static By vipreg = By.linkText("注册VIP邮箱");

    /**
     *username
     */
    public static By username = By.id("username");

    /**
     *password
     */
    public static By password = By.id("password");
    
    /**
     *yidun_slider
     */
    public static By yidun_slider = By.className("yidun_slider");

    /**
     *mobile
     */
    public static By mobile = By.id("mobile");

    /**
     *免费获取验证码
     */
    public static By getCode = By.linkText("免费获取验证码");

    /**
     *registerSn
     */
    public static By registerSn = By.id("registerSn");

    /**
     *rule
     */
    public static By rule = By.id("registerSn");

    /**
     *立即注册
     */
    public static By regnow = By.linkText("立即注册");

}
