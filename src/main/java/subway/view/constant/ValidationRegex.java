package subway.view.constant;

import subway.view.constant.option.Options;

public enum ValidationRegex {
    EMPTY("^$"),
    NUMBER("^[0-9]+$"),
    MAIN_MENU("^[1-4|" + Options.QUIT.get() + "]{1}$"),
    STATION_MENU("^[1-3|" + Options.BACK.get() + "]{1}$"),
    LINE_MENU("^[1-3|" + Options.BACK.get() + "]{1}$"),
    SECTION_MENU("^[1-2|" + Options.BACK.get() + "]{1}$");

    private final String regex;

    private ValidationRegex(String regex) {
        this.regex = regex;
    }

    public String get() {
        return regex;
    }
}
