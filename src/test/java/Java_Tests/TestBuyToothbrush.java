package Java_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestBuyToothbrush extends TestPrepare {

    @Test
    public void test3() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.searchToothbrushes();
        SearchPage searchPage = new SearchPage();
        searchPage.addPrices("999", "1999");
        searchPage.addAllToothbrushes();
        searchPage.checkAllToothbrushes(999, 1999);
        searchPage.addToOrder();

        OrderPage orderPage  = new OrderPage();
        orderPage.checkDeliveryText("бесплатной доставки осталось");
        orderPage.checkPrice();
        orderPage.addCountProduct(2999);
        orderPage.checkFreeDeliveryTitle("Поздравляем!");
        orderPage.checkFreeDelivery();
        orderPage.checkPrice();
    }
}
