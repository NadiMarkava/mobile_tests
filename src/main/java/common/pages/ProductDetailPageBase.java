package common.pages;

import org.openqa.selenium.WebDriver;

public abstract class ProductDetailPageBase extends SwagLabsAbstractPageBase {

    public ProductDetailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductName();

    public abstract String getProductPrice();
}
