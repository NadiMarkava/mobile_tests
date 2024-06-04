package ios.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.components.CartProductItemBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartProductItemBase.class)
public class CartProductItem extends CartProductItemBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeOther[`name == 'test-Price'`]/**/XCUIElementTypeStaticText")
    private ExtendedWebElement price;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[$type == 'XCUIElementTypeStaticText' AND label == '%s'$][-2]/**/XCUIElementTypeOther[`name == 'test-Price'`]/**/XCUIElementTypeOther[`label == 'REMOVE'`][1]")
    private ExtendedWebElement removeButton;

    public CartProductItem(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductPrice(String productName) {
        return price.format(productName).getText();
    }

    @Override
    public void clickRemoveButton(String productName) {
        removeButton.format(productName).click();
    }
}
