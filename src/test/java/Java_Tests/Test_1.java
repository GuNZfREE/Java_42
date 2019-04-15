package Java_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class Test_1 extends Test_Prepare {

    @Test
    public void test1() {
        WebElement signin_form;
        WebElement pass_form;
        WebElement login_form;
        WebElement profile;

        driver.findElement(By.cssSelector(".header2-nav__user")).click();

        signin_form = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));
        login_form = signin_form.findElement(By.cssSelector("#passp-field-login"));
        login_form.click();
        login_form.sendKeys("GuNZfREE164" + Keys.ENTER);

        signin_form = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));
        pass_form = signin_form.findElement(By.cssSelector("#passp-field-passwd"));
        pass_form.sendKeys("1287boston" + Keys.ENTER);

        profile = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".header2-nav__user"))));
        Assert.assertEquals(profile.getAttribute("textContent"), "Мой профиль");

        (new Actions(driver)).moveToElement(profile).build().perform();

        Assert.assertEquals(driver.findElement(By.cssSelector(".header2-user-menu__email"))
                .getAttribute("textContent"), "GuNZfREE164@yandex.ru");
    }
}
