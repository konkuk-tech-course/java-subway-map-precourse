package subway.view.constant.menu;

public enum StationMenu {
    REGISTER_MENU("1. 역 등록"),
    DELETE_MENU("2. 역 삭제"),
    FIND_ALL_MENU("3. 역 조회"),
    BACK("B. 돌아가기");

    private final String menu;

    StationMenu(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }
}
