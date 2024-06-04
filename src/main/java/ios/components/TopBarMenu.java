package ios.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.components.TopBarMenuBase;
import common.pages.CartPageBase;
import common.pages.SwagLabsAbstractPage;
import enums.NavMenu;
import org.openqa.selenium.WebDriver;
import utils.ClickUtil;

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
        ClickUtil clickUtil = new ClickUtil();
        clickUtil.tapByCoordinates(cartImage);
        return initPage(getDriver(), CartPageBase.class);
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
        ClickUtil clickUtil = new ClickUtil();
        clickUtil.tapByCoordinates(navMenu);
    }

    @Override
    public SwagLabsAbstractPage clickNavItem(NavMenu navMenu) {
        navBarItem.format(navMenu.getName()).click();
        return initPage(getDriver(), SwagLabsAbstractPage.class);
    }
}
