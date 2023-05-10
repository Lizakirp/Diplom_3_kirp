import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SingInTest extends TestBase{
    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void singInWithBtnOnHeadPage() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        main.clickSingInCentralBtn();
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void singInWithProfileBtn() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        main.clickPersonalAccountBtn();
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnRegistrationPage() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Registration registration = new Registration(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        main.clickPersonalAccountBtn();
        login.clickRegistrationBtn();
        registration.clickSingInBtn();
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароль")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInWithBtnOnForgotPassword() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);
        ForgotPassword forgotPassword = new ForgotPassword(driver);

        userApi.userReg(user);
        main.clickPersonalAccountBtn();
        login.findForgottPasword();
        login.clickForgotPasswordBtn();
        forgotPassword.clickSingInBtn();
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }
}
