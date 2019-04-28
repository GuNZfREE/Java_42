package Java_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Starter_Page extends Test_Prepare {

    private WebElement Profile_Info() {
        return (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header2-nav__user"))));
    }

    public void check_Profile() {
        Assert.assertEquals(Profile_Info().getAttribute("textContent"), "Мой профиль");
    }

    public void check_login(String login) {
        (new Actions(driver)).moveToElement(Profile_Info()).build().perform();
        Assert.assertEquals(driver.findElement(By.cssSelector(".header2-user-menu__email"))
                .getAttribute("textContent"), login);
    }

    public SignIn_Page start_SignIn() {
        Profile_Info().click();
        return new SignIn_Page();
    }
}
