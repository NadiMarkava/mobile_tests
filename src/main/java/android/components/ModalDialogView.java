package android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import common.components.ModalDialogViewBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ModalDialogViewBase.class)
public class ModalDialogView extends ModalDialogViewBase {

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.android.chrome:id/modal_dialog_view']")
    private ExtendedWebElement modalDialogView;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.chrome:id/positive_button']")
    private ExtendedWebElement okButton;

    public ModalDialogView(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOkButton() {
        okButton.click();
    }

    @Override
    public boolean isModalDialogViewPresent() {
        return modalDialogView.isElementPresent();
    }
}
