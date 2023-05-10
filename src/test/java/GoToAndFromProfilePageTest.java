import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class GoToAndFromProfilePageTest extends TestBase {
    @Test
    @DisplayName("Переход в Личный кабинет неавторизованного пользователя")
    @Description("Проверка, что открывается раздел Личный кабинет(форма входа), когда пользователь не авторизован")
    public void goToProfilePageWithoutAuth() {
        Main main = new Main(driver);
        Login login = new Login(driver);

        main.clickPersonalAccountBtn();
        login.checkSingInBtnIsDisplayed();
    }

    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("Проверка, что открывается раздел Личный кабинет, когда пользователь авторизован")
    public void goToProfilePageWithAuth() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.checkAccountTextIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета неавторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор, когда пользователь не авторизован")
    public void goFromProfilePageWithoutAuth() {
        Main main = new Main(driver);
        Login login = new Login(driver);

        main.clickPersonalAccountBtn();
        login.clickConstructorBtn();
        main.checkCreateBurgerTextIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя в Конструктор")
    @Description("Проверка, что открывается раздел Конструктор и есть кнопка Оформить заказ, когда пользователь авторизован")
    public void goFromProfilePageWithAuth() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.clickConstructorBtn();
        main.checkCreateBurgerBtnIsDisplayed();
    }

    @Test
    @DisplayName("Переход из Личного кабинета авторизованного пользователя по клику на логотип")
    @Description("Проверка, что открывается главная станица, когда авторизованный пользователь кликнул на логотип")
    public void goFromProfilePageWithAuthWhenClickLogo() {
        Main main = new Main(driver);
        Login login = new Login(driver);
        Profile profile = new Profile(driver);

        userApi.userReg(user);
        login.setSingInUserAccount(user.getEmail(), user.getPassword());
        main.clickPersonalAccountBtn();
        profile.clickLogoBtn();
        main.checkCreateBurgerBtnIsDisplayed();
    }
}
