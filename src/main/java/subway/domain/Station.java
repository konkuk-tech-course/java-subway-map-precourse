package subway.domain;

import subway.domain.constant.DomainErrorMessage;

public class Station {
    private final int MIN_LENGTH = 2;

    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (!hasCorrectLength(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_NAME_LENGTH.get());
        }
    }

    private boolean hasCorrectLength(String name) {
        return name.length() >= MIN_LENGTH;
    }
}
