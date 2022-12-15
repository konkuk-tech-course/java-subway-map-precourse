package subway.view.constant.phrase;

public enum MainPhrase {
    TITLE("메인 화면"),
    OPTION_INPUT("원하는 기능을 선택하세요.");

    private final String phrase;

    MainPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
