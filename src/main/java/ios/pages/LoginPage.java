package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.LoginPageBase;
import common.pages.ProductsPageBase;
import enums.User;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(iosPredicate = "name == 'assets/src/img/swag-labs-logo.png'")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == '%s'`]")
    private ExtendedWebElement usernameTap;

    @ExtendedFindBy(iosPredicate = "name == 'test-LOGIN'")
    private ExtendedWebElement loginButtonLocator;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Error message'`]")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
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
}
