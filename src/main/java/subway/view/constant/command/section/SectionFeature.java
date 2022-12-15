package subway.view.constant.command.section;

import java.util.StringJoiner;
import subway.view.constant.command.station.StationFeature;

public enum SectionFeature {
    PUT_SECTION("구간 등록"),
    DELETE_SECTION("구간 삭제");

    private static final String SEP = ". ";
    private final String featureName;
    SectionFeature(String featureName){
        this.featureName = featureName;
    }
    public String getFeatureName(){
        return (this.ordinal()+1) + SEP + this.featureName;
    }
}
