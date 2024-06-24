package android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import common.components.FilterBase;
import common.components.ModalDialogViewBase;
import common.pages.LoginWebPageBase;
import common.pages.ProductsWebPageBase;
import enums.SortItem;
import enums.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MobileContextUtils;

public class WebSampleTest extends SwagLabsAbstractTest {

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySwitchingForAndroidView() {
        LoginWebPageBase loginPage = initPage(getDriver(), LoginWebPageBase.class);
        loginPage.open();
        ProductsWebPageBase productsPage = loginPage.loginAsUser(User.STANDART);
        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        ModalDialogViewBase modal = initPage(getDriver(), ModalDialogViewBase.class);
        if (modal.isModalDialogViewPresent()) {
            modal.clickOkButton();
        }
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB_CHROME);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page isn't opened");
        FilterBase filter = productsPage.getFilter();
        contextHelper.switchMobileContext(MobileContextUtils.View.NATIVE);
        Assert.assertTrue(filter.isFilterChecked(SortItem.AZ.getName()), "Filter is not checked");
    }
}
