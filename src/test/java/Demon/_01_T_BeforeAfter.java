package Demon;

import org.testng.annotations.*;

/**
 *  Before Suite.
 *  BeforeTest
 *  BeforeClass
 *  BeforeMethod
 *  test_0
 *  AfterMethod
 *  BeforeMethod
 *  test_1
 *  AfterMethod
 *  BeforeMethod
 *  test_3
 *  AfterMethod
 *  BeforeMethod
 *  test_4
 *  AfterMethod
 *  AfterClass
 *  AfterTest
 */
public class _01_T_BeforeAfter {

    @BeforeGroups
    void t() {
        System.out.println("Before Groups.");
    }

    @BeforeSuite
    void s() {
        System.out.println("Before Suite.");
    }
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
