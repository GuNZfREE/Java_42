package Java_Tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Test_Listener.class)
public class Test_1 extends Test_Prepare {

    @Test
    public void test_1() {
        String login = "GuNZfREE164";
        String password = "2178boston";

        Starter_Page mainPage = new Starter_Page();
        SignIn_Page signIn = mainPage.start_SignIn();
        signIn.enter_Login(login);
        signIn.enter_Password(password);
        mainPage.check_Profile();
        mainPage.check_Login(login + "@yandex.ru");
    }
}
