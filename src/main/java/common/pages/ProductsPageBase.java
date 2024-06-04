package common.pages;

import enums.SortItem;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductsPageBase extends SwagLabsAbstractPage {

    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectSortItem(SortItem sortName);

    public abstract boolean isImagePresent(String productName);

    public abstract String getPriceText(String productName);

    public abstract List<Double> getPrices();

    public abstract boolean isAddToCartButtonPresent(String productName);

    public abstract boolean isRemoveButtonPresent(String productName);

    public abstract void clickAddToCartButton(String productName);

    public abstract ProductDetailPageBase clickProductName(String name);

    public abstract void clickRemoveButton(String productName);

    public abstract void clickToggleIcon();
}
