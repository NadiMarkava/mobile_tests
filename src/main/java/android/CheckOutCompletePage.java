package android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.CheckOutCompleteBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutCompleteBasePage.class)
public class CheckOutCompletePage extends CheckOutCompleteBasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: COMPLETE!']")
    private ExtendedWebElement title;

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }
}
