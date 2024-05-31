package ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.CheckOutCompleteBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutCompleteBasePage.class)
public class CheckOutCompletePage extends CheckOutCompleteBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'CHECKOUT: OVERVIEW'`]")
    private ExtendedWebElement title;

    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }
}
