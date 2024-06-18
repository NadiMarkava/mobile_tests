package common.components;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import common.pages.CartPageBase;
import common.pages.SwagLabsAbstractPageBase;
import enums.NavMenu;
import org.openqa.selenium.WebDriver;

public abstract class TopBarMenuBase extends SwagLabsAbstractPageBase implements IMobileUtils {

    public TopBarMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCartImage();

    public abstract String getCartImageText();

    public abstract boolean isCartImageTextPresent();

    public abstract void clickNavMenu();

    public abstract void clickNavItem(NavMenu navMenu);
}
