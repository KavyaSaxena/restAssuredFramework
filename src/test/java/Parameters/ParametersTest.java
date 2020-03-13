package Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

    WebDriver driver;

    @Test
    @Parameters({"browser","url","emailId"})
    public void yahoologinTest(String browser, String url, String emailId){

        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            driver = new ChromeDriver();
        }

        driver.get(url);
        driver.findElement(By.xpath("//*[@id='login-username']")).clear();
        driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys(emailId);
        driver.findElement(By.xpath("//*[@id='login-signin']")).click();

    }
}
