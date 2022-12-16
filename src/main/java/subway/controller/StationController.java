package subway.controller;

import subway.domain.constant.DomainErrorMessage;
import subway.repository.StationRepository;
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

    private final StationRepository stationRepository = StationRepository.getInstance();

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
        return inputView.readStationOption();
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
        String stationName = Requester.requestStringInput(() ->
                controlRegisterStationNameInput(StationPhrase.REGISTER.get()));
        stationService.registerStation(stationName);
        outputView.printInfoPhrase(StationPhrase.REGISTER_INFO.get());
    }

    private void removeStation() {
        String stationName = Requester.requestStringInput(() ->
                controlDeleteStationNameInput(StationPhrase.DELETE.get()));
        stationService.removeStation(stationName);
        outputView.printInfoPhrase(StationPhrase.DELETE_INFO.get());
    }

    // TODO: 중복 검증 기능 서비스에서 구현 후 repository 의존성 제거
    private String controlRegisterStationNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String stationName = inputView.readNonEmptyInput();
        if (stationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_STATION.get());
        }
        return stationName;
    }

    private String controlDeleteStationNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String stationName = inputView.readNonEmptyInput();
        if (!stationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_STATION.get());
        }
        return stationName;
    }

    private void showAllStations() {
        Set<String> stations = stationService.loadAllStations();
        outputView.printStations(stations);
    }

    private boolean isBack(String option) {
        return option.equals(Options.BACK.get());
    }
}
