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
        WebElement signInForm;
        WebElement logInForm;

        signInForm = (new WebDriverWait(driver, 40)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .cssSelector(".passp-login-form"))));
        logInForm = signInForm.findElement(By.cssSelector("#passp-field-login"));
        logInForm.click();
        logInForm.sendKeys(login + Keys.ENTER);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        WebElement signInForm;
        WebElement passInForm;

        signInForm = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .cssSelector(".passp-password-form"))));
        passInForm = signInForm.findElement(By.cssSelector("#passp-field-passwd"));
        passInForm.sendKeys(password + Keys.ENTER);
    }
}
