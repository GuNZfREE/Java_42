package Java_Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Test_Prepare {
    public static WebDriver driver;

    @BeforeClass
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen", "disable-infobars");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://beru.ru");
    }

    @AfterTest
    public void quit() {
        driver.get("https://beru.ru/logout?retpath=https%3A%2F%2Fberu.ru%2F");
        driver.quit();
    }
}
