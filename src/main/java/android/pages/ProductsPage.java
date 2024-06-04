package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.ProductDetailPageBase;
import common.pages.ProductsPageBase;
import enums.SortItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private ExtendedWebElement filterIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Sort items by...']/../..//android.widget.TextView[@text='%s']/..")
    private ExtendedWebElement sortBy;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../android.widget.ImageView")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='%s']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/..//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Toggle']")
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
        return initPage(getDriver(), ProductDetailPageBase.class);
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
