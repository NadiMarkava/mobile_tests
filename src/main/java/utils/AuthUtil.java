package utils;

import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import common.pages.LoginPageBase;
import common.pages.ProductsPageBase;
import enums.User;

public class AuthUtil implements ICustomTypePageFactory {

    public ProductsPageBase logIn(User user) {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.loginAsUser(user);
        return initPage(getDriver(), ProductsPageBase.class);
    }
}
