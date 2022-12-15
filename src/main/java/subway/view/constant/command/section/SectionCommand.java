package subway.view.constant.command.section;

import java.util.StringJoiner;
import subway.view.constant.command.station.StationFeature;

public class SectionCommand {
    private static final String PUT_SECTION = SectionFeature.PUT_SECTION.getFeatureName();
    private static final String DELETE_SECTION = SectionFeature.DELETE_SECTION.getFeatureName();
    private static final String BACK = "B. 돌아가기";

    public static String getCommands(){
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(PUT_SECTION);
        joiner.add(DELETE_SECTION);
        joiner.add(BACK);
        return joiner.toString();
    }
}
