package Java_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test_Prepare {
    public static WebDriver driver;

    @BeforeClass
    public void prepare() {
        WebElement ex_ads;

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen", "disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://beru.ru");

        ex_ads = driver.findElement(By.cssSelector("._1ZYDKa22GJ"));
        ex_ads.click();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
