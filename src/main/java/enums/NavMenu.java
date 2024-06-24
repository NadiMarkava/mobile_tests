package enums;
import common.pages.*;

public enum NavMenu {

    ALL_ITEMS("test-ALL ITEMS", ProductsPageBase.class),

    LOG_OUT("test-LOGOUT", LoginPageBase.class),

    WEB_VIEW("test-WEBVIEW", WebViewSelectionPageBase.class);

    private final String label;
    private final Class<? extends SwagLabsAbstractPageBase> basePage;


    NavMenu(String name, Class<? extends SwagLabsAbstractPageBase> page) {
        this.label = name;
        this.basePage = page;
    }

    public String getName() {
        return label;
    }

    public Class<? extends SwagLabsAbstractPageBase> getPage() {
        return basePage;
    }
}
