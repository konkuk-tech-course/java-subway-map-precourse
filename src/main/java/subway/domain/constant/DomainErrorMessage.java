package subway.domain.constant;

public enum DomainErrorMessage {
    INVALID_NAME_LENGTH("역이름은 최소 " + StationProperties.MIN_NAME_LENGTH.getProperty()
            + "글자 이상이어야 합니다."),
    DUPLICATE_STATION("이미 등록된 역 이름입니다."),
    NOT_EXIST_STATION("해당 역은 존재하지 않습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    private DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message;
    }
}
