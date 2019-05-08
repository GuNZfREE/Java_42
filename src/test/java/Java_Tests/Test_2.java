package Java_Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Test_Listener.class)
public class Test_2 extends Test_Prepare {

    @DataProvider(name="ListCity")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        { "Хвалынск" },
                        { "Магадан" },
                        { "Владимир" }
                };
    }

    @Test(dataProvider="ListCity")
    public void test_2(String nameCity) {
        String login = "GuNZfREE164";
        String password = "2178boston";

        Starter_Page mainPage = new Starter_Page();
        mainPage.change_City(nameCity);
        mainPage.check_City(nameCity);

        SignIn_Page signIn = mainPage.start_SignIn();
        signIn.enter_Login(login);
        signIn.enter_Password(password);

        Profile_Page profile = mainPage.start_Profile();
        profile.check_Address();
    }
}
