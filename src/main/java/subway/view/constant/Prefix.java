package subway.view.constant;

public enum Prefix {
    PHRASE("## "),
    INFO("[INFO] "),
    ERROR("[ERROR] ");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String get() {
        return prefix;
    }
}
