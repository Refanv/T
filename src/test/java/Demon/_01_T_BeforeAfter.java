package Demon;

import org.testng.annotations.*;

public class _01_T_BeforeAfter {

    @BeforeClass
    void testBeforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void testBeforeMethod() {
        System.out.println("BeforeMethod");
    }

    @BeforeTest
    void testBeforeTest() {
        System.out.println("BeforeTest");
    }

    @AfterMethod
    void testAfterMethod() {
        System.out.println("AfterMethod");
    }

    @AfterTest
    void testAfterTest() {
        System.out.println("AfterTest");
    }

    @Test
    void test_3() {
        System.out.println("test_3");
    }

    @Test
    void test_1() {
        System.out.println("test_1");
    }
    @Test
    void test_4() {
        System.out.println("test_4");
    }

    @Test
    void test_0() {
        System.out.println("test_0");
    }

    @AfterClass
    void testAfterClass() {
        System.out.println("AfterClass");
    }
}
