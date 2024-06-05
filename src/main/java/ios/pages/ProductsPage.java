package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.ProductDetailPageBase;
import common.pages.ProductsPageBase;
import enums.SortItem;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'PRODUCTS'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]")
    private ExtendedWebElement filterIcon;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeOther' AND label == 'Sort items by...'$][-2]/**/XCUIElementTypeOther[`name == '%s'`]")
    private ExtendedWebElement sortBy;

    @ExtendedFindBy(iosPredicate = "name == 'test-Item title' AND label == '%s'")
    private ExtendedWebElement productName;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeImage[``name CONTAINS 'assets/src/img/'`]")
    private ExtendedWebElement productImage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private List<ExtendedWebElement> productPrices;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private ExtendedWebElement productPrice;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeOther[`name == 'test-REMOVE'`]")
    private ExtendedWebElement removeButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-Toggle'")
    private ExtendedWebElement toggle;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public void selectSortItem(SortItem sortName) {
        filterIcon.click();
        sortBy.format(sortName.getName()).click();
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
    public ProductDetailPageBase clickProductName(String name) {
        productName.format(name).click();
        return initPage(ProductDetailPageBase.class);
    }

    @Override
    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }

    @Override
    public void clickProductsToggleIcon() {
        toggle.click();
    }
}
