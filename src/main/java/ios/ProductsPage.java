package ios;

import android.components.Menu;
import android.components.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import common.LoginBasePage;
import common.ProductsBasePage;
import enums.SortItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductsBasePage.class)
public class ProductsPage extends ProductsBasePage {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'PRODUCTS'`]")
    private ExtendedWebElement title;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']/XCUIElementTypeOther/XCUIElementTypeOther")
    @Predicate
    private ExtendedWebElement filterIcon;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='Sort items by...']/../XCUIElementTypeOther[@name='%s']")
    @Predicate
    private ExtendedWebElement sortBy;

    @ExtendedFindBy(iosPredicate = "name == 'headerContainer'")
    private Menu menu;

    @FindBy(xpath = "//XCUIElementTypeImage[contains(@name, 'assets/src/img/')]")
    @Predicate
    private List<ExtendedWebElement> productImages;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'test-Item title')]")
    @Predicate
    private List<ExtendedWebElement> productNames;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'test-Price')]")
    private List<ExtendedWebElement> productPrices;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`][%s]")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-REMOVE'`][%s]")
    private ExtendedWebElement removeButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(title);
    }

    @Override
    public void selectSortItem(SortItem sortName) {
        filterIcon.click();
        sortBy.format(sortName.getName()).click();
    }

    @Override
    public Menu getMenu() {
        return menu;
    }
}
