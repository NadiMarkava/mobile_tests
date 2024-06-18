package ios.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.components.TopBarMenuBase;
import common.pages.CartPageBase;
import enums.NavMenu;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = TopBarMenuBase.class)
public class TopBarMenu extends TopBarMenuBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]")
    private ExtendedWebElement navMenu;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == '%s'`]")
    private ExtendedWebElement navBarItem;

    @ExtendedFindBy(iosPredicate = "name == 'test-Cart'")
    private ExtendedWebElement cartImage;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther")
    private ExtendedWebElement cartImageText;

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartImage() {
        int y = cartImage.getLocation().getY() + cartImage.getSize().getHeight() - 5;
        int x = cartImage.getLocation().getX() + cartImage.getSize().getWidth() / 2;
        tap(x, y);
        return initPage(CartPageBase.class);
    }

    @Override
    public String getCartImageText() {
        return cartImageText.getText();
    }

    @Override
    public boolean isCartImageTextPresent() {
        return cartImageText.isElementPresent();
    }

    @Override
    public void clickNavMenu() {
        int y = navMenu.getLocation().getY() + navMenu.getSize().getHeight() - 5;
        int x = navMenu.getLocation().getX() + navMenu.getSize().getWidth() / 2;
        tap(x, y);
    }

    @Override
    public void clickNavItem(NavMenu navMenu) {
        navBarItem.format(navMenu.getName()).click();
    }
}
