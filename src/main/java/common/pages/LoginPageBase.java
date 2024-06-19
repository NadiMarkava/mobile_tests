package common.pages;

import enums.User;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends SwagLabsAbstractPageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isUsernameFieldPresent();

    public abstract boolean isPasswordFieldPresent();

    public abstract boolean isLoginButtonPresent();

    public abstract void clickUser(User user);

    public abstract ProductsPageBase clickLoginButton();

    public abstract ProductsPageBase loginAsUser(User user);

    public abstract String getErrorMessage();

    public abstract boolean isRobotImagePresent();
}
