package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum MainPhrase {
    TITLE("메인 화면"),
    STATION("1. 역 관리"),
    LINE("2. 노선 관리"),
    SECTION("3. 구간 관리"),
    PRINT_MAP("4. 지하철 노선도 출력"),
    QUIT("Q. 종료");

    private final String menu;

    MainPhrase(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }

    public String getMenuWithPreFix() {
        return Prefix.PHRASE.get() + menu;
    }
}
