package enums;

public enum User {

    STANDART("standard_user"),
    PASSWORD("secret_sauce"),
    LOCKED("locked_out_user"),
    PROBLEM("problem_user");

    private final String name;

    User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
