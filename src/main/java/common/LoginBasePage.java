package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import enums.User;
import org.openqa.selenium.WebDriver;

public abstract class LoginBasePage extends AbstractPage {

    public LoginBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void clickUser(User user);

    public abstract void clickLoginButton();

    public abstract ProductsBasePage loginAsUser(User user);

    public abstract String getErrorMessage();
}
