package subway.view.constant.phrase;

public enum StationPhrase {
    TITLE("역 관리 화면"),
    REGISTER("등록할 역 이름을 입력하세요."),
    DELETE("삭제할 역 이름을 입력하세요.");

    private final String phrase;

    StationPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
