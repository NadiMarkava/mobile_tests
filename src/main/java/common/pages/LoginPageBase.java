package common.pages;

import enums.User;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends SwagLabsAbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickUser(User user);

    public abstract ProductsPageBase clickLoginButton();

    public abstract ProductsPageBase loginAsUser(User user);

    public abstract String getErrorMessage();
}
