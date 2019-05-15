package Java_Tests;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderPage extends  MainPage {
    private static List<WebElement> priceList = null;

    private int parseInt(String str) {
        Pattern pat = Pattern.compile("[^\\d]");
        Matcher matcher = pat.matcher(str);
        return Integer.parseInt(matcher.replaceAll(""));
    }

    @Step("Check Price in Order Page")
    public void checkOrderPrice() {
        priceList = driver.findElements(By.cssSelector("[class *= '_1Q9ASvPbPN']"));
        int regularPrice = parseInt(priceList.get(0).findElement(By.cssSelector("[data-auto*='value']"))
                                         .getAttribute("textContent"));

        String tempText = priceList.get(1).findElement(By.cssSelector("[data-auto*='value']"))
                .getAttribute("textContent");
        int deliveryPrice =  tempText.contains("бесплатно") ? 0 : parseInt(tempText);

        int sale = 0;
        if (priceList.size() == 4) {
            tempText = priceList.get(2).findElement(
                    By.xpath("//span[text()[contains(., 'Скидка')]]/following-sibling::span"))
                    .getAttribute("textContent");
            sale = parseInt(tempText);
        }
        int index = sale == 0 ? 2 : 3;
        int summaryPrice = parseInt(priceList.get(index).findElement(
                By.cssSelector("[class*='_1oBlNqVHPq']"))
                .getAttribute("textContent"));
        Assert.assertEquals(regularPrice + deliveryPrice - sale, summaryPrice);

    }

    @Step("Check Free Delivery")
    public void checkFreeDeliveryInOrderPrice() {
        String priceStr = priceList.get(1).findElement(By.cssSelector("[data-auto*='value']"))
                .getAttribute("textContent").replace(" ", "");
        Assert.assertTrue(priceStr.contains("бесплатно"));
    }

    @Step("Add One More Product")
    public void addProductToLimit(int priceLimit) {
        String priceStr = driver.findElement(By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
                .getAttribute("textContent");
        int regylarPrice = parseInt(priceStr);
        while(regylarPrice < priceLimit) {
            driver.findElement(By.xpath("//button//span[text()='+']")).click();
            priceStr = driver.findElement(By.xpath("//div[@data-auto='CartOfferPrice']/span/span/span"))
                    .getAttribute("textContent");
            regylarPrice = parseInt(priceStr);
        }
    }

    public void checkFreeDeliveryAfterAddProduct(String title) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.attributeContains(
                        By.cssSelector("[class*='_3EX9adn_xp']"), "textContent", "Поздравляем!"));
        checkDeliveryText(title);
    }

    @Step("Check Free Delivery Title After Added Product")
    public void checkDeliveryText(String textDelivery) {
        WebElement freeCome = driver.findElement(By.cssSelector("[class *= '_3EX9adn_xp']"));
        Assert.assertTrue(freeCome.getAttribute("textContent").contains(textDelivery));
    }
}
