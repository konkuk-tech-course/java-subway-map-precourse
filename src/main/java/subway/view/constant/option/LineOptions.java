package subway.view.constant.option;

public enum LineOptions {
    REGISTER("1"),
    DELETE("2"),
    FIND_ALL("3");

    private final String option;

    LineOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
