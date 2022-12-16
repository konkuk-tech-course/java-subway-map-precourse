package subway.controller;

import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.option.Options;
import subway.view.constant.option.StationOptions;
import subway.view.constant.phrase.StationPhrase;

import java.util.Set;

public class StationController {
    private static class InstanceHolder {
        private static final StationController INSTANCE = new StationController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private StationService stationService = StationService.getInstance();

    private StationController(){}

    public static StationController getInstance() {
        return StationController.InstanceHolder.INSTANCE;
    }

    public void operate() {
        String option = Requester.requestStringInput(this::selectOption);
        handleOption(option);
    }

    private String selectOption() {
        outputView.printStationScreen();
        outputView.printOptionRequestPhrase();
        return inputView.readMainOption();
    }

    private void handleOption(String option) {
        if (option.equals(StationOptions.REGISTER.getOption())) {
            registerStation();
        }
        if (option.equals(StationOptions.DELETE.getOption())) {
            removeStation();
        }
        if (option.equals(StationOptions.FIND_ALL.getOption())) {
            showAllStations();
        }
    }

    private void registerStation() {
        String stationName = Requester.requestStringInput(() -> {
            outputView.printPhrase(StationPhrase.REGISTER.get());
            return inputView.readNonEmptyInput();
        });
        stationService.registerStation(stationName);
        outputView.printInfoPhrase(StationPhrase.REGISTER_INFO.get());
    }

    private void removeStation() {
        String stationName = Requester.requestStringInput(() -> {
            outputView.printPhrase(StationPhrase.DELETE.get());
            return inputView.readNonEmptyInput();
        });
        try {
            stationService.removeStation(stationName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            removeStation();
        }
        outputView.printInfoPhrase(StationPhrase.DELETE_INFO.get());
    }

    private void showAllStations() {
        Set<String> stations = stationService.loadAllStations();
        outputView.printStations(stations);
    }

    private boolean isBack(String option) {
        return option.equals(Options.BACK.get());
    }
}
