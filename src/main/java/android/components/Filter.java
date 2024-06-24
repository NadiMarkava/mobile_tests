package android.components;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import common.components.FilterBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FilterBase.class)
public class Filter extends FilterBase {

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='%s']")
    private ExtendedWebElement filterItem;

    public Filter(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isFilterChecked(String filterName) {
        return filterItem.format(filterName).isChecked();
    }
}
