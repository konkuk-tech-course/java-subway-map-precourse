package subway.controller;

public class StationController {
    private static class InstanceHolder {
        private static final StationController INSTANCE = new StationController();
    }

    private StationController(){}

    public static StationController getInstance() {
        return StationController.InstanceHolder.INSTANCE;
    }
    
}
