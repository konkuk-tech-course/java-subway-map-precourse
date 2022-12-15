package subway.view.constant;

public enum ViewErrorMessage {
    EMPTY("빈 값을 입력했습니다."),
    NOT_NUMBER("숫자만 입력해주세요"),
    INVALID_OPTION("선택할 수 없는 기능입니다.");

    private final String message;

    ViewErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return Prefix.ERROR.get() + message;
    }
}
