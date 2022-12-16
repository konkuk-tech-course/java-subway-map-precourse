package subway.domain.constant;

public enum DomainErrorMessage {
    INVALID_NAME_LENGTH("역이름은 최소 " + StationProperties.MIN_NAME_LENGTH.getProperty()
            + "글자 이상이어야 합니다."),
    DUPLICATE_STATION("이미 등록된 역 이름입니다."),
    NOT_EXIST_STATION("해당 역은 존재하지 않습니다."),
    INVALID_ORDER("잘못된 순서입니다."),
    DUPLICATE_LINE("이미 등록된 호선입니다."),
    NOT_EXIST_Line("해당 호선은 존재하지 않습니다."),
    CANNOT_BE_ADDED_TO_LINE("이미 해당 호선에 포함된 역입니다."),
    CANNOT_BE_REMOVED_FROM_LINE("해당 호선에 존재하지 않는 역입니다.");

    private final String message;

    private DomainErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
