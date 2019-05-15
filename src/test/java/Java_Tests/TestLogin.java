package Java_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestLogin extends TestPrepare {

    @Test
    public void test1() {
        String login = "GuNZfREE164";
        String password = "2178boston";

        MainPage mainPage = new MainPage();
        SignInPage signIn = mainPage.startSignInPage();
        signIn.enterLogin(login);
        signIn.enterPassword(password);
        mainPage.checkProfileTitle();
        mainPage.checkLogin(login + "@yandex.ru");
    }
}
