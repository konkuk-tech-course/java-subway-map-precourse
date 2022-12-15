package subway.view.constant.menu;

import subway.view.constant.Prefix;

public enum MainMenu implements Menu {
    STATION("1. 역 관리"),
    LINE("2. 노선 관리"),
    SECTION("3. 구간 관리"),
    PRINT_MAP("4. 지하철 노선도 출력"),
    QUIT("Q. 종료");

    private final String menu;

    MainMenu(String menu) {
        this.menu = menu;
    }

    @Override
    public String getMenu() {
        return menu;
    }
}
