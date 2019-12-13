package com.po;

import org.openqa.selenium.By;

public class Mail163 {
    /**
     *写信和收信
     */
    public static By span_sendAndrece = By.className("oz0");
    
    /**
     *收件箱
     */
    public static By li_receiveBox = By.xpath("//li[@title=\"收件箱\"]");
    public static By div_receiveBox = By.xpath("//div[text()=\"收件箱\"]");
    //org.openqa.selenium.ElementClickInterceptedException: Element <span class="nui-tree-item-text"> is not clickable at point (90,162) because another element <span class="oz0"> obscures it
    public static By span_receiveBox = By.xpath("//span[@title=\"收件箱\"]");

    /**
     *close gWel-warning-ico
     */
    public static By div_warning = By.className("gWel-warning");
    public static By i_warning = By.className("gWel-warning-ico");
    public static By a_close = By.xpath("//a[text()=\"马上加强保护\"]/following-sibling::a");
    /**
     *获取收件箱所有邮件的标题
     */
    public static By span_mailsTitle = By.xpath("//label[@role=\"checkbox\"]/following-sibling::div/span");
    
    /**
     *send Two
     */
    public static By span_send = By.xpath("//span[text()=\"发送\"]");

    /**
     *inputs
     */
    public static By input_s = By.xpath("//div[@class=\"bz0\"]//input[@tabindex=\"1\"]");
    
    /**
     *attachment
     */
    public static By input_attachUpload = By.className("O0");

    /**
     *APP-editor-iframe
     */
    public static By iframe_editor = By.className("APP-editor-iframe");
    
    /**
     *editor
     */
    public static By body_editor = By.className("nui-scroll");
    
    /**
     *Assert
     */
    public static By h1_assert = By.className("tK1");
}
