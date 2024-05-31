package android.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import enums.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[1]")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']")
    private ExtendedWebElement usernameLocator;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private ExtendedWebElement passwordLocator;

    @FindBy(xpath = "//android.widget.TextView[@text='LOGIN']/..")
    private ExtendedWebElement loginButtonLocator;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private ExtendedWebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
    }

    public ProductsPage loginAsUser(User user) {
        usernameLocator.format(user.getName()).click();
        loginButtonLocator.click();
        return new ProductsPage(getDriver());
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
