package subway.controller;

import subway.domain.constant.DomainErrorMessage;
import subway.service.LineService;
import subway.service.SectionService;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.constant.option.SectionOptions;
import subway.view.constant.phrase.SectionPhrase;

import java.util.function.BiConsumer;

public class SectionController {
    private static class InstanceHolder {
        private static final SectionController INSTANCE = new SectionController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LineService lineService = LineService.getInstance();
    private SectionService sectionService = SectionService.getInstance();
    private StationService stationService = StationService.getInstance();

    private SectionController(){}

    public static SectionController getInstance() {
        return SectionController.InstanceHolder.INSTANCE;
    }

    public void operate() {
        String option = Requester.requestStringInput(this::selectOption);
        handleOption(option);
    }

    private String selectOption() {
        outputView.printSectionScreen();
        outputView.printOptionRequestPhrase();
        return inputView.readSectionOption();
    }

    private void handleOption(String option) {
        if (option.equals(SectionOptions.REGISTER.getOption())) {
            registerSection();
        }
        if (option.equals(SectionOptions.DELETE.getOption())) {
            removeSection();
        }
    }

    private void registerSection() {
        String lineName = Requester.requestStringInput(() ->
                controlExistLineNameInput(SectionPhrase.REGISTER_LINE_INPUT.get()));
        String stationName = Requester.requestStringInput(() ->
                controlExistStationNameInput(
                        this::validateStationForRegistration,
                        SectionPhrase.REGISTER_STATION_INPUT.get(),
                        lineName
                ));
        int order = Requester.requestNumberInput(() ->
                controlRegisterOrderInput(SectionPhrase.REGISTER_ORDER_INPUT.get(), lineName));

        sectionService.registerSection(lineName, stationName, order);
        outputView.printInfoPhrase(SectionPhrase.REGISTER_INFO.get());
    }

    private void validateStationForRegistration(String lineName, String stationName) {
        stationService.validateExistStationName(stationName);
        lineService.validateAddableLine(lineName, stationName);
    }

    private int controlRegisterOrderInput(String phrase, String lineName) {
        outputView.printPhrase(phrase);
        int order = inputView.readOrder();
        if (!lineService.isCorrectOrderForRegister(lineName, order)) {
            throw new IllegalArgumentException(DomainErrorMessage.INVALID_ORDER.get());
        }
        return order;
    }

    public void removeSection() {
        String lineName = Requester.requestStringInput(() ->
                controlExistLineNameInput(SectionPhrase.REGISTER_LINE_INPUT.get()));
        String stationName = Requester.requestStringInput(() ->
                controlExistStationNameInput(
                        this::validateStationForRemove,
                        SectionPhrase.DELETE_LINE_INPUT.get(),
                        lineName
                ));

        sectionService.deleteSection(lineName, stationName);
        outputView.printInfoPhrase(SectionPhrase.DELETE_INFO.get());
    }

    private String controlExistLineNameInput(String phrase) {
        outputView.printPhrase(phrase);
        String lineName = inputView.readNonEmptyInput();
        lineService.validateExistLineName(lineName);
        return lineName;
    }

    private String controlExistStationNameInput(BiConsumer<String, String> biConsumer, String phrase, String lineName) {
        outputView.printPhrase(phrase);
        String stationName = inputView.readNonEmptyInput();
        biConsumer.accept(lineName, stationName);
        return stationName;
    }

    private void validateStationForRemove(String lineName, String stationName) {
        stationService.validateExistStationName(stationName);
        lineService.validateRemovableLine(lineName, stationName);
    }
}
