package utils;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class ClickUtil implements IMobileUtils {

    public void tapByCoordinates(ExtendedWebElement webElement) {
        int y = webElement.getLocation().getY() + webElement.getSize().getHeight() - 5;
        int x = webElement.getLocation().getX() + webElement.getSize().getWidth() / 2;
        tap(x, y);
    }
}
