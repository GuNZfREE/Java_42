package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn_Page extends Starter_Page{
    @Step("Enter Login")
    public void enter_Login(String login) {
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
    public void enter_Password(String password) {
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
