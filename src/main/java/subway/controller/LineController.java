package subway.controller;

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
        String lineName = Requester.requestStringInput(inputView::readNonEmptyInput);
        String startStationName = Requester.requestStringInput(inputView::readNonEmptyInput);
        String endStationName = Requester.requestStringInput(inputView::readNonEmptyInput);
        try {
            lineService.registerLine(lineName, startStationName, endStationName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            registerLine();
        }
        outputView.printInfoPhrase(LinePhrase.REGISTER_INFO.get());
    }

    private void removeLine() {
        String lineName = Requester.requestStringInput(inputView::readNonEmptyInput);
        try {
            lineService.removeLine(lineName);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            removeLine();
        }
        outputView.printInfoPhrase(LinePhrase.DELETE_INFO.get());
    }

    private void showAllLines() {
        List<String> lines = lineService.loadAllLines();
        outputView.printLines(lines);
    }
}
