package common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CheckOutOverviewBasePage extends AbstractPage {

    public CheckOutOverviewBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract List<String> getNames();

    public abstract String getProductPrice(String productName);

    public abstract void clickCancelButton();

    public abstract CheckOutCompleteBasePage clickFinishButton();
}
