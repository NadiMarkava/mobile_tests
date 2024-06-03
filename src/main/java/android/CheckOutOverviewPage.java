package android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.CheckOutCompleteBasePage;
import common.CheckOutOverviewBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutOverviewBasePage.class)
public class CheckOutOverviewPage extends CheckOutOverviewBasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: OVERVIEW']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']//android.widget.TextView[1]")
    private List<ExtendedWebElement> names;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../following-sibling::android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")
    private ExtendedWebElement price;

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
    public List<String> getNames() {
        return names.stream().map(p -> p.getText()).collect(Collectors.toList());
    }

    @Override
    public String getProductPrice(String productName) {
        return price.format(productName).getText();
    }

    @Override
    public void clickCancelButton() {
        cancelButton.click();
    }

    @Override
    public CheckOutCompleteBasePage clickFinishButton() {
        finishButton.click();
        return initPage(getDriver(), CheckOutCompleteBasePage.class);
    }
}
