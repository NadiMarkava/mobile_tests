package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.CheckOutCompletePageBase;
import common.pages.CheckOutOverviewPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutOverviewPageBase.class)
public class CheckOutOverviewPage extends CheckOutOverviewPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'CHECKOUT: OVERVIEW'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ExtendedWebElement> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CANCEL'`]")
    private ExtendedWebElement cancelButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-FINISH'`]")
    private ExtendedWebElement finishButton;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public int getProductsSize() {
        return products.size();
    }

    @Override
    public void clickCancelButton() {
        cancelButton.click();
    }

    @Override
    public CheckOutCompletePageBase clickFinishButton() {
        swipe(finishButton);
        finishButton.click();
        return initPage(getDriver(), CheckOutCompletePageBase.class);
    }
}
