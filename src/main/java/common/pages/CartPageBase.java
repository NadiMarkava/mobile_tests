package common.pages;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends SwagLabsAbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getProductsSize();

    public abstract ProductsPageBase clickContinueShoppingButton();

    public abstract CheckOutInformationPageBase clickCheckOutButton();
}
