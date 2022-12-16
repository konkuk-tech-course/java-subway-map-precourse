package subway.view.constant.option;

public enum StationOptions {
    REGISTER("1"),
    DELETE("2"),
    FIND_ALL("3");

    private final String option;

    StationOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
