package ios;

import android.pages.CheckOutOverviewPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.CheckOutInformationBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutInformationBasePage.class)
public class CheckOutInformationPage extends CheckOutInformationBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'CHECKOUT: INFORMATION'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    private ExtendedWebElement firstName;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    private ExtendedWebElement lastName;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    private ExtendedWebElement zipPostalCode;

    @ExtendedFindBy(iosPredicate = "name == 'test-CANCEL'")
    private ExtendedWebElement cancelButton;

    @ExtendedFindBy(iosPredicate = "name == 'test-CONTINUE'")
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
    public void clickContinueButton() {
        continueButton.click();
    }

    @Override
    public CheckOutOverviewPage fillOutInformationForm(String name, String lastName, String zipCode) {
        typeFirstName(name);
        typeLastName(lastName);
        typeZipCode(zipCode);
        clickContinueButton();
        return new CheckOutOverviewPage(getDriver());
    }
}
