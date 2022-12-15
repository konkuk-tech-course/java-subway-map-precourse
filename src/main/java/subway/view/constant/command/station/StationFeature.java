package subway.view.constant.command.station;

public enum StationFeature {
    PUT_STATION("역 등록"),
    DELETE_STATION("역 삭제"),
    VIEW_STATION("역 조회");

    private static final String SEP = ". ";
    private final String featureName;
    StationFeature(String featureName){
        this.featureName = featureName;
    }
    public String getFeatureName(){
        return (this.ordinal()+1) + SEP + this.featureName;
    }
}
