package ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.LoginBasePage;
import common.ProductsBasePage;
import enums.User;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginBasePage.class)
public class LoginPage extends LoginBasePage {

    @ExtendedFindBy(iosPredicate = "name == 'assets/src/img/swag-labs-logo.png'")
    private ExtendedWebElement logo;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == '%s'`]")
    private ExtendedWebElement usernameLocator;

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
        usernameLocator.format(user.getName()).click();
    }

    @Override
    public void clickLoginButton() {
        loginButtonLocator.click();
    }

    @Override
    public ProductsBasePage loginAsUser(User user) {
        clickUser(user);
        clickLoginButton();
        return initPage(getDriver(), ProductsBasePage.class);
    }

    @Override
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
