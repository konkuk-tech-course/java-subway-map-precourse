package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum StationPhrase {
    TITLE("역 관리 화면"),
    REGISTER("등록할 역 이름을 입력하세요."),
    DELETE("삭제할 역 이름을 입력하세요.");

    private final String menu;

    StationPhrase(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }
}
