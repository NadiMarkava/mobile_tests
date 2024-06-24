package common.pages;

import common.components.FilterBase;
import org.openqa.selenium.WebDriver;

public abstract class ProductsWebPageBase extends SwagLabsAbstractPageBase {

    public ProductsWebPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FilterBase getFilter();
}
