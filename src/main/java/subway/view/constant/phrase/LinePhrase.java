package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum LinePhrase {
    TITLE("노선 관리 화면"),
    REGISTER("등록할 노선 이름을 입력하세요."),
    REGISTER_START_STATION("등록할 노선의 상행 종점역 이름을 입력하세요."),
    REGISTER_END_STATION("등록할 노선의 하행 종점역 이름을 입력하세요."),
    DELETE("삭제할 노선 이름을 입력하세요.");

    private final String menu;

    LinePhrase(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }

    public String getMenuWithPreFix() {
        return Prefix.PHRASE.get() + menu;
    }
}
