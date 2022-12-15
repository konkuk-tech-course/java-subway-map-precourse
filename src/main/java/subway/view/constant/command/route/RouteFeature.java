package subway.view.constant.command.route;

public enum RouteFeature {
    PUT_ROUTE("노선 등록"),
    DELETE_ROUTE("노선 삭제"),
    VIEW_ROUTE("노선 조회");

    private static final String SEP = ". ";
    private final String featureName;
    RouteFeature(String featureName){
        this.featureName = featureName;
    }
    public String getFeatureName(){
        return (this.ordinal()+1) + SEP + this.featureName;
    }
}
