package Java_Tests;

import org.testng.annotations.Test;

public class Test_1 extends Test_Prepare {

    @Test
    public void test_1() {
        String login = "GuNZfREE164";
        String password = "2178boston";

        Starter_Page main_page = new Starter_Page();
        SignIn_Page signIn = main_page.start_SignIn();
        signIn.enter_Login(login);
        signIn.enter_Password(password);
        main_page.check_Profile();
        main_page.check_login(login + "@yandex.ru");
    }
}
