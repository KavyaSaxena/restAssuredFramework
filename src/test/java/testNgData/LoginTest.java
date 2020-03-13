package testNgData;

import Util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://ui.freecrm.com/");
    }

    @DataProvider
    public Object[][] getLoginData(){
        Object[][] data = TestUtil.getTestData("login");
        return data;
    }

    @Test(dataProvider = "getLoginData")
    public void loginTest(String username, String password){
        driver.findElement(By.xpath("//input[@name='email' and @type = 'text']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys(password);
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", loginBtn);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
