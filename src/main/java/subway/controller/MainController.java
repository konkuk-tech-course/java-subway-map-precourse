package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.option.MainOptions;
import subway.view.constant.option.Options;

public class MainController {
    private static class InstanceHolder {
        private static final MainController INSTANCE = new MainController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private StationController stationController = StationController.getInstance();

    private MainController(){}

    public static MainController getInstance() {
        return MainController.InstanceHolder.INSTANCE;
    }

    public void operate() {
        String option;
        do {
            option = Requester.requestStringInput(inputView::readMainOption);
            handleOption(option);
        } while (isRunning(option));
    }

    private void handleOption(String option) {
        if (option.equals(MainOptions.STATION.getOption())) {
            stationController.operate();
        }
        if (option.equals(MainOptions.LINE.getOption())) {

        }
        if (option.equals(MainOptions.SECTION.getOption())) {

        }
        if (option.equals(MainOptions.PRINT_MAP.getOption())) {

        }
    }

    private boolean isRunning(String option) {
        return !option.equals(Options.QUIT.get());
    }
}
