package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.CheckOutCompletePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutCompletePageBase.class)
public class CheckOutCompletePage extends CheckOutCompletePageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: COMPLETE!']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-CHECKOUT: COMPLETE!']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement ponyExpressImage;

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public boolean isPonyExpressImagePresent() {
        return ponyExpressImage.isElementPresent();
    }
}
