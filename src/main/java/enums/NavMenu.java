package enums;

<<<<<<< HEAD
import common.pages.LoginPageBase;
import common.pages.ProductsPageBase;
import common.pages.SwagLabsAbstractPageBase;
=======
import common.pages.*;
>>>>>>> parent of 09dca47 (reversed)

public enum NavMenu {

    ALL_ITEMS("test-ALL ITEMS", ProductsPageBase.class),

<<<<<<< HEAD
    LOG_OUT("test-LOGOUT", LoginPageBase.class);
=======
    LOG_OUT("test-LOGOUT", LoginPageBase.class),

    DRAWING("test-DRAWING", DrawingPageBase.class),

    WEB_VIEW("test-WEBVIEW", WebViewSelectionPageBase.class);
>>>>>>> parent of 09dca47 (reversed)


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
