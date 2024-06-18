package android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import common.components.CartProductItemBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartProductItemBase.class)
public class CartProductItem extends CartProductItemBase {

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../following-sibling::android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")
    private ExtendedWebElement pricelabel;

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/../..//android.view.ViewGroup[@content-desc='test-REMOVE']")
    private ExtendedWebElement removeButton;

    public CartProductItem(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductPrice(String productName) {
        return pricelabel.format(productName).getText();
    }

    @Override
    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }
}
