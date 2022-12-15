package subway.view.constant.option;

public enum Options {
    QUIT("Q"),
    BACK("B");

    private final String option;

    Options(String option) {
        this.option = option;
    }

    public String get() {
        return option;
    }
}
