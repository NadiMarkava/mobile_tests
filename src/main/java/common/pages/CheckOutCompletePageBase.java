package common.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckOutCompletePageBase extends SwagLabsAbstractPageBase {

    public CheckOutCompletePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isPonyExpressImagePresent();
}
