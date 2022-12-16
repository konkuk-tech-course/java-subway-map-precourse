package subway.controller;

import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {
    private static class InstanceHolder {
        private static final SectionController INSTANCE = new SectionController();
    }

    private InputView inputView = InputView.getInstance();
    private OutputView outputView = OutputView.getInstance();
    private LineService lineService = LineService.getInstance();

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    private SectionController(){}

    public static SectionController getInstance() {
        return SectionController.InstanceHolder.INSTANCE;
    }
}
