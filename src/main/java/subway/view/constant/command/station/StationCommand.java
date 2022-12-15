package subway.view.constant.command.station;

import java.util.StringJoiner;
import subway.view.constant.command.MainFeature;

public class StationCommand {
    private static final String PUT_STATION = StationFeature.PUT_STATION.getFeatureName();
    private static final String DELETE_STATION = StationFeature.DELETE_STATION.getFeatureName();
    private static final String VIEW_STATION = StationFeature.VIEW_STATION.getFeatureName();
    private static final String BACK = "B. 돌아가기";

    public static String getCommands(){
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(PUT_STATION);
        joiner.add(DELETE_STATION);
        joiner.add(VIEW_STATION);
        joiner.add(BACK);
        return joiner.toString();
    }
}
