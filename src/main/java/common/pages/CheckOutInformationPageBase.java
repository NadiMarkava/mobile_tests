package common.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckOutInformationPageBase extends SwagLabsAbstractPage {

    public CheckOutInformationPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String name);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract void clickCancelButton();

    public abstract CheckOutOverviewPageBase clickContinueButton();

    public abstract CheckOutOverviewPageBase fillOutInformationForm(String name, String lastName, String zipCode);
}
