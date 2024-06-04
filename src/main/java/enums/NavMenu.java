package enums;

public enum NavMenu {

    ALL_ITEMS("ALL ITEMS"),

    WEB_VIEW("WEBVIEW"),

    QA_CODE_SCANNER("QR CODE SCANNER"),

    GEO_LOCATION("GEO LOCATION"),

    DRAWING("DRAWING"),

    ABOUT("ABOUT"),

    LOG_OUT("LOGOUT"),

    RESET_APP_STATE("RESET APP STATE");

    private final String label;


    NavMenu(String name) {
        this.label = name;
    }

    public String getName() {
        return label;
    }
}
