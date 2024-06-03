package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import enums.SortItem;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductsBasePage extends AbstractPage {

    public ProductsBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract CartBasePage clickCartImage();

    public abstract String getCartImageText();

    public abstract boolean isCartImageTextPresent();

    public abstract void selectSortItem(SortItem sortName);

    public abstract List<String> getNames();

    public abstract boolean isImagePresent(String productName);

    public abstract String getPriceText(String productName);

    public abstract List<Double> getPrices();

    public abstract boolean isAddToCartButtonPresent(String productName);

    public abstract boolean isRemoveButtonPresent(String productName);

    public abstract void clickAddToCartButton(String productName);

    public abstract ProductDetailBasePage clickProductName(String name);

    public abstract void clickRemoveButton(String productName);

    public abstract void clickToggleIcon();
}
