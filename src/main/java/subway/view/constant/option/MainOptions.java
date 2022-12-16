package subway.view.constant.option;

public enum MainOptions {
    STATION("1"),
    LINE("2"),
    SECTION("3"),
    PRINT_MAP("4");

    private final String option;

    MainOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
