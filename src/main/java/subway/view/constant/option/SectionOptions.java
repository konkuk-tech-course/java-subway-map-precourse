package subway.view.constant.option;

public enum SectionOptions {
    REGISTER("1"),
    DELETE("2");

    private final String option;

    SectionOptions(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

}
