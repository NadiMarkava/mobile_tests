package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.LoginPageBase;
import common.pages.ProductsPageBase;
import enums.User;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'assets/src/img/swag-labs-logo.png'")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Username'`][1]")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Password'`][1]")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == '%s'`]")
    private ExtendedWebElement usernameTap;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGIN'")
    private ExtendedWebElement loginButtonLocator;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Error message'`]")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(image = "images/login-bot.png")
    private ExtendedWebElement loginImage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
    }

    @Override
    public boolean isUsernameFieldPresent() {
        return usernameField.isElementPresent();
    }

    @Override
    public boolean isPasswordFieldPresent() {
        return passwordField.isElementPresent();
    }

    @Override
    public boolean isLoginButtonPresent() {
        return loginButtonLocator.isElementPresent();
    }

    @Override
    public void clickUser(User user) {
        usernameTap.format(user.getName()).click();
    }

    @Override
    public ProductsPageBase clickLoginButton() {
        loginButtonLocator.click();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public ProductsPageBase loginAsUser(User user) {
        clickUser(user);
        clickLoginButton();
        return initPage(ProductsPageBase.class);
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Override
    public boolean isRobotImagePresent() {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);
        return loginImage.isElementPresent();
    }
}
