package common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutOverviewPageBase extends SwagLabsAbstractPage implements IMobileUtils {

    public CheckOutOverviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int getProductsSize();

    public abstract void clickCancelButton();

    public abstract CheckOutCompletePageBase clickFinishButton();
}
