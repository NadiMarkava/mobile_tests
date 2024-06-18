package utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import common.components.TopBarMenuBase;
import common.pages.SwagLabsAbstractPageBase;
import enums.NavMenu;

public class NavigationUtil implements ICustomTypePageFactory {

    public <T extends SwagLabsAbstractPageBase> SwagLabsAbstractPageBase clickNavMenuLink(NavMenu navMenu) {
        TopBarMenuBase menu = initPage(getDriver(), TopBarMenuBase.class);
        menu.clickNavMenu();
        menu.clickNavItem(navMenu);
        return initPage(navMenu.getPage());
    }
}
