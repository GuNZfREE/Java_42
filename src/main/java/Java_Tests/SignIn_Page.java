package Java_Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn_Page extends Starter_Page{

    public void enter_Login(String login) {
        WebElement signin_form = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));
        WebElement login_form = signin_form.findElement(By.cssSelector("#passp-field-login"));
        login_form.click();
        login_form.sendKeys(login + Keys.ENTER);
    }

    public void enter_Password(String password) {
        WebElement signin_form = (new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));
        WebElement pass_form = signin_form.findElement(By.cssSelector("#passp-field-passwd"));
        pass_form.sendKeys(password + Keys.ENTER);
    }
}
