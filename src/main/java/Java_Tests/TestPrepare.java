package Java_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestPrepare {
    public static WebDriver driver;

    @BeforeMethod
    public void prepare() {
        System.setProperty("webdriver.chrome.driver",
                           "C:\\Program Files (x86)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen", "disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://beru.ru");
    }

    @AfterMethod
    public void quit() {
        driver.close();
        driver.quit();
    }
}
