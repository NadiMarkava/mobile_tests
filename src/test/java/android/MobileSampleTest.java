package android;

import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.factory.DeviceType;
import common.components.CartProductItemBase;
import common.components.FilterBase;
import common.components.ModalDialogViewBase;
import common.components.TopBarMenuBase;
import common.pages.*;
import enums.NavMenu;
import enums.SortItem;
import enums.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class MobileSampleTest extends SwagLabsAbstractTest {
    String productName = "Sauce Labs Backpack";

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyLogInPage() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        Assert.assertTrue(loginPage.isUsernameFieldPresent(), "Field is not present");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Field is not present");
        Assert.assertTrue(loginPage.isLoginButtonPresent(), "Button is not present");
        Assert.assertTrue(loginPage.isRobotImagePresent(), "Image isn't present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySuccessLogin() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyUserCanLogOut() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page isn't opened");
        LoginPageBase loginPage = (LoginPageBase) getNavUtil().clickNavMenuLink(NavMenu.LOG_OUT);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyLoginUWithLockedOutUser() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        loginPage.loginAsUser(User.LOCKED);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, this user has been locked out.", "Error messages are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyUserCanDrawing() {
        getAuthUtil().logIn(User.STANDART);
        DrawingPageBase drawingPageBase = (DrawingPageBase) getNavUtil().clickNavMenuLink(NavMenu.DRAWING);
        drawingPageBase.drawLine();
        Assert.assertTrue(drawingPageBase.isDrawnLinePresent(), "Image is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCard() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        Assert.assertTrue(productsPage.isImagePresent(productName), "Image is not present");
        Assert.assertTrue(productName.matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+"), "Name does not match");
        Assert.assertTrue(productsPage.getPriceText(productName).matches("\\$[0-9]{1,2}.[0-9]{1,2}"), "Price does not match");
        Assert.assertTrue(productsPage.isAddToCartButtonPresent(productName), "'Add to card' button is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductDetailPage() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        String price = productsPage.getPriceText(productName);
        ProductDetailPageBase productDetailPage = productsPage.clickProductName(productName);
        Assert.assertEquals(productDetailPage.getProductName(), productName, "Names are not equal");
        Assert.assertEquals(productDetailPage.getProductPrice(), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySortBy() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        productsPage.clickProductsToggleIcon();
        List<Double> beforePrices = productsPage.getPrices();
        productsPage.selectSortItem(SortItem.LOWHIGH);
        Assert.assertNotEquals(beforePrices, productsPage.getPrices(), "Prices are equal");
        beforePrices.sort(Double::compareTo);
        Assert.assertEquals(beforePrices, productsPage.getPrices(), "Prices are not equal");
        productsPage.selectSortItem(SortItem.HIGHTOLOW);
        Collections.sort(beforePrices, Collections.reverseOrder());
        Assert.assertEquals(beforePrices, productsPage.getPrices(), "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyAddToCartAndRemoveButtons() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        productsPage.clickAddToCartButton(productName);
        Assert.assertFalse(productsPage.isAddToCartButtonPresent(productName), "'Add to Cart' button is present");
        Assert.assertTrue(productsPage.isRemoveButtonPresent(productName), "'Remove' button is not present");
        productsPage.clickRemoveButton(productName);
        Assert.assertFalse(productsPage.isRemoveButtonPresent(productName), "'Remove' button is present");
        Assert.assertTrue(productsPage.isAddToCartButtonPresent(productName), "'Add to Cart' button is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCanBeAddedToCart() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        String price = productsPage.getPriceText(productName);
        productsPage.clickAddToCartButton(productName);
        TopBarMenuBase menu = initPage(getDriver(), TopBarMenuBase.class);
        CartPageBase cartBasePage = menu.clickCartImage();
        Assert.assertTrue(cartBasePage.isPageOpened(), "Cart page isn't opened");
        Assert.assertEquals(cartBasePage.getProductsCount(), 1, "Products sizes are not equal");
        CartProductItemBase cartProduct = initPage(getDriver(), CartProductItemBase.class);
        Assert.assertEquals(cartProduct.getProductPrice(productName), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCanBeRemoved() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        productsPage.clickAddToCartButton(productName);
        TopBarMenuBase menu = initPage(getDriver(), TopBarMenuBase.class);
        Assert.assertEquals(menu.getCartImageText(), "1", "Sizes are not equal");
        CartPageBase cartPage = menu.clickCartImage();
        Assert.assertEquals(cartPage.getProductsCount(), 1, "Sizes are not equal");
        CartProductItemBase cartProduct = initPage(getDriver(), CartProductItemBase.class);
        cartProduct.clickRemoveButton(productName);
        Assert.assertEquals(cartPage.getProductsCount(), 0, "Sizes are not equal");
        if (getDevice().getDeviceType() == DeviceType.Type.IOS_PHONE) {
            Assert.assertEquals(menu.getCartImageText(), "", "Cart icon has text");
        } else {
            Assert.assertFalse(menu.isCartImageTextPresent(), "Cart icon has text");
        }
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isAddToCartButtonPresent(productName), "'Add to Cart' button is not present");
        Assert.assertFalse(productsPage.isRemoveButtonPresent(productName), "'Remove' button is present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckOverviewPage() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        productsPage.clickAddToCartButton(productName);
        CartPageBase cartPage = initPage(getDriver(), TopBarMenuBase.class).clickCartImage();
        CartProductItemBase cartProduct = initPage(getDriver(), CartProductItemBase.class);
        String price = cartProduct.getProductPrice(productName);
        CheckOutInformationPageBase checkOutInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutInformationPage.isPageOpened(), "Check out information page isn't opened");
        CheckOutOverviewPageBase checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        Assert.assertTrue(checkOutOverviewPage.isPageOpened(), "Check out overview page isn't opened");
        Assert.assertEquals(checkOutOverviewPage.getProductsSize(), 1, "Products sizes are not equal");
        Assert.assertEquals(cartProduct.getProductPrice(productName), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckCompletePage() {
        ProductsPageBase productsPage = getAuthUtil().logIn(User.STANDART);
        productsPage.clickAddToCartButton(productName);
        CartPageBase cartPage = initPage(getDriver(), TopBarMenuBase.class).clickCartImage();
        CheckOutInformationPageBase checkOutInformationPage = cartPage.clickCheckOutButton();
        CheckOutOverviewPageBase checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        CheckOutCompletePageBase checkOutComplete = checkOutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkOutComplete.isPageOpened(), "Check out complete is not opened");
        Assert.assertTrue(checkOutComplete.isPonyExpressImagePresent(), "Pony express ia not present");
    }
}
