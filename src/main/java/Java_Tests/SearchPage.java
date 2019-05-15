package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends MainPage {

    List<WebElement> allToothbrushes;

    @Step("Set Min and Max Price")
    public void addPrices(String  min, String max) {
        WebElement minPrice;
        WebElement maxPrice;
        
        
        minPrice = driver.findElement(By.id("glpricefrom"));
        maxPrice = driver.findElement(By.id("glpriceto"));

        minPrice.sendKeys(min);
        WebElement wind = driver.findElement(By.cssSelector("[class*='_1PQIIOelRL']"));
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(wind));

        maxPrice.sendKeys(max);
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(wind));
    }

    @Step("Open All List Toothbrushes")
    public void addAllToothbrushes() throws InterruptedException {
        WebElement showNewElement;

        showNewElement = driver.findElement(By.cssSelector(".n-pager-more__button"));
        while(true) {
            try {
                showNewElement.click();
            } catch (Exception e) {
                break;
            }
        }
        final int countElement = Integer.parseInt(
                driver.findElement(By.cssSelector(".n-search-preciser__results-count"))
                        .getAttribute("textContent").split(" ")[1]);
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver) {
                return driver.findElements(By
                        .cssSelector("[class*='grid-snippet_react']")).size() == countElement;
            }
        });
        allToothbrushes = driver.findElements(By.cssSelector("[class*='grid-snippet_react']"));
    }

    @Step("Check Toothbrushes by Prices")
    public void checkAllToothbrushes(int min, int max) {
        for(WebElement element : allToothbrushes) {
            String pr = element.findElement(By.cssSelector("[data-tid = 'c3eaad93']")).getAttribute("textContent");
            int price = Integer.parseInt(pr.replace(" ", ""));
            Assert.assertTrue(price >= min && price <= max);
        }
    }

    @Step("Add to Order")
    public void addToOrder() {
        allToothbrushes.get(allToothbrushes.size() - 2).findElement(By.cssSelector("[class*='_2w0qPDYwej']")).click();
        (new WebDriverWait(driver, 40))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .cssSelector("[class*='_1sjxYfIabK _26mXJDBxtH']")));
        allToothbrushes.get(allToothbrushes.size() - 2).findElement(By.cssSelector("[class*='_2w0qPDYwej']")).click();
    }
}
