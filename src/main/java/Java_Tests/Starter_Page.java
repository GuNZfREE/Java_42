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
    public String name_City;

    private WebElement Profile_Info() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header2-nav__user"))));
    }

    private WebElement City_Info() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='line__region'] [class*='link__inner']"))));
    }
    @Step
    public SignIn_Page start_SignIn() {
        Profile_Info().click();

        return new SignIn_Page();
    }
    @Step
    public Profile_Page start_Profile() {
        WebElement profile_Address;

        (new Actions(driver)).moveToElement(Profile_Info()).build().perform();
        profile_Address = driver.findElement(By.cssSelector("[class*='type_addresses']"));
        profile_Address.click();
        return new Profile_Page();
    }


    @Step
    public void check_Profile() {
        Assert.assertEquals(Profile_Info().getAttribute("textContent"), "Мой профиль");
    }
    @Step
    public void check_login(String login) {
        (new Actions(driver)).moveToElement(Profile_Info()).build().perform();
        Assert.assertEquals(driver.findElement(By.cssSelector(".header2-user-menu__email"))
                .getAttribute("textContent"), login);
    }
    @Step
    public void change_City(String name_City) {
        WebElement form_City;
        WebElement enter_City;
        WebElement search_City;
        WebElement choose_City;

        City_Info().click();
        this.name_City = name_City;

        form_City = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header2-region-popup"))));

        enter_City = form_City.findElement(By.cssSelector(".input__control"));
        enter_City.sendKeys(name_City);

        search_City = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='region-suggest__list suggest2']"))));

        choose_City = search_City.findElement(By.xpath("//*[contains(text(),'" + name_City + "')]"));
        choose_City.click();

        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.invisibilityOf(search_City));

        enter_City.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }
    @Step
    public void check_City(String name_City) {
        this.name_City = name_City;
        Assert.assertEquals(City_Info().getAttribute("textContent"), name_City);
    }
}
