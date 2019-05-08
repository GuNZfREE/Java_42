package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Starter_Page extends Test_Prepare {

    private WebElement Profile_Info() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector(".header2-nav__user"))));
    }

    private WebElement City_Info() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='line__region'] "
                                     + " [class*='link__inner']"))));
    }

    @Step("Open Sign In Form")
    public SignIn_Page start_SignIn() {
        Profile_Info().click();
        return new SignIn_Page();
    }

    @Step("Open Profile")
    public Profile_Page start_Profile() {
        WebElement profileAddress;

        (new Actions(driver)).moveToElement(Profile_Info()).build().perform();
        profileAddress = driver.findElement(By.
                cssSelector("[class*='type_settings']"));
        profileAddress.click();
        return new Profile_Page();
    }

    @Step("Check Profile Authorization")
    public void check_Profile() {
        Assert.assertEquals(Profile_Info()
                .getAttribute("textContent"), "Мой профиль");
    }

    @Step("Check Profile Login")
    public void check_Login(String login) {
        (new Actions(driver)).moveToElement(Profile_Info()).build().perform();
        Assert.assertEquals(driver.findElement(By
                .cssSelector(".header2-user-menu__email"))
                .getAttribute("textContent"), login);
    }

    @Step("Check City on Main Page")
    public void check_City(String nameCity) {
        Assert.assertEquals(City_Info()
                        .getAttribute("textContent"), nameCity);
    }

    @Step("Change City on Main Page")
    public void change_City(String nameCity) {
        WebElement formCity;
        WebElement enterCity;
        WebElement searchCity;
        WebElement chooseCity;

        City_Info().click();

        formCity = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector(".header2-region-popup"))));

        enterCity = formCity.findElement(By.cssSelector(".input__control"));
        enterCity.sendKeys(nameCity);

        searchCity = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-suggest__list suggest2']"))));

        chooseCity = searchCity.findElement(By
                .xpath("//*[contains(text(),'" + nameCity + "')]"));
        chooseCity.click();

        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.invisibilityOf(searchCity));

        enterCity.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }
}
