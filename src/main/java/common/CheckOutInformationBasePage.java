package common;

import android.pages.CheckOutOverviewPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutInformationBasePage extends AbstractPage {

    public CheckOutInformationBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract void typeFirstName(String name);

    public abstract void typeLastName(String lastName);

    public abstract void typeZipCode(String zipCode);

    public abstract void clickCancelButton();

    public abstract void clickContinueButton();

    public abstract CheckOutOverviewPage fillOutInformationForm(String name, String lastName, String zipCode);
}
