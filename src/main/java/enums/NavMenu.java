package enums;

import common.pages.DrawingPageBase;
import common.pages.LoginPageBase;
import common.pages.ProductsPageBase;
import common.pages.SwagLabsAbstractPageBase;

public enum NavMenu {

    ALL_ITEMS("test-ALL ITEMS", ProductsPageBase.class),

    LOG_OUT("test-LOGOUT", LoginPageBase.class),

    DRAWING("test-DRAWING", DrawingPageBase.class);


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
