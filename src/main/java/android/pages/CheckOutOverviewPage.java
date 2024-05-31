package android.pages;

import android.components.ProductDetailing;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutOverviewPage.class)
public class CheckOutOverviewPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductDetailing> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CANCEL']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-FINISH']")
    private ExtendedWebElement finishButton;

    public CheckOutOverviewPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public List<ProductDetailing> getProducts() {
        return products;
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public CheckOutComplete clickFinishButton() {
        finishButton.click();
        return new CheckOutComplete(getDriver());
    }
}
