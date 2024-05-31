package android;

import android.components.Product;
import android.components.ProductDetailing;
import android.pages.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import enums.SortItem;
import enums.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class MobileSampleTest implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySuccessLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Assert.assertTrue(productsPage.isPageOpened(), "Products page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyLoginUWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loginAsUser(User.LOCKED);
        Assert.assertEquals(loginPage.getErrorMessage(), "Sorry, this user has been locked out.");
        Assert.assertTrue(loginPage.isPageOpened(), "Login page isn't opened");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCard() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Product product = productsPage.getProducts().get(0);
        Assert.assertTrue(product.isImagePresent(), "Image is not present");
        Assert.assertTrue(product.getName().matches("[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+"), "Name does not match");
        Assert.assertTrue(product.getPriceText().matches("\\$[0-9]{1,2}.[0-9]{1,2}"), "Price does not match");
        Assert.assertTrue(product.isAddToCartButtonPresent(), "'Add to card' button is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifySortBy() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Assert.assertTrue(productsPage.getProducts().get(0).getPrice() > productsPage.getProducts().get(1).getPrice(), "");
        productsPage.selectSortItem(SortItem.LOWHIGH);
        Assert.assertTrue(productsPage.getProducts().get(0).getPrice() < productsPage.getProducts().get(1).getPrice(), "Sort does not work");
        productsPage.selectSortItem(SortItem.HIGHTOLOW);
        Assert.assertTrue(productsPage.getProducts().get(0).getPrice() > productsPage.getProducts().get(1).getPrice(), "Sort does not work");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductDetailPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Product product = productsPage.getProducts().get(0);
        String name = product.getName();
        String price = product.getPriceText();
        ProductDetailPage productDetailPage = product.clickProductName();
        Assert.assertEquals(productDetailPage.getProductName(), name, "Names are not equal");
        Assert.assertEquals(productDetailPage.getProductPrice(), price, "Prices are not equal");
    }
    
    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyAddToCartAndRemoveButtons() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Product product = productsPage.getProducts().get(0);
        product.clickAddToCartButton();
        Assert.assertFalse(product.isAddToCartButtonPresent(), "'Add to Cart' button is present");
        Assert.assertTrue(product.isRemoveButtonPresent(), "'Remove' button is not present");
        product.clickRemoveButton();
        Assert.assertFalse(product.isRemoveButtonPresent(), "'Remove' button is present");
        Assert.assertTrue(product.isAddToCartButtonPresent(), "'Add to Cart' button is not present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCanBeAddedToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Product product = productsPage.getProducts().get(0);
        String name = product.getName();
        String price = product.getPriceText();
        product.clickAddToCartButton();
        CartPage cartPage = productsPage.getMenu().clickCartButton();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page isn't opened");
        ProductDetailing cartProduct = cartPage.getProducts().get(0);
        Assert.assertEquals(cartProduct.getProductName(), name, "Names are not equal");
        Assert.assertEquals(cartProduct.getProductPrice(), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyProductCanBeRemoved() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        Product product = productsPage.getProducts().get(0);
        product.clickAddToCartButton();
        Assert.assertEquals(productsPage.getMenu().getCartImageText(), "1", "Sizes are not equal");
        CartPage cartPage = productsPage.getMenu().clickCartButton();
        Assert.assertEquals(cartPage.getProductsSize(), 1, "Sizes are not equal");
        cartPage.getProducts().get(0).clickRemoveButton();
        Assert.assertEquals(cartPage.getProductsSize(), 0, "Sizes are not equal");
        Assert.assertFalse(productsPage.getMenu().isCartImageTextPresent(), "Cart icon has text");
        cartPage.clickContinueShoppingButton();
        Assert.assertTrue(product.isAddToCartButtonPresent(), "'Add to Cart' button is not present");
        Assert.assertFalse(product.isRemoveButtonPresent(), "'Remove' button is present");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckOverviewPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        productsPage.getProducts().get(0).clickAddToCartButton();
        CartPage cartPage = productsPage.getMenu().clickCartButton();
        ProductDetailing cartProduct = cartPage.getProducts().get(0);
        String name = cartProduct.getProductName();
        String price = cartProduct.getProductPrice();
        String description = cartProduct.getProductDescription();
        CheckOutInformationPage checkOutInformationPage = cartPage.clickCheckOutButton();
        Assert.assertTrue(checkOutInformationPage.isPageOpened(), "Check out information page isn't opened");
        CheckOutOverviewPage checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        Assert.assertTrue(checkOutOverviewPage.isPageOpened(), "Check out overview page isn't opened");
        ProductDetailing checkOutProduct = checkOutOverviewPage.getProducts().get(0);
        Assert.assertEquals(checkOutProduct.getProductName(), name, "Names are not equal");
        Assert.assertEquals(checkOutProduct.getProductDescription(), description, "Descriptions are not equal");
        Assert.assertEquals(checkOutProduct.getProductPrice(), price, "Prices are not equal");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void verifyCheckCompletePage() {
        LoginPage loginPage = new LoginPage(getDriver());
        ProductsPage productsPage = loginPage.loginAsUser(User.STANDART);
        productsPage.getProducts().get(0).clickAddToCartButton();
        CartPage cartPage = productsPage.getMenu().clickCartButton();
        CheckOutInformationPage checkOutInformationPage = cartPage.clickCheckOutButton();
        CheckOutOverviewPage checkOutOverviewPage = checkOutInformationPage.fillOutInformationForm("Test", "Test", "94147");
        CheckOutComplete checkOutComplete = checkOutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkOutComplete.isPageOpened(), "Check out complete is not opened");
    }
}
