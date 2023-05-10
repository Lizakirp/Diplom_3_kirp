import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private final By singInBtn = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public ForgotPassword(WebDriver webDriver) {
        driver = webDriver;
    }

    public void clickSingInBtn() {
        driver.findElement(singInBtn).click();
    }
}
