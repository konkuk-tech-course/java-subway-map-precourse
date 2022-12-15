package subway.view.constant;

public enum Prefix {
    PHRASE("##");

    private final String prefix;

    Prefix(String prefix) {
        this.prefix = prefix;
    }

    public String get() {
        return prefix;
    }
}
