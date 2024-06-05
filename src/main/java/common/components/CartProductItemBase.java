package common.components;

import common.pages.SwagLabsAbstractPageBase;
import org.openqa.selenium.WebDriver;

public abstract class CartProductItemBase extends SwagLabsAbstractPageBase {
    public CartProductItemBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductPrice(String productName);

    public abstract void clickRemoveButton(String productName);
}
