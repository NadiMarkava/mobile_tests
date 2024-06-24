package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.components.FilterBase;
import common.pages.ProductsWebPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsWebPageBase.class)
public class ProductsWebPage extends ProductsWebPageBase {

    @FindBy(xpath = "//span[@class='title' and text()='Products']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//span[@class='select_container']")
    private ExtendedWebElement filterIcon;

    public ProductsWebPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public FilterBase getFilter() {
        filterIcon.click();
        return initPage(getDriver(), FilterBase.class);
    }
}
