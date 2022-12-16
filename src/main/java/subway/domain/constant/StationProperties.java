package subway.domain.constant;

public enum StationProperties {
    MIN_NAME_LENGTH(2);

    private final int property;

    private StationProperties(int property) {
        this.property = property;
    }

    public int getProperty() {
        return property;
    }
}
