package common.pages;

import enums.User;
import org.openqa.selenium.WebDriver;

public abstract class LoginWebPageBase extends SwagLabsAbstractPageBase {

    public LoginWebPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductsWebPageBase clickLoginButton();

    public abstract ProductsWebPageBase loginAsUser(User user);
}
