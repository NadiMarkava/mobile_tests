package android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import common.CartBasePage;
import common.MenuPanelBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPanelBasePage.class)
public abstract class MenuPanelPage extends MenuPanelBasePage {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement cartImage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartImageText;

    public MenuPanelPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartBasePage clickCartImage() {
        cartImage.click();
        return initPage(getDriver(), CartBasePage.class);
    }

    @Override
    public String getCartImageText() {
        return cartImageText.getText();
    }

    @Override
    public boolean isCartImageTextPresent() {
        return cartImageText.isElementPresent();
    }
}
