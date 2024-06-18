package common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends SwagLabsAbstractPageBase implements IMobileUtils {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawPicture();

    public abstract boolean isDrawingPresent();
}
