import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

public class CreateUserTest extends TestBase{
    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными ")
    public void createNewUser() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Registration registration = new Registration(driver);
        Profile profile = new Profile(driver);
        User user = new UserRandomData().getRandomUser();

        main.clickPersonalAccountBtn();
        login.clickRegistrationBtn();
        registration.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }

    //при обсуждении кейса ниже у некоторых появлялся баг, что пользователь не логинился. поэтому решила добавить тест
    @Test
    @DisplayName("Регистрация пользователя с валидными данными через API")
    @Description("Проверка, что можно зарегистрировать пользователя с валидными данными через API")
    public void createNewUserWithApi() {
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
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка, что нельзя зарегистрировать пользователя с паролем менее 6 символов")
    public void createNewUserWithShortPassword() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Registration registration = new Registration(driver);
        user = new UserRandomData().getRandomUser();
        user.setPassword(RandomStringUtils.randomAlphabetic(3));

        main.clickPersonalAccountBtn();
        login.clickRegistrationBtn();
        registration.setRegistrationNewUser(user.getName(), user.getEmail(), user.getPassword());
        registration.checkErrorAboutShortPassword();
    }
}
