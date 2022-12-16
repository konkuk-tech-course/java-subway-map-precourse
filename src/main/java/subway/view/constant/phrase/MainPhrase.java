package subway.view.constant.phrase;

public enum MainPhrase {
    TITLE("메인 화면");

    private final String phrase;

    MainPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
