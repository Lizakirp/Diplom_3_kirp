import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class MenuTest extends TestBase{
    @Test
    @DisplayName("К разделу 'Булки'")
    @Description("Проверка, что можно перейти в раздел 'Булки' ")
    public void openCatalogBuns() {
        Main main = new Main(driver);

        main.clickSaucesBtn();
        main.clickBunBtn();
        main.checkBunsIsDisplayed();
    }

    @Test
    @DisplayName("К разделу 'Соусы'")
    @Description("Проверка, что можно перейти в раздел 'Соусы' ")
    public void openCatalogSauces() {
        Main main = new Main(driver);

        main.clickFillingsBtn();
        main.clickSaucesBtn();
        main.checkSaucesIsDisplayed();
    }

    @Test
    @DisplayName("К разделу 'Начинки'")
    @Description("Проверка, что можно перейти в раздел 'Начинки' ")
    public void openCatalogFillings() {
        Main main = new Main(driver);

        main.clickSaucesBtn();
        main.clickFillingsBtn();
        main.checkFillingsIsDisplayed();
    }
}
