package Java_Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Test_Listener.class)
public class Test_2 extends Test_Prepare {

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        { "Хвалынск" },
                        { "Магадан" },
                        { "Владимир" }
                };
    }

    @Test(dataProvider="SearchProvider")
    public void test_2(String name_City) {
        String login = "GuNZfREE164";
        String password = "2178boston";

        Starter_Page main_page = new Starter_Page();
        main_page.change_City(name_City);
        main_page.check_City(name_City);

        SignIn_Page signIn = main_page.start_SignIn();
        signIn.enter_Login(login);
        signIn.enter_Password(password);

        Profile_Page profile = main_page.start_Profile();
        profile.check_Address();
    }
}
