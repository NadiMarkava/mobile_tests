package common.components;

import common.pages.CartPageBase;
import common.pages.SwagLabsAbstractPage;
import enums.NavMenu;
import org.openqa.selenium.WebDriver;

public abstract class TopBarMenuBase extends SwagLabsAbstractPage {

    public TopBarMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCartImage();

    public abstract String getCartImageText();

    public abstract boolean isCartImageTextPresent();

    public abstract void clickNavMenu();

    public abstract SwagLabsAbstractPage clickNavItem(NavMenu navMenu);
}
