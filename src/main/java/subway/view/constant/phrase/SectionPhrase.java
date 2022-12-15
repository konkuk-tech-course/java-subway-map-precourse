package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum SectionPhrase {
    TITLE("구간 관리 화면"),
    REGISTER_MENU("1. 구간 등록"),
    DELETE_MENU("2. 구간 삭제"),
    BACK("B. 돌아가기"),
    REGISTER_LINE_INPUT("노선을 입력하세요."),
    REGISTER_STATION_INPUT("역이름을 입력하세요."),
    REGISTER_ORDER_INPUT("순서를 입력하세요."),
    DELETE_LINE_INPUT("삭제할 구간의 노선을 입력하세요."),
    DELETE_STATION_INPUT("삭제할 구간의 역을 입력하세요.");

    private final String menu;

    SectionPhrase(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public String getMenuWithPreFix() {
        return Prefix.PHRASE.get() + menu;
    }
}
