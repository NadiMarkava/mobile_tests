package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.CheckOutCompletePageBase;
import common.pages.CheckOutOverviewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutOverviewPageBase.class)
public class CheckOutOverviewPage extends CheckOutOverviewPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ExtendedWebElement> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CANCEL']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
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
        finishButton.click();
        return initPage(CheckOutCompletePageBase.class);
    }
}
