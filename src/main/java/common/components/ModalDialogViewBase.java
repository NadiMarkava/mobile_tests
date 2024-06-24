package common.components;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ModalDialogViewBase extends AbstractPage {

    public ModalDialogViewBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOkButton();

    public abstract boolean isModalDialogViewPresent();
}
