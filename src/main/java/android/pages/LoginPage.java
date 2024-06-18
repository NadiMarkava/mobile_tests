package android.pages;

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
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']//android.widget.ImageView[1]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement usernameTap;

    @FindBy(xpath = "//android.widget.TextView[@text='LOGIN']")
    private ExtendedWebElement loginButtonLocator;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private ExtendedWebElement errorMessage;

    @ExtendedFindBy(image = "images/login-bot.png")
    private ExtendedWebElement loginImage;

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

    @Override
    public boolean isImagePresent() {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.3);
        return loginImage.isElementPresent();
    }
}
