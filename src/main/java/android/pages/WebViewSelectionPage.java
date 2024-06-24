package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.LoginPageBase;
import common.pages.WebViewPageBase;
import common.pages.WebViewSelectionPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewSelectionPageBase.class)
public class WebViewSelectionPage extends WebViewSelectionPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='WEBVIEW SELECTION']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.EditText[@text='enter a https url here...']")
    private ExtendedWebElement enterUrlField;

    @FindBy(xpath = "//android.widget.TextView[@text='GO TO SITE']")
    private ExtendedWebElement goToSiteButton;

    public WebViewSelectionPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public LoginPageBase clickGoToSiteButton() {
        goToSiteButton.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

    @Override
    public void typeUrl(String url) {
        enterUrlField.type(url);
    }

    @Override
    public WebViewPageBase navigateToWebViewPage(String url) {
        enterUrlField.type(url);
        clickGoToSiteButton();
        return initPage(getDriver(), WebViewPageBase.class);
    }
}
