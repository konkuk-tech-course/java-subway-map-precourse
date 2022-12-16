package subway;

import subway.controller.MainController;
import subway.domain.Station;
import subway.repository.StationRepository;
import subway.service.LineService;
import subway.service.SectionService;

public class Application {
    public static void main(String[] args) {
        initStations();
        initLines();
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
        SectionService sectionService = SectionService.getInstance();
        lineService.registerLine("2호선", "교대역", "역삼역");
        lineService.registerLine("3호선", "교대역", "남부터미널역");
        sectionService.registerSection("3호선", "양재역");
        sectionService.registerSection("3호선", "매봉역");
        lineService.registerLine("신분당선", "강남역", "양재역");
        sectionService.registerSection("신분당선", "양재시민의숲역");
    }
}
