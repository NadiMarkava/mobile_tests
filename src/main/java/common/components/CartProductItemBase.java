package common.components;

import common.pages.SwagLabsAbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CartProductItemBase extends SwagLabsAbstractPage {
    public CartProductItemBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductPrice(String productName);

    public abstract void clickRemoveButton(String productName);
}
