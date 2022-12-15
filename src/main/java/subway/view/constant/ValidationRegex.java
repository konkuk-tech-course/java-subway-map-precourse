package subway.view.constant;

public enum ValidationRegex {
    EMPTY("^$"),
    NUMBER("^[0-9]+$"),
    MAIN_OPTION("^[1-4|Q]{1}$"),
    MAIN_MENU("^[1-4|Q]{1}$"),
    STATION_MENU("^[1-3|Q]{1}$"),
    LINE_MENU("^[1-3|Q]{1}$"),
    SECTION_MENU("^[1-2|Q]{1}$");

    private final String regex;

    private ValidationRegex(String regex) {
        this.regex = regex;
    }

    public String get() {
        return regex;
    }
}
