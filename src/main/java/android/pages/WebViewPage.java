package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.WebViewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @FindBy(xpath = "//div[@class='login_logo' and text()='Swag Labs']")
    private ExtendedWebElement logo;

    public WebViewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(logo);
    }
}
