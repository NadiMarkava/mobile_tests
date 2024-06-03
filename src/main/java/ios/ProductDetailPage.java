package ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.ProductDetailBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailBasePage.class)
public class ProductDetailPage extends ProductDetailBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-BACK TO PRODUCTS'`]")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Description']/XCUIElementTypeStaticText[1]")
    @Predicate
    private ExtendedWebElement name;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Price']")
    @Predicate
    private ExtendedWebElement price;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(backToProductsButton);
    }

    public String getProductName() {
        return name.getText();
    }

    public String getProductPrice() {
        return price.getText();
    }
}
