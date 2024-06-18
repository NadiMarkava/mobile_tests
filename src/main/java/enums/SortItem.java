package enums;

public enum SortItem {

    AZ("Name (A to Z)"),
    ZA("Name (Z to A)"),
    LOWHIGH("Price (low to high)"),
    HIGHTOLOW("Price (high to low)");

    private final String name;

    SortItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
