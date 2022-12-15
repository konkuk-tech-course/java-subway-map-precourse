package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        // 처음 station, line 세팅
        List<Line> defaultLines = LineRepository.getLines();

        StationRepository stationRepository = new StationRepository();

        List<Station> defaultStations = stationRepository.getStations();

        while (true) {
            outputView.printMainMessage();

            String functionNumber = inputView.readFunction();
            if (functionNumber.equals("1")) {
                // 역관리 화면
                outputView.printStationManagement();
                String stationInput = inputView.readStationFunction();
                if (stationInput.equals("1")) {
                    // 역 등록
                    defaultStations.add(new Station(inputView.readStationToRegister()));
                    // 성공적으로 등록 메시지 출력
                    outputView.printWhenStationRegisteredSuccessfully();
                }
                if (stationInput.equals("2")) {
                    // 역 삭제
                    defaultStations.remove(new Station(inputView.readStationToRemove()));
                    // 없을 경우?? -> 예외처리해주기

                    // 성공적으로 삭제 메세지 출력
                    outputView.printWhenStationRemovedSuccessfully();
                }
                if (stationInput.equals("3")) {
                    // 역 조회
                    outputView.printStationList(defaultStations);
                }
                if (stationInput.equals("B")) {
                    // 돌아가기
                }
            }
            if (functionNumber.equals("2")) {
                // 노선관리 화면
                outputView.printLineManagement();
                String lineInput = inputView.readLineFunction();
                if (lineInput.equals("1")) {
                    // 노선 등록
                    String lineToRegister = inputView.readLineToRegister();
                    String upStopStationName = inputView.readUpStopStationName();
                    String downStopStationName = inputView.readDownStopStationName();

                    defaultLines.add(new Line(lineToRegister,
                            List.of(new Station(upStopStationName), new Station(downStopStationName))));
                }
                if (lineInput.equals("2")) {
                    // 노선 삭제
                    String lineToRemove = inputView.readLineToRemove();
                    defaultLines.removeIf(i -> i.getName().equals(lineToRemove));
                }
                    if (lineInput.equals("3")) {
                        // 노선 조회
                        outputView.printLineList(defaultLines);
                    }
                    if (lineInput.equals("B")) {
                        // 돌아가기
                    }

            }
            if (functionNumber.equals("3")) {
                // 구간 관리 화면
                outputView.printSectionManagement();
                String sectionInput = inputView.readSectionFunction();
                String stationToRegister = inputView.readStationToRegisterInSection();
                int order = inputView.readOrderToRegisterInSection();

                if (sectionInput.equals("1")) {
                    // 구간 등록
                    String lineToRegister = inputView.readLineToRegisterInSection();
                    for (Line defaultLine : defaultLines) {
                        if (defaultLine.getName().equals(lineToRegister)) {
                            defaultLine.getStations().set(order + 1, new Station(stationToRegister));
                            outputView.printWhenSectionRegisteredSuccessfully();
                        }
                    }

//                LineRepository.addLine(LineRepository.getLines().);
                }
                if (sectionInput.equals("2")) {
                    // 구간 삭제
                    String lineToRemove = inputView.readLineToRemove();
                    defaultLines.removeIf(i -> i.getName().equals(lineToRemove));
                }
                if (sectionInput.equals("B")) {
                    // 돌아가기
                }
            }
            if (functionNumber.equals("4")) {
                // 지하철 노선도 출력
                outputView.printSubwayLineMap(defaultLines);
            }
            if (functionNumber.equals("Q")) {
                break;
            }
        }

    }
}
