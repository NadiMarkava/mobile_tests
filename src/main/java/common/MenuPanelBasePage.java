package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuPanelBasePage extends AbstractPage {

    public MenuPanelBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract CartBasePage clickCartImage();

    public abstract String getCartImageText();

    public abstract boolean isCartImageTextPresent();
}
