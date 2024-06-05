package android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import common.components.TopBarMenuBase;
import common.pages.CartPageBase;
import enums.NavMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TopBarMenuBase.class)
public class TopBarMenu extends TopBarMenuBase {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']")
    private ExtendedWebElement navMenu;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='%s']")
    private ExtendedWebElement navBarItem;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartImage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartImageText;

    public TopBarMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartImage() {
        cartImage.click();
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
        navMenu.click();
    }

    @Override
    public void clickNavItem(NavMenu navMenu) {
        navBarItem.format(navMenu.getName()).click();
    }
}
