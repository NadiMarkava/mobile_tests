package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutInformationPage.class)
public class CheckOutInformationPage extends AbstractPage {

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

    public void typeFirstName(String name) {
        firstName.type(name);
    }

    public void typeLastName(String name) {
        lastName.type(name);
    }

    public void typeZipCode(String zipCode) {
        zipPostalCode.type(zipCode);
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public CheckOutOverviewPage fillOutInformationForm(String name, String lastName, String zipCode) {
        typeFirstName(name);
        typeLastName(lastName);
        typeZipCode(zipCode);
        clickContinueButton();
        return new CheckOutOverviewPage(getDriver());
    }
}
