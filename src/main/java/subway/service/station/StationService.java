package subway.service.station;

import subway.domain.StationRepository;
import subway.view.OutputView;
import subway.view.StationView;
import subway.view.util.InputView;

public class StationService{
    private static final StationView view = new StationView(new InputView(), new OutputView());
    private static final StationRepository repository = new StationRepository();



}