package common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class WebViewSelectionPageBase extends SwagLabsAbstractPageBase implements IMobileUtils {

    public WebViewSelectionPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickGoToSiteButton();

    public abstract void typeUrl(String url);

    public abstract WebViewPageBase navigateToWebViewPage(String url);
}
