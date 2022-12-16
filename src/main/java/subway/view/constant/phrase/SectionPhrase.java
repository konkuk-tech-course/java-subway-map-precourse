package subway.view.constant.phrase;

public enum SectionPhrase {
    TITLE("구간 관리 화면"),
    REGISTER_LINE_INPUT("노선을 입력하세요."),
    REGISTER_STATION_INPUT("역이름을 입력하세요."),
    REGISTER_ORDER_INPUT("순서를 입력하세요."),
    DELETE_LINE_INPUT("삭제할 구간의 노선을 입력하세요."),
    DELETE_STATION_INPUT("삭제할 구간의 역을 입력하세요."),
    REGISTER_INFO("구간이 등록되었습니다."),
    DELETE_INFO("구간이 삭제되었습니다.");

    private final String phrase;

    SectionPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String get() {
        return phrase;
    }
}
