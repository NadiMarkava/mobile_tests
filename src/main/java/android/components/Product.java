package android.components;

import android.pages.ProductDetailPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Product extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement productImage;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//android.widget.TextView[contains(@content-desc, 'test-Price')]")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return productName.getText();
    }

    public boolean isImagePresent() {
        return productImage.isElementPresent();
    }

    public String getPriceText() {
        return productPrice.getText();
    }

    public double getPrice() {
        return Double.parseDouble(productPrice.getText().replace("$", "")); // Sanitation and formatting
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isElementPresent();
    }

    public boolean isRemoveButtonPresent() {
        return removeButton.isElementPresent();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public ProductDetailPage clickProductName() {
        productName.click();
        return new ProductDetailPage(getDriver());
    }

    public void clickRemoveButton() {
        removeButton.click();
    }
}
