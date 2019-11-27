package com.autoframework.driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class CapScreen {
//    public static String path = System.getProperty("user.dir") + "\\capscreen";
    private static String dir ="capscreen//";
    private static int num = 1;
    private static String postfix = ".jpg";

    public static void screenShot(WebDriver webDriver) {

        File capScreen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String path = dir + getName() + "_" + (num++) + postfix;
        try {
            FileUtils.copyFile(capScreen, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Copy Screen File to " + getName() + "Failed.");
        }
    }

    public static void screenShot(WebDriver webDriver, String Name) {

        File capScreen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String path = dir + Name + "_" + (num++) + postfix;
        try {
            FileUtils.copyFile(capScreen, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Copy Screen File to " + Name + "Failed.");
        }
    }
//getClassName And getMethodName
    private static String getName() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String method = Thread.currentThread().getStackTrace()[3].getMethodName();
        String str = className + "@" + method;
        return str;
    }
}
