package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.ProductDetailPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailPageBase.class)
public class ProductDetailPage extends ProductDetailPageBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']")
    private ExtendedWebElement backToProductsButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.widget.TextView[contains(@content-desc, 'test-Price')]")
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
