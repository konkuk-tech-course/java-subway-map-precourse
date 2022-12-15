package subway.view.constant.command.route;

import java.util.StringJoiner;
import subway.view.constant.command.section.SectionFeature;

public class RouteCommand {
    private static final String PUT_ROUTE = RouteFeature.PUT_ROUTE.getFeatureName();
    private static final String DELETE_ROUTE = RouteFeature.DELETE_ROUTE.getFeatureName();
    private static final String VIEW_ROUTE = RouteFeature.VIEW_ROUTE.getFeatureName();
    private static final String BACK = "B. 돌아가기";

    public static String getCommands(){
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(PUT_ROUTE);
        joiner.add(DELETE_ROUTE);
        joiner.add(VIEW_ROUTE);
        joiner.add(BACK);
        return joiner.toString();
    }
}
