package subway.view.constant.phrase;

public enum CommonPhrase {
    OPTION_INPUT("원하는 기능을 선택하세요.");

    private final String phrase;

    CommonPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
