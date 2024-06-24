package android.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.pages.DrawingPageBase;
import io.appium.java_client.HasSettings;
import io.appium.java_client.Setting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='DRAWING']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-DRAWING-SCREEN']")
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
