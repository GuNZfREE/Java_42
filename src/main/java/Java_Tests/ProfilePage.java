package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends MainPage {
    private WebElement ProfileCity() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='settings-list__title'] [class*='link__inner']"))));
    }

    private WebElement PageCity() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='line__region'] [class*='link__inner']"))));
    }

    @Step("Check Address in Profile and Page")
    public void checkHeaderCityAndAddress() {
        Assert.assertEquals(PageCity().getAttribute("textContent"),
                ProfileCity().getAttribute("textContent"));
    }
}
