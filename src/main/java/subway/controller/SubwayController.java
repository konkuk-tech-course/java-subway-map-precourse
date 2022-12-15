package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.*;

import static subway.domain.LineRepository.addLine;
import static subway.domain.LineRepository.lines;
import static subway.domain.StationRepository.addStation;
import static subway.domain.StationRepository.stations;
import static subway.util.ErrorMessage.REGISTERED_IN_LINE;


public class SubwayController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    StationPageController stationPageController = new StationPageController();
    LinePageController linePageController = new LinePageController();
    SectionPageController sectionPageController = new SectionPageController();
    final Scanner scanner = new Scanner(System.in);
    public static Map<Line, ArrayList<Station>> stationMap = new HashMap<Line, ArrayList<Station>>();
    boolean endProgram = false;

    public void run() {
        setStationMap();
        while (!endProgram) {
            mainPage();
        }
    }



/*     1. 지하철역으로 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역이 등록되어 있다.
       2. 지하철 노선으로 2호선, 3호선, 신분당선이 등록되어 있다.
       3. 노선에 역이 아래와 같이 등록되어 있다.(왼쪽 끝이 상행 종점)
            - 2호선: 교대역 - 강남역 - 역삼역
            - 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
            - 신분당선: 강남역 - 양재역 - 양재시민의숲역*/

    public void setStationMap() {
        addStation(new Station("교대역"));
        addStation(new Station("강남역"));
        addStation(new Station("역삼역"));
        addStation(new Station("남부터미널역"));
        addStation(new Station("양재역"));
        addStation(new Station("양재시민의숲역"));
        addStation(new Station("매봉역"));
        addLine(new Line("2호선"));
        addLine(new Line("3호선"));
        addLine(new Line("신분당선"));
        ArrayList<Station> registeredStations = new ArrayList<Station>();
        registeredStations.add(stations().get(0));
        registeredStations.add(stations().get(1));
        registeredStations.add(stations().get(2));
        stationMap.put(lines().get(0), registeredStations);
        ArrayList<Station> registeredStations2 = new ArrayList<Station>();
        registeredStations2.add(stations().get(0));
        registeredStations2.add(stations().get(3));
        registeredStations2.add(stations().get(4));
        registeredStations2.add(stations().get(6));
        stationMap.put(lines().get(1), registeredStations2);
        ArrayList<Station> registeredStations3 = new ArrayList<Station>();
        registeredStations3.add(stations().get(1));
        registeredStations3.add(stations().get(4));
        registeredStations3.add(stations().get(5));
        stationMap.put(lines().get(2), registeredStations3);
    }

    public void mainPage() {
        outputView.printMainMenu();
        String mainFunction = inputView.readMainFunction();
        if (mainFunction.equals("1")) {
            stationPageController.stationPage();
        }
        if (mainFunction.equals("2")) {
            linePageController.linePage();
        }
        if (mainFunction.equals("3")) {
            sectionPageController.sectionPage();
        }
        if (mainFunction.equals("4")) {
            printStationMap();
        }
        if (mainFunction.equals("Q")) {
            endProgram = true;
        }

    }

    private void printStationMap() {
        for (Map.Entry<subway.domain.Line, ArrayList<Station>> e : stationMap.entrySet()) {
            System.out.println("[INFO] " + e.getKey().getName());
            System.out.println("[INFO] ---");
            for (int i = 0; i < e.getValue().size(); i++) {
                System.out.println("[INFO] " + e.getValue().get(i).getName());
            }
            System.out.println();
        }
    }
}
