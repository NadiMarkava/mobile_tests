package ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.DrawingPageBase;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'DRAWING'`]")
    private ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name == 'Signature Pad demo'")
    private ExtendedWebElement signature;

    @ExtendedFindBy(image = "images/line.png")
    private ExtendedWebElement drawingImage;

    public DrawingPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public void drawLine() {
        int startX = signature.getLocation().getX() + signature.getSize().getWidth() / 10;
        int startY = signature.getLocation().getY() + signature.getSize().getHeight() / 10;
        int endX = startX * 7;
        swipe(startX, startY, endX, startY, 1000);
    }

    @Override
    public boolean isDrawnLinePresent() {
        HasSettings driver = (HasSettings) getDriver();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.4);
        return drawingImage.isElementPresent();
    }
}
