package android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.LoginBasePage;
import common.ProductsBasePage;
import enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginBasePage.class)
public class LoginPage extends LoginBasePage {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[1]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement usernameTap;

    @FindBy(xpath = "//android.widget.TextView[@text='LOGIN']/..")
    private ExtendedWebElement loginButtonLocator;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
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
