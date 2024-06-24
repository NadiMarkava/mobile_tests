package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.LoginWebPageBase;
import common.pages.ProductsWebPageBase;
import enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginWebPageBase.class)
public class LoginWebPage extends LoginWebPageBase {

    @FindBy(xpath = "//div[@class='login_logo' and text()='Swag Labs']")
    private ExtendedWebElement logo;

    @FindBy(css = "input#user-name")
    private ExtendedWebElement usernameField;

    @FindBy(css = "input[placeholder='Password']")
    private ExtendedWebElement passwordField;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButtonLocator;

    public LoginWebPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
    }

    @Override
    public ProductsWebPageBase clickLoginButton() {
        loginButtonLocator.click();
        return initPage(getDriver(), ProductsWebPageBase.class);
    }

    @Override
    public ProductsWebPageBase loginAsUser(User user) {
        usernameField.type(user.getName());
        passwordField.type(User.PASSWORD.getName());
        clickLoginButton();
        return initPage(getDriver(), ProductsWebPageBase.class);
    }
}
