package Java_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        if (driver.findElement(By.cssSelector(".header2-nav__user"))
                .getAttribute("textContent").contains("Мой профиль")) {
            WebElement profile = driver.findElement(By.cssSelector(".header2-nav__user"));
            profile.click();
            WebElement logOut = driver.findElement(By.cssSelector("[class*='item_type_logout']"));
            logOut.click();
        }
        driver.close();
        driver.quit();
    }
}
