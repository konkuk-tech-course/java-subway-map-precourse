package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum StationPhrase {
    TITLE("역 관리 화면"),
    REGISTER_MENU("1. 역 등록"),
    DELETE_MENU("2. 역 삭제"),
    FIND_ALL_MENU("3. 역 조회"),
    BACK("B. 돌아가기"),
    REGISTER("등록할 역 이름을 입력하세요."),
    DELETE("삭제할 역 이름을 입력하세요.");

    private final String menu;

    StationPhrase(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }

    public String getMenuWithPreFix() {
        return Prefix.PHRASE.get() + menu;
    }
}
