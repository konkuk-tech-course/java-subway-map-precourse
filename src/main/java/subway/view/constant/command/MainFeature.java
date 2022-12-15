package subway.view.constant.command;

public enum MainFeature {
    MNG_STATION("역 관리"),
    MNG_ROUTE("노선 관리"),
    MNG_SECTION("구간 관리"),
    PRT_ROUTE("지하철 노선도 출력");

    private static final String SEP = ". ";
    private final String featureName;
    MainFeature(String featureName){
        this.featureName = featureName;
    }
    public String getFeatureName(){
        return (this.ordinal()+1) + SEP + this.featureName;
    }
}
