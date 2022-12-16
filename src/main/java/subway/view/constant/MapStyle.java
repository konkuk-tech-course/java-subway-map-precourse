package subway.view.constant;

public enum MapStyle {
    SEPARATE_LINE("---");

    private final String style;

    MapStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }
}
