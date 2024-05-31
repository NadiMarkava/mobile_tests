package android.components;

import android.pages.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartImage;


    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup//android.widget.TextView")
    private ExtendedWebElement cartImageText;

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartButton() {
        cartImage.click();
        return new CartPage(driver);
    }

    public String getCartImageText() {
        return cartImageText.getText();
    }

    public boolean isCartImageTextPresent() {
        return cartImageText.isElementPresent();
    }
}
