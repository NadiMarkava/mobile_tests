package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.CheckOutCompletePageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutCompletePageBase.class)
public class CheckOutCompletePage extends CheckOutCompletePageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'CHECKOUT: COMPLETE!'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeImage[`name == 'assets/src/img/pony-express.png'`]")
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
