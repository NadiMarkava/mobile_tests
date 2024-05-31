package android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailing extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[2]")
    private ExtendedWebElement description;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")
    private ExtendedWebElement price;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public ProductDetailing(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return name.getText();
    }

    public String getProductDescription() {
        return description.getText();
    }

    public String getProductPrice() {
        return price.getText();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }
}
