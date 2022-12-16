package subway;

import subway.controller.MainController;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.view.InputView;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        initStations();
        initLines();
        InputView inputView = InputView.getInstance();
        MainController mainController = MainController.getInstance();
        mainController.operate();
    }

    public static void initStations() {
        StationRepository stationRepository = StationRepository.getInstance();
        stationRepository.addStation(new Station("교대역"));
        stationRepository.addStation(new Station("강남역"));
        stationRepository.addStation(new Station("역삼역"));
        stationRepository.addStation(new Station("남부터미널역"));
        stationRepository.addStation(new Station("양재역"));
        stationRepository.addStation(new Station("양재시민의숲역"));
        stationRepository.addStation(new Station("매봉역"));
    }

    public static void initLines() {
        LineService lineService = LineService.getInstance();
        lineService.registerLine("2호선", "교대역", "역삼역");
        lineService.registerLine("3호선", "교대역", "매봉역");
        lineService.registerLine("신분당선", "강남역", "양재시민의숲역");
    }
}
