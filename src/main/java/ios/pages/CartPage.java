package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.CartPageBase;
import common.pages.CheckOutInformationPageBase;
import common.pages.ProductsPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'YOUR CART'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ExtendedWebElement> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CONTINUE SHOPPING'`]")
    private ExtendedWebElement continueShoppingButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CHECKOUT'`]")
    private ExtendedWebElement checkOutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    public int getProductsSize() {
        return products.size();
    }

    public ProductsPageBase clickContinueShoppingButton() {
        continueShoppingButton.click();
        return initPage(getDriver(), ProductsPageBase.class);
    }

    public CheckOutInformationPageBase clickCheckOutButton() {
        checkOutButton.click();
        return initPage(getDriver(), CheckOutInformationPageBase.class);
    }
}
