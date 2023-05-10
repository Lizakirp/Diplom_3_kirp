import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SingOutTest extends TestBase {

    @Test
    @DisplayName("Выход из аккаунта авторизованного пользователя")
    @Description("Проверка, что можно выйти из аккаунта авторизованного пользователя")
    public void canSingOutFromProfile() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.clickSingOutBtn();
        profile.checkAccountTextIsDisplayed();
    }
}
