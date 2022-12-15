package subway.view.constant.menu;

import subway.view.constant.Prefix;

public enum LineMenu {
    REGISTER_MENU("1. 노선 등록"),
    DELETE_MENU("2. 노선 삭제"),
    FIND_ALL_MENU("3. 노선 조회"),
    BACK("B. 돌아가기");

    private final String menu;

    LineMenu(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }
}
