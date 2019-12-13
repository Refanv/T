package com.pages.mail;

import com.po.Reg;
import org.openqa.selenium.WebDriver;

public class Register {

    public static void regisgter(WebDriver driver) {
        String time = String.valueOf(System.currentTimeMillis());
        System.out.println(driver.findElement(Reg.mainRegA).isEnabled());//true

        driver.findElement(Reg.nameIpt).sendKeys('a' + time);
        driver.findElement(Reg.mainPwdIpt).sendKeys("098765432");
        driver.findElement(Reg.mainConfirmPassword).sendKeys("098765432");
        driver.findElement(Reg.vcodeIpt).sendKeys("huif");
        driver.findElement(Reg.mainMobileIpt).sendKeys(time.substring(0, 11));
        driver.findElement(Reg.mainAcceptIpt).click();
        System.out.println(driver.findElement(Reg.mainRegA).isEnabled());//true
    }
}
