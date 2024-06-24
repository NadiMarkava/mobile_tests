package common.components;

import common.pages.SwagLabsAbstractPageBase;
import org.openqa.selenium.WebDriver;

public abstract class FilterBase extends SwagLabsAbstractPageBase {

    public FilterBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isFilterChecked(String filterName);
}
