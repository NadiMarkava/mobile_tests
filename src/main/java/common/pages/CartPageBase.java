package common.pages;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends SwagLabsAbstractPageBase {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getProductsCount();

    public abstract ProductsPageBase clickContinueShoppingButton();

    public abstract CheckOutInformationPageBase clickCheckOutButton();
}
