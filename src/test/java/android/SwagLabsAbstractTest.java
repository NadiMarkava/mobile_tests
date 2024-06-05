package android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import utils.AuthUtil;
import utils.NavigationUtil;

public class SwagLabsAbstractTest implements IAbstractTest, IMobileUtils {

    public AuthUtil getAuthUtil() {
        return new AuthUtil();
    }

    public NavigationUtil getNavUtil() {
        return new NavigationUtil();
    }
}
