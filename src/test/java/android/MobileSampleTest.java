package android;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import common.*;
import enums.SortItem;
import enums.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySuccessLogin() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.TEST_STANDART);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyLoginUWithLockedOutUser() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        loginPage.loginAsUser(User.LOCKED);
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, this user has been locked out.");
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCard() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.TEST_STANDART);
        List<String> productNames = productsPage.getNames();
        String productName = productNames.get(0);
        Assert.assertTrue(productsPage.isImagePresent(productName), "Image is not present");
        Assert.assertTrue(productName.matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+"), "Name does not match");
        Assert.assertTrue(productsPage.getPriceText(productName).matches("\\$[0-9]{1,2}.[0-9]{1,2}"), "Price does not match");
        Assert.assertTrue(productsPage.isAddToCartButtonPresent(productName), "'Add to card' button is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductDetailPage() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
        String price = productsPage.getPriceText(productName);
        ProductDetailBasePage productDetailPage = productsPage.clickProductName(productName);
        Assert.assertEquals(productDetailPage.getProductName(), productName, "Names are not equal");
        Assert.assertEquals(productDetailPage.getProductPrice(), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySortBy() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        productsPage.clickToggleIcon();
        List<Double> beforePrices = productsPage.getPrices();
        productsPage.selectSortItem(SortItem.LOWHIGH);
        Assert.assertNotEquals(beforePrices, productsPage.getPrices(), "Prices are equal");
        //duplicates
        Assert.assertEquals(beforePrices, productsPage.getPrices(), "Prices are not equal");
        productsPage.selectSortItem(SortItem.HIGHTOLOW);
        Collections.sort(beforePrices, Collections.reverseOrder());
        Assert.assertEquals(beforePrices, productsPage.getPrices(), "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyAddToCartAndRemoveButtons() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
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
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
        String price = productsPage.getPriceText(productName);
        productsPage.clickAddToCartButton(productName);
        CartBasePage cartBasePage = productsPage.clickCartImage();
//        MenuPanelBasePage menuPanelBasePage = initPage(getDriver(), MenuPanelBasePage.class);
//        CartBasePage cartBasePage = menuPanelBasePage.clickCartImage();
        Assert.assertTrue(cartBasePage.isPageOpened(), "Cart page isn't opened");
        String cartProductName = cartBasePage.getNames().get(0);
        Assert.assertEquals(cartProductName, productName, "Names are not equal");
        Assert.assertEquals(cartBasePage.getProductPrice(cartProductName), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCanBeRemoved() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
        productsPage.clickAddToCartButton(productName);
//        MenuPanelBasePage menuPanelBasePage = initPage(getDriver(), MenuPanelBasePage.class);
//        Assert.assertEquals(menuPanelBasePage.getCartImageText(), "1", "Sizes are not equal");
//        CartBasePage cartBasePage = menuPanelBasePage.clickCartImage();
        Assert.assertEquals(productsPage.getCartImageText(), "1", "Sizes are not equal");
        CartBasePage cartPage = productsPage.clickCartImage();
        Assert.assertEquals(cartPage.getProductsSize(), 1, "Sizes are not equal");
        cartPage.clickRemoveButton(productName);
        Assert.assertEquals(cartPage.getProductsSize(), 0, "Sizes are not equal");
//        Assert.assertFalse(menuPanelBasePage.isCartImageTextPresent(), "Cart icon has text");
        Assert.assertFalse(productsPage.isCartImageTextPresent(), "Cart icon has text");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isAddToCartButtonPresent(productName), "'Add to Cart' button is not present");
        Assert.assertFalse(productsPage.isRemoveButtonPresent(productName), "'Remove' button is present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckOverviewPage() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
        productsPage.clickAddToCartButton(productName);
        //        MenuPanelBasePage menuPanelBasePage = initPage(getDriver(), MenuPanelBasePage.class);
//        CartBasePage cartBasePage = menuPanelBasePage.clickCartImage();
        CartBasePage cartPage = productsPage.clickCartImage();
        String price = cartPage.getProductPrice(productName);
        CheckOutInformationBasePage checkOutInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutInformationPage.isPageOpened(), "Check out information page isn't opened");
        CheckOutOverviewBasePage checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        Assert.assertTrue(checkOutOverviewPage.isPageOpened(), "Check out overview page isn't opened");
        Assert.assertEquals(checkOutOverviewPage.getNames().get(0), productName, "Names are not equal");
        Assert.assertEquals(checkOutOverviewPage.getProductPrice(productName), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckCompletePage() {
        LoginBasePage loginPage = initPage(getDriver(), LoginBasePage.class);
        ProductsBasePage productsPage = loginPage.loginAsUser(User.STANDART);
        String productName = productsPage.getNames().get(1);
        productsPage.clickAddToCartButton(productName);
        CartBasePage cartPage = productsPage.clickCartImage();
        CheckOutInformationBasePage checkOutInformationPage = cartPage.clickCheckOutButton();
        CheckOutOverviewBasePage checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        CheckOutCompleteBasePage checkOutComplete = checkOutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkOutComplete.isPageOpened(), "Check out complete is not opened");
    }
}
