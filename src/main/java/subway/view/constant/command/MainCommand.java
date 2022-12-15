package subway.view.constant.command;

import java.util.StringJoiner;

public class MainCommand {
    private static final String MANAGE_STATION = MainFeature.MNG_STATION.getFeatureName();
    private static final String MANAGE_ROUTE = MainFeature.MNG_ROUTE.getFeatureName();
    private static final String MANAGE_SECTION = MainFeature.MNG_SECTION.getFeatureName();
    private static final String PRINT_ROUTE = MainFeature.PRT_ROUTE.getFeatureName();
    private static final String QUIT = "Q. 종료";

    public static String getCommands(){
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(MANAGE_STATION);
        joiner.add(MANAGE_ROUTE);
        joiner.add(MANAGE_SECTION);
        joiner.add(PRINT_ROUTE);
        joiner.add(QUIT);
        return joiner.toString();
    }

    public static void main(String[] args) {
        System.out.println(MainCommand.getCommands());

    }
}
