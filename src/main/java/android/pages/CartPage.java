package android.pages;

import android.components.ProductDetailing;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPage.class)
public class CartPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductDetailing> products;

    @FindBy(xpath = "//android.widget.TextView[@text='CONTINUE SHOPPING']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public List<ProductDetailing> getProducts() {
        return products;
    }

    public int getProductsSize() {
        return products.size();
    }

    public ProductsPage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return new ProductsPage(getDriver());
    }

    public CheckOutInformationPage clickCheckOutButton() {
        checkOutButton.click();
        return new CheckOutInformationPage(getDriver());
    }
}
