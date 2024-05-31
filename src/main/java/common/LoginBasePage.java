package common;

import android.pages.ProductsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginBasePage extends AbstractPage {

    public LoginBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void clickUser(User user);

    public abstract void clickLoginButton();

    public abstract ProductsBasePage loginAsUser(User user);

    public abstract String getErrorMessage();
}
