package subway.view.constant.phrase;

import subway.view.constant.Prefix;

public enum MainPhrase {
    TITLE("메인 화면"),
    OPTION_INPUT("원하는 기능을 선택하세요.");

    private final String menu;

    MainPhrase(String menu) {
        this.menu = menu;
    }

    public String get() {
        return menu;
    }
}
