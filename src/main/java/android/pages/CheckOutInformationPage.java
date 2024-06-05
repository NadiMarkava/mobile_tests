package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import common.pages.CheckOutInformationPageBase;
import common.pages.CheckOutOverviewPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutInformationPageBase.class)
public class CheckOutInformationPage extends CheckOutInformationPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='CHECKOUT: INFORMATION']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private ExtendedWebElement firstName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private ExtendedWebElement lastName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private ExtendedWebElement zipPostalCode;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CANCEL']")
    private ExtendedWebElement cancelButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private ExtendedWebElement continueButton;

    public CheckOutInformationPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public void typeFirstName(String name) {
        firstName.type(name);
    }

    @Override
    public void typeLastName(String name) {
        lastName.type(name);
    }

    @Override
    public void typeZipCode(String zipCode) {
        zipPostalCode.type(zipCode);
    }

    @Override
    public void clickCancelButton() {
        cancelButton.click();
    }

    @Override
    public CheckOutOverviewPageBase clickContinueButton() {
        continueButton.click();
        return initPage(CheckOutOverviewPageBase.class);
    }

    @Override
    public CheckOutOverviewPageBase fillOutInformationForm(String name, String lastName, String zipCode) {
        typeFirstName(name);
        typeLastName(lastName);
        typeZipCode(zipCode);
        clickContinueButton();
        return initPage(CheckOutOverviewPageBase.class);
    }
}
