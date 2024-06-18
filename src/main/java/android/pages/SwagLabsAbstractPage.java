package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import common.pages.SwagLabsAbstractPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SwagLabsAbstractPageBase.class)
public abstract class SwagLabsAbstractPage extends SwagLabsAbstractPageBase {

    public SwagLabsAbstractPage(WebDriver driver) {
        super(driver);
    }
}
