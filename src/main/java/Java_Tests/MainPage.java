package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage extends TestPrepare {

    private WebElement profileInfo() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector(".header2-nav__user"))));
    }

    private WebElement cityInfo() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='line__region'] "
                                     + " [class*='link__inner']"))));
    }

    @Step("Open Sign In Form")
    public SignInPage startSignIn() {
        profileInfo().click();
        return new SignInPage();
    }

    @Step("Open Profile")
    public ProfilePage startProfile() {
        (new Actions(driver)).moveToElement(profileInfo()).build().perform();
        WebElement profileAddress = driver.findElement(By.
                cssSelector("[class*='type_settings']"));
        profileAddress.click();
        return new ProfilePage();
    }

    @Step("Check Profile Authorization")
    public void checkProfile() {
        Assert.assertEquals(profileInfo()
                .getAttribute("textContent"), "Мой профиль");
    }

    @Step("Check Profile Login")
    public void checkLogin(String login) {
        (new Actions(driver)).moveToElement(profileInfo()).build().perform();
        Assert.assertEquals(driver.findElement(By
                .cssSelector(".header2-user-menu__email"))
                .getAttribute("textContent"), login);
    }

    @Step("Check City on Main Page")
    public void checkCity(String nameCity) {
        Assert.assertEquals(cityInfo()
                        .getAttribute("textContent"), nameCity);
    }

    @Step("Change City on Main Page")
    public void changeCity(String nameCity) {
        cityInfo().click();

        WebElement formCity = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector(".header2-region-popup"))));

        WebElement enterCity = formCity.findElement(By.cssSelector(".input__control"));
        enterCity.sendKeys(nameCity);

        WebElement searchCity = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-suggest__list suggest2']"))));

        WebElement chooseCity = searchCity.findElement(By
                .xpath("//*[contains(text(),'" + nameCity + "')]"));
        chooseCity.click();

        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.invisibilityOf(searchCity));

        enterCity.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }

    @Step("Searching Toothbrushes")
    public void searchToothbrushes() {
        WebElement rowSearch = driver.findElement(By.id("header-search"));
        rowSearch.click();
        rowSearch.sendKeys("Электрические зубные щетки");
        rowSearch.sendKeys(Keys.ENTER);
    }



}
