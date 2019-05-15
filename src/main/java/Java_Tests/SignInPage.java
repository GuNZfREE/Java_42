package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage extends MainPage {
    @Step("Enter Login")
    public void enterLogin(String login) {
        WebElement signInForm = (new WebDriverWait(driver, 40)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .cssSelector(".passp-login-form"))));
        WebElement logInForm = signInForm.findElement(By.cssSelector("#passp-field-login"));
        logInForm.click();
        logInForm.sendKeys(login + Keys.ENTER);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        WebElement signInForm = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .cssSelector(".passp-password-form"))));
        WebElement passInForm = signInForm.findElement(By.cssSelector("#passp-field-passwd"));
        passInForm.sendKeys(password + Keys.ENTER);
    }
}
