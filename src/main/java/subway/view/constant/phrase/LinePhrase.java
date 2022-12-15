package subway.view.constant.phrase;

public enum LinePhrase {
    TITLE("노선 관리 화면"),
    REGISTER("등록할 노선 이름을 입력하세요."),
    REGISTER_START_STATION("등록할 노선의 상행 종점역 이름을 입력하세요."),
    REGISTER_END_STATION("등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETE("삭제할 노선 이름을 입력하세요.");

    private final String phrase;

    LinePhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
