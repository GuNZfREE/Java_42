package Java_Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestChangeCity extends TestPrepare {

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
    public void test2(String nameCity) {
        String login = "GuNZfREE164";
        String password = "2178boston";

        MainPage mainPage = new MainPage();
        mainPage.changeCity(nameCity);
        mainPage.checkCity(nameCity);

        SignInPage signIn = mainPage.startSignIn();
        signIn.enterLogin(login);
        signIn.enterPassword(password);

        ProfilePage profile = mainPage.startProfile();
        profile.checkAddress();
    }
}
