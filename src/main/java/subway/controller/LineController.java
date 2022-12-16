package subway.controller;

import subway.domain.Line;
import subway.domain.constant.DomainErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.option.LineOptions;
import subway.view.constant.phrase.LinePhrase;
import subway.view.constant.phrase.StationPhrase;

import java.util.List;
import java.util.Set;

public class LineController {
    private static class InstanceHolder {
        private static final LineController INSTANCE = new LineController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LineService lineService = LineService.getInstance();

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    private LineController(){}

    public static LineController getInstance() {
        return LineController.InstanceHolder.INSTANCE;
    }

    public void operate() {
        String option = Requester.requestStringInput(this::selectOption);
        handleOption(option);
    }

    private String selectOption() {
        outputView.printLineScreen();
        outputView.printOptionRequestPhrase();
        return inputView.readMainOption();
    }

    private void handleOption(String option) {
        if (option.equals(LineOptions.REGISTER.getOption())) {
            registerLine();
        }
        if (option.equals(LineOptions.DELETE.getOption())) {
            removeLine();
        }
        if (option.equals(LineOptions.FIND_ALL.getOption())) {
            showAllLines();
        }
    }

    private void registerLine() {
        String lineName = Requester.requestStringInput(() ->
                controlLineNameInput(LinePhrase.REGISTER.get()));
        String startStationName = Requester.requestStringInput(() ->
                controlStationNameInput(LinePhrase.REGISTER_START_STATION.get()));
        String endStationName = Requester.requestStringInput(() ->
                controlStationNameInput(LinePhrase.REGISTER_END_STATION.get()));

        lineService.registerLine(lineName, startStationName, endStationName);
        outputView.printInfoPhrase(LinePhrase.REGISTER_INFO.get());
    }

    private void removeLine() {
        String lineName = Requester.requestStringInput(() ->
                controlDeleteLineNameInput(LinePhrase.DELETE.get()));

        lineService.removeLine(lineName);
        outputView.printInfoPhrase(LinePhrase.DELETE_INFO.get());
    }

    // TODO: 중복 검증 기능 서비스에서 구현 후 repository 의존성 제거
    private String controlLineNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String lineName = inputView.readNonEmptyInput();
        if (lineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_LINE.get());
        }
        return lineName;
    }

    private String controlDeleteLineNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String lineName = inputView.readNonEmptyInput();
        if (!lineRepository.hasLine(lineName)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_Line.get());
        }
        return lineName;
    }

    private String controlStationNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String stationName = inputView.readNonEmptyInput();
        if (!stationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_STATION.get());
        }
        return stationName;
    }

    private void showAllLines() {
        List<String> lines = lineService.loadAllLines();
        outputView.printLines(lines);
    }
}
