package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.CheckOutInformationPageBase;
import common.pages.CheckOutOverviewPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutInformationPageBase.class)
public class CheckOutInformationPage extends CheckOutInformationPageBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'CHECKOUT: INFORMATION'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == 'test-First Name'")
    private ExtendedWebElement firstName;

    @ExtendedFindBy(iosPredicate = "name == 'test-Last Name'")
    private ExtendedWebElement lastName;

    @ExtendedFindBy(iosPredicate = "name == 'test-Zip/Postal Code'")
    private ExtendedWebElement zipPostalCode;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CANCEL'`]")
    private ExtendedWebElement cancelButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CONTINUE'`]")
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
        return initPage(getDriver(), CheckOutOverviewPageBase.class);
    }

    @Override
    public CheckOutOverviewPageBase fillOutInformationForm(String name, String lastName, String zipCode) {
        typeFirstName(name);
        typeLastName(lastName);
        typeZipCode(zipCode);
        clickContinueButton();
        return initPage(getDriver(), CheckOutOverviewPageBase.class);
    }
}
