package android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import common.pages.ProductsPageBase;
import common.pages.SwagLabsAbstractPage;
import enums.NavMenu;
import enums.User;
import utils.AuthUtil;
import utils.NavigationUtil;

public class SwagLabsAbstractTest implements IAbstractTest, IMobileUtils {

    public ProductsPageBase logIn(User user) {
        AuthUtil authUtil = new AuthUtil();
        authUtil.logIn(user);
        return initPage(getDriver(), ProductsPageBase.class);
    }

    public SwagLabsAbstractPage openNavMenuLink(NavMenu navMenu) {
        NavigationUtil navigationUtil = new NavigationUtil();
        navigationUtil.clickNavMenuLink(navMenu);
        return initPage(getDriver(), SwagLabsAbstractPage.class);
    }
}
