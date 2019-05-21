package Java_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestBuyToothbrush extends TestPrepare {

    @Test
    public void testBuyToothbrush() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.inputToothbrushesInSearchBar();
        SearchPage searchPage = new SearchPage();
        searchPage.addPricesRange("999", "1999");
        searchPage.addAllToothbrushes();
        searchPage.checkPriceAllToothbrushes(999, 1999);
        searchPage.addToothbrushToOrder();

        OrderPage orderPage  = new OrderPage();
        orderPage.checkDeliveryText("бесплатной доставки осталось");
        orderPage.checkOrderPrice();
        orderPage.addProductToLimit(2999);
        orderPage.checkFreeDeliveryAfterAddProduct("Поздравляем!");
        orderPage.checkFreeDeliveryInOrderPrice();
        orderPage.checkOrderPrice();
    }
}
