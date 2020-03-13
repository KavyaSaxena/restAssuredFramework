package TestNg;

import org.junit.BeforeClass;
import org.testng.annotations.*;

public class TestNgBasics {

    @BeforeSuite
    public void suite(){
        System.out.println(1);
    }

    @BeforeTest
    public void before_test(){
        System.out.println(2);
    }

    @BeforeClass
    public void launch_browser(){
        System.out.println(3);
    }

    @BeforeMethod
    public void enter_url(){
        System.out.println(4);
    }

    @Test
    public void test1(){
        System.out.println(5);
    }

    @AfterMethod
    public void after_method(){
        System.out.println(6);
    }

    @AfterClass
    public void after_class(){
        System.out.println(7);
    }

    @AfterTest
    public void after_test(){
        System.out.println(8);
    }

    @AfterSuite
    public void after_suite(){
        System.out.println(9);
    }
}
