package utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import common.components.TopBarMenuBase;
import common.pages.SwagLabsAbstractPage;
import enums.NavMenu;

public class NavigationUtil implements ICustomTypePageFactory {

    public SwagLabsAbstractPage clickNavMenuLink(NavMenu navMenu) {
        TopBarMenuBase menu = initPage(getDriver(), TopBarMenuBase.class);
        menu.clickNavMenu();
        menu.clickNavItem(navMenu);
        return initPage(getDriver(), SwagLabsAbstractPage.class);
    }
}
