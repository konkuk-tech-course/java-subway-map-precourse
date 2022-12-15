package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.option.MainOptions;
import subway.view.constant.option.Options;
import subway.view.constant.option.StationOptions;

public class StationController {
    private static class InstanceHolder {
        private static final StationController INSTANCE = new StationController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();

    private StationController(){}

    public static StationController getInstance() {
        return StationController.InstanceHolder.INSTANCE;
    }

    public void operate() {
        String option = Requester.requestStringInput(inputView::readStationOption);
        handleOption(option);
    }

    private void handleOption(String option) {
        if (option.equals(StationOptions.REGISTER.getOption())) {

        }
        if (option.equals(StationOptions.DELETE.getOption())) {

        }
        if (option.equals(StationOptions.FIND_ALL.getOption())) {

        }
    }

    private boolean isBack(String option) {
        return option.equals(Options.BACK.get());
    }
}
