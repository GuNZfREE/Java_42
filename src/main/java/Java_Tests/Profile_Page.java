package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Profile_Page extends Starter_Page {
    @Step
    private WebElement Profile_City() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='settings-list__title'] [class*='link__inner']"))));
    }
    @Step
    private WebElement Page_City() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='line__region'] [class*='link__inner']"))));
    }
    @Step
    public void check_Address() {
        Assert.assertEquals(Profile_City().getAttribute("textContent"),
                Page_City().getAttribute("textContent"));
    }
}
