package subway.domain.constant;

public enum DomainErrorMessage {
    DUPLICATE_STATION("이미 등록된 역 이름입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    private DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message;
    }
}
