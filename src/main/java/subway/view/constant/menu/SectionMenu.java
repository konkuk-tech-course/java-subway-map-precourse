package subway.view.constant.menu;

public enum SectionMenu {
    REGISTER_MENU("1. 구간 등록"),
    DELETE_MENU("2. 구간 삭제"),
    BACK("B. 돌아가기");

    private final String menu;

    SectionMenu(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }
}
