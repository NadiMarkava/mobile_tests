package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailBasePage extends AbstractPage {

    public ProductDetailBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductName();

    public abstract String getProductPrice();
}
