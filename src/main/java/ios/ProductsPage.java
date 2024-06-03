package ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.CartBasePage;
import common.ProductDetailBasePage;
import common.ProductsBasePage;
import enums.SortItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsBasePage.class)
public class ProductsPage extends ProductsBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther")
    private ExtendedWebElement cartImage;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther")
    @Predicate
    private ExtendedWebElement cartImageText;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'PRODUCTS'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]/XCUIElementTypeOther/XCUIElementTypeOther")
    private ExtendedWebElement filterIcon;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='Sort items by...']/../XCUIElementTypeOther[@name='%s']")
    @Predicate
    private ExtendedWebElement sortBy;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Item title'`]")
    private List<ExtendedWebElement> productNames;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title' AND label == '%s'")
    private ExtendedWebElement productName;

    @Predicate
    @FindBy(xpath = "name == 'test-Item title' AND label == '%s'/../type == 'XCUIElementTypeImage' AND name CONTAINS 'assets/src/img/'")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'test-Price')]")
    @Predicate
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, '%s')]/../..//XCUIElementTypeStaticText[contains(@name, 'test-Price')]")
    @Predicate
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, '%s')]/../..//XCUIElementTypeOther[@name='ADD TO CART']")
    @Predicate
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@label, '%s')]/../..//XCUIElementTypeOther[@name='REMOVE']")
    @Predicate
    private ExtendedWebElement removeButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Toggle'")
    @Predicate
    private ExtendedWebElement toggle;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public CartBasePage clickCartImage() {
        cartImage.click();
        return initPage(getDriver(), CartBasePage.class);
    }

    @Override
    public String getCartImageText() {
        return cartImageText.getAttribute("name");
    }

    @Override
    public boolean isCartImageTextPresent() {
        return cartImageText.isElementPresent();
    }

    @Override
    public void selectSortItem(SortItem sortName) {
        filterIcon.click();
        sortBy.format(sortName.getName()).click();
    }

    @Override
    public List<String> getNames() {
        return productNames.stream().map(p -> p.getAttribute("value")).collect(Collectors.toList());
    }

    @Override
    public boolean isImagePresent(String productName) {
        return productImage.format(productName).isElementPresent();
    }

    @Override
    public String getPriceText(String productName) {
        return productPrice.format(productName).getText();
    }

    @Override
    public List<Double> getPrices() {
        return productPrices.stream().map(p -> Double.parseDouble(p.getText().replace("$", ""))).collect(Collectors.toList());
    }

    @Override
    public boolean isAddToCartButtonPresent(String productName) {
        return addToCartButton.format(productName).isElementPresent();
    }

    @Override
    public boolean isRemoveButtonPresent(String productName) {
        return removeButton.format(productName).isElementPresent();
    }

    @Override
    public void clickAddToCartButton(String productName) {
        addToCartButton.format(productName).click();
    }

    @Override
    public ProductDetailBasePage clickProductName(String name) {
        productName.format(name).click();
        return initPage(getDriver(), ProductDetailBasePage.class);
    }

    @Override
    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }

    @Override
    public void clickToggleIcon() {
        toggle.click();
    }
}
