package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartBasePage extends AbstractPage {

    public CartBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract int getProductsSize();

    public abstract List<String> getNames();

    public abstract ProductsBasePage clickContinueShoppingButton();

    public abstract CheckOutInformationBasePage clickCheckOutButton();

    public abstract String getProductPrice(String productName);

    public abstract void clickRemoveButton(String productName);
}
