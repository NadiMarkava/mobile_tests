package android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.CartBasePage;
import common.ProductsBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartBasePage.class)
public class CartPage extends CartBasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='YOUR CART']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ExtendedWebElement> products;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']//android.widget.TextView[1]")
    private List<ExtendedWebElement> names;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../following-sibling::android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../..//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//android.widget.TextView[@text='CONTINUE SHOPPING']")
    private ExtendedWebElement continueShoppingButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public int getProductsSize() {
        return products.size();
    }

    public List<String> getNames() {
        return names.stream().map(p -> p.getText()).collect(Collectors.toList());
    }

    public String getProductPrice(String productName) {
        return price.format(productName).getText();
    }

    public ProductsBasePage clickContinueShoppingButton() {
        continueShoppingButton.click();
        return initPage(getDriver(), ProductsBasePage.class);
    }

    public CheckOutInformationPage clickCheckOutButton() {
        checkOutButton.click();
        return new CheckOutInformationPage(getDriver());
    }

    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }
}
